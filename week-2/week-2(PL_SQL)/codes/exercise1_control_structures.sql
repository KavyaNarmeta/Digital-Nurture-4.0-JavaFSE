-- 📁 File: exercise1_control_structures.sql
-- Scenario 1: Reduce interest rate for customers older than 60 years
BEGIN
  FOR cust IN (SELECT * FROM Customers) LOOP
    IF TRUNC(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;
END;
/

-- Scenario 2: Print VIP customers with balance > 10000
SET SERVEROUTPUT ON;
BEGIN
  FOR cust IN (SELECT * FROM Customers) LOOP
    IF cust.Balance > 10000 THEN
      DBMS_OUTPUT.PUT_LINE('Customer ' || cust.Name || ' promoted to VIP');
    END IF;
  END LOOP;
END;
/

-- Scenario 3: Remind customers whose loans are due in the next 30 days
SET SERVEROUTPUT ON;
BEGIN
  FOR loan IN (
    SELECT * FROM Loans 
    WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan for Customer ID ' || loan.CustomerID || ' is due on ' || TO_CHAR(loan.EndDate, 'YYYY-MM-DD')
    );
  END LOOP;
END;
/
