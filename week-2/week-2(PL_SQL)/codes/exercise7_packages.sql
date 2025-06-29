SET SERVEROUTPUT ON;

-- 📦 Package 1: CustomerManagement
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_name || ' added.');
  EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_id || ' already exists.');
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Customers SET Name = p_name WHERE CustomerID = p_id;
    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Customer ' || p_id || ' not found.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Customer ' || p_id || ' name updated to ' || p_name);
    END IF;
  END;

  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
    RETURN v_balance;
  EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  END;
END CustomerManagement;
/

-- Test calls
BEGIN
  CustomerManagement.AddCustomer(7, 'Eve', TO_DATE('1995-04-12','YYYY-MM-DD'), 7000);
END;
/

BEGIN
  CustomerManagement.UpdateCustomer(7, 'Eva');
END;
/

DECLARE
  v_bal NUMBER;
BEGIN
  v_bal := CustomerManagement.GetBalance(7);
  DBMS_OUTPUT.PUT_LINE('Balance for ID=7: ' || v_bal);
END;
/

-- 📦 Package 2: EmployeeManagement
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_sal NUMBER, p_dept VARCHAR2);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_sal NUMBER, p_dept VARCHAR2) IS
  BEGIN
    INSERT INTO Employees VALUES(p_id, p_name, p_pos, p_sal, p_dept, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Employee ' || p_name || ' hired.');
  EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Employee ' || p_id || ' already exists.');
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Employees SET Name = p_name WHERE EmployeeID = p_id;
    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Employee ' || p_id || ' not found.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Employee ' || p_id || ' name updated to ' || p_name);
    END IF;
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  END;
END EmployeeManagement;
/

-- Test calls
BEGIN
  EmployeeManagement.HireEmployee(304, 'Lina', 'Analyst', 40000, 'IT');
END;
/

BEGIN
  EmployeeManagement.UpdateEmployee(304, 'Lina Rao');
END;
/

DECLARE
  v_annual NUMBER;
BEGIN
  v_annual := EmployeeManagement.GetAnnualSalary(304);
  DBMS_OUTPUT.PUT_LINE('Annual Salary for 304: ' || v_annual);
END;
/

-- 📦 Package 3: AccountOperations
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts VALUES(p_id, p_cust_id, p_type, p_balance, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Account ' || p_id || ' opened.');
  EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Account ' || p_id || ' already exists.');
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' account(s) closed.');
  END;

  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
    RETURN NVL(v_total,0);
  END;
END AccountOperations;
/

-- Test calls
BEGIN
  AccountOperations.OpenAccount(104, 7, 'Savings', 5000);
END;
/

BEGIN
  AccountOperations.CloseAccount(104);
END;
/

DECLARE
  v_sum NUMBER;
BEGIN
  v_sum := AccountOperations.GetTotalBalance(1);
  DBMS_OUTPUT.PUT_LINE('Total balance for Customer 1: ' || v_sum);
END;
/
