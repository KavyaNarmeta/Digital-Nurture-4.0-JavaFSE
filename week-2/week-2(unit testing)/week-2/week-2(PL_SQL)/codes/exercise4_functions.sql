SET DEFINE OFF;
SET SERVEROUTPUT ON;

-- 1. CalculateAge: Returns age in years based on DOB
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
  v_age NUMBER;
BEGIN
  v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
  RETURN v_age;
END;
/

-- 2. CalculateMonthlyInstallment: Uses loan amount, rate, years to calculate EMI
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  p_loan  NUMBER,
  p_rate  NUMBER,
  p_years NUMBER
) RETURN NUMBER IS
  v_months NUMBER := p_years * 12;
  v_r      NUMBER := p_rate / (12 * 100);
  v_emi    NUMBER;
BEGIN
  v_emi := (p_loan * v_r * POWER(1 + v_r, v_months)) /
           (POWER(1 + v_r, v_months) - 1);
  RETURN v_emi;
END;
/

-- 3. HasSufficientBalance: Checks if account has at least p_amount
CREATE OR REPLACE FUNCTION HasSufficientBalance(
  p_account_id NUMBER,
  p_amount     NUMBER
) RETURN BOOLEAN IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
  RETURN (v_balance >= p_amount);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/

-- ✅ TEST BLOCKS BELOW — Press F5 to run all at once

DECLARE
  v_age    NUMBER;
  v_emi    NUMBER;
  v_enough BOOLEAN;
BEGIN
  -- Test 1: Age of a 30-year-old
  v_age := CalculateAge(TO_DATE('1993-06-01','YYYY-MM-DD'));
  DBMS_OUTPUT.PUT_LINE('Age (should be ~30): ' || v_age);

  -- Test 2: EMI for ₹100,000 @ 7% over 5 years
  v_emi := CalculateMonthlyInstallment(100000, 7, 5);
  DBMS_OUTPUT.PUT_LINE('EMI (₹100k,7%,5yr): ' || ROUND(v_emi,2));

  -- Test 3: Check sufficient balance between accounts
  v_enough := HasSufficientBalance(102, 5000);
  DBMS_OUTPUT.PUT_LINE('Acct 102 has ≥5000: ' || CASE WHEN v_enough THEN 'TRUE' ELSE 'FALSE' END);

  v_enough := HasSufficientBalance(999, 100);  -- invalid account
  DBMS_OUTPUT.PUT_LINE('Acct 999 exists & has ≥100: ' || CASE WHEN v_enough THEN 'TRUE' ELSE 'FALSE' END);
END;
/
