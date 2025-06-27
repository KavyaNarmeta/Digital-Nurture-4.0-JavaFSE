SET SERVEROUTPUT ON;

-- 🧹 Clean up old test data
DELETE FROM Transactions WHERE TransactionID IN (10,11,12);
DELETE FROM AuditLog WHERE Action LIKE 'Transaction Inserted – acct%';
COMMIT;

-- ─────────────────────────────────────────────────────────
-- 1️⃣ Trigger: UpdateCustomerLastModified
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
  DBMS_OUTPUT.PUT_LINE('CustomerID ' || :NEW.CustomerID || ' LastModified updated to ' ||
                       TO_CHAR(:NEW.LastModified, 'YYYY-MM-DD HH24:MI:SS'));
END;
/
-- Test update to fire the trigger
UPDATE Customers SET Balance = Balance + 100 WHERE CustomerID = 2;
/

-- ─────────────────────────────────────────────────────────
-- 2️⃣ Trigger: LogTransaction
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog(Action, LogDate)
    VALUES('Transaction Inserted – acct ' || :NEW.AccountID, SYSDATE);
  DBMS_OUTPUT.PUT_LINE('AuditLog inserted for TransactionID ' || :NEW.TransactionID);
END;
/
-- Test insert to fire the trigger
INSERT INTO Transactions(TransactionID, AccountID, TransactionType, Amount, TransactionDate)
VALUES(10, 101, 'Deposit', 250, SYSDATE);
/
INSERT INTO Transactions(TransactionID, AccountID, TransactionType, Amount, TransactionDate)
VALUES(11, 101, 'Deposit', 500, SYSDATE);
/

-- ─────────────────────────────────────────────────────────
-- 3️⃣ Trigger: CheckTransactionRules
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;

  IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > v_balance THEN
    DBMS_OUTPUT.PUT_LINE('Blocking withdrawal of ' || :NEW.Amount);
    RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance for withdrawal');
  ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
    DBMS_OUTPUT.PUT_LINE('Blocking invalid deposit of ' || :NEW.Amount);
    RAISE_APPLICATION_ERROR(-20004, 'Invalid deposit amount');
  END IF;
END;
/
-- Test invalid withdrawal
BEGIN
  INSERT INTO Transactions(TransactionID, AccountID, TransactionType, Amount, TransactionDate)
  VALUES(12, 102, 'Withdrawal', 999999, SYSDATE);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Expected error: ' || SQLERRM);
END;
/

-- ─────────────────────────────────────────────────────────
-- ✅ Verify results
SELECT LogID, Action, TO_CHAR(LogDate,'YYYY-MM-DD HH24:MI:SS') AS LoggedAt
  FROM AuditLog ORDER BY LogDate DESC;
