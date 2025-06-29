package com.kavya.JUnit_advance;

public class ExceptionThrower {

    public void throwException(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed!");
        }
        System.out.println("Valid number: " + number);
    }
}
