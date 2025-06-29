package com.kavya.JUnit_advance;


import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void initialize() {
        System.out.println("🟢 Test 1 - Initialization");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void cleanup() {
        System.out.println("🟡 Test 3 - Cleanup");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    void process() {
        System.out.println("🔵 Test 2 - Processing");
        Assertions.assertTrue(true);
    }
}
