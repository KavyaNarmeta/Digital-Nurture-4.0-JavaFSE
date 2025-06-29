package com.kavya.test.junit_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3, "Sum should be 5");

        // Assert true
        assertTrue(5 > 3, "5 is greater than 3");

        // Assert false
        assertFalse(5 < 3, "5 is not less than 3");

        // Assert null
        String value = null;
        assertNull(value, "Value should be null");

        // Assert not null
        String name = "Kavya";
        assertNotNull(name, "Name should not be null");
    }
}
