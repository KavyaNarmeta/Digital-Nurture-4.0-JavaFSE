SET SERVEROUTPUT ON;

-- Scenario 1: ProcessMonthlyInterest – apply 1% monthly interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance * 1.01
  WHERE AccountType = 'Savings';
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated with interest.');
END;
/

-- Scenario 2: UpdateEmployeeBonus – give a percentage bonus to a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_dept VARCHAR2, p_bonus NUMBER) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus / 100)
  WHERE Department = p_dept;
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) in ' || p_dept || ' updated with ' || p_bonus || '% bonus.');
END;
/

-- Scenario 3: TransferFunds – raise error if insufficient balance
CREATE OR REPLACE PROCEDURE TransferFunds(p_from NUMBER, p_to NUMBER, p_amount NUMBER) IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;

  DBMS_OUTPUT.PUT_LINE('Funds transferred: ' || p_amount || ' from ' || p_from || ' to ' || p_to);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Source account not found.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- ✅ TEST CALLS below to generate combined output in Script Output tab:

BEGIN
  ProcessMonthlyInterest;
END;
/

BEGIN
  UpdateEmployeeBonus('Finance', 5);
END;
/

BEGIN
  TransferFunds(103, 102, 300);
END;
/

BEGIN
  TransferFunds(102, 101, 100000);
END;
/
