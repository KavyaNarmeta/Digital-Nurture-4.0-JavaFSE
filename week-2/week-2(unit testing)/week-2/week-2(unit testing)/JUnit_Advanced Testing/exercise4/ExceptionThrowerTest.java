package com.kavya.JUnit_advance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();

        System.out.println("🔴 Testing with -5 (should throw exception)");
        assertThrows(IllegalArgumentException.class, () -> thrower.throwException(-5));

        System.out.println("🟢 Testing with 10 (should not throw)");
        assertDoesNotThrow(() -> thrower.throwException(10));
    }
}
