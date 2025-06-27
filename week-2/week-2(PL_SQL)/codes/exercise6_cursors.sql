SET SERVEROUTPUT ON;

-- Scenario 1: Explicit cursor to list this month's transactions
DECLARE
  CURSOR trans_cursor IS
    SELECT AccountID, TransactionType, Amount
    FROM Transactions
    WHERE TransactionDate >= TRUNC(SYSDATE, 'MM');

  v_acc  NUMBER;
  v_type VARCHAR2(20);
  v_amt  NUMBER;
BEGIN
  OPEN trans_cursor;
  LOOP
    FETCH trans_cursor INTO v_acc, v_type, v_amt;
    EXIT WHEN trans_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Account ' || v_acc || ': ' || v_type || ' of ' || v_amt);
  END LOOP;
  CLOSE trans_cursor;
END;
/

-- Scenario 2: Cursor FOR loop to deduct ₹100 from each account
BEGIN
  FOR acc_rec IN (SELECT AccountID FROM Accounts) LOOP
    UPDATE Accounts
      SET Balance = Balance - 100
      WHERE AccountID = acc_rec.AccountID;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' account(s) deducted ₹100 each.');
END;
/

-- Scenario 3: Cursor FOR loop to reduce loan interest rate by 5%
BEGIN
  FOR loan_rec IN (SELECT LoanID FROM Loans) LOOP
    UPDATE Loans
      SET InterestRate = InterestRate * 0.95
      WHERE LoanID = loan_rec.LoanID;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' loan(s) interest rate reduced by 5%.');
END;
/
