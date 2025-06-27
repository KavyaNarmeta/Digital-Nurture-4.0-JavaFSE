package com.kavya.test.junit_demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    private Calculator calc;

    // 🔧 Setup (Before Each Test)
    @BeforeEach
    void setUp() {
        System.out.println("Setting up Calculator instance...");
        calc = new Calculator(); // Arrange
    }

    // 🧹 Teardown (After Each Test)
    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after test...");
        calc = null;
    }

    @Test
    void testAddition() {
        // Arrange done in setUp()

        // Act
        int result = calc.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testSubtraction() {
        int result = calc.subtract(10, 3);
        assertEquals(7, result);
    }

    @Test
    void testMultiplication() {
        int result = calc.multiply(4, 5);
        assertEquals(20, result);
    }

    @Test
    void testDivision() {
        int result = calc.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    void testDivideByZero() {
        // Act & Assert
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
