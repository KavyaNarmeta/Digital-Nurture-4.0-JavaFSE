package com.kavya.JUnit_advance;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest(name = "isEven({0}) => true")
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEvenTrue(int number) {
    	 System.out.println("Testing even: " + number);
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest(name = "isEven({0}) => false")
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEvenFalse(int number) {
    	 System.out.println("Testing even: " + number);
        assertFalse(checker.isEven(number));
    }
}
