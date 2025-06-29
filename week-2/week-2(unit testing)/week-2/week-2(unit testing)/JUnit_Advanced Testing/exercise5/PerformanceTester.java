package com.kavya.JUnit_advance;

public class PerformanceTester {

    public void performTask() {
        try {
            // Simulate a long-running task
            System.out.println("Task started...");
            Thread.sleep(1000); // 1 second delay
            System.out.println("Task completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
