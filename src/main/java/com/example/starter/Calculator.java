package com.example.starter;

/**
 * A simple calculator class that provides basic arithmetic operations.
 * This class can be used to perform addition, subtraction, multiplication,
 * and division of two integers.
 */
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
