package com.kavya.JUnit_advance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskTimeout() {
        PerformanceTester tester = new PerformanceTester();

        System.out.println("Checking task finishes in under 2 seconds...");
        assertTimeout(Duration.ofSeconds(2), () -> tester.performTask());
    }
}
