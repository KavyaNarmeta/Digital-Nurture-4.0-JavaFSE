SET SERVEROUTPUT ON;

-- 1. AddNewCustomer: Safely insert a new customer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_id      NUMBER,
  p_name    VARCHAR2,
  p_dob     DATE,
  p_balance NUMBER
) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
  DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Customer already exists');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Unexpected Error: ' || SQLERRM);
END;
/
  
-- 2. SafeTransferFunds: Transfer funds only if balance allows
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from   NUMBER,
  p_to     NUMBER,
  p_amount NUMBER
) IS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = p_from;
  IF from_balance >= p_amount THEN
    UPDATE Accounts
      SET Balance = Balance - p_amount
      WHERE AccountID = p_from;
    UPDATE Accounts
      SET Balance = Balance + p_amount
      WHERE AccountID = p_to;
    DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient funds.');
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('One of the accounts does not exist.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


-- 3. UpdateSalary: Increase salary if employee exists
CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_empID     NUMBER,
  p_increment NUMBER
) IS
BEGIN
  UPDATE Employees
     SET Salary = Salary + p_increment
   WHERE EmployeeID = p_empID;
  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Employee not found.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
  
-- ✅ TEST CALLS: Run all at once to display combined output
BEGIN
  AddNewCustomer(5, 'Ravi', TO_DATE('1985-03-25','YYYY-MM-DD'), 12000);
END;
/

BEGIN
  SafeTransferFunds(101, 102, 500);
END;
/

BEGIN
  UpdateSalary(201, 1000);
END;
/

BEGIN
  AddNewCustomer(6, 'Kiran', TO_DATE('1992-07-20','YYYY-MM-DD'), 15000);
END;
/
