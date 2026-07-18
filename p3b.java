package com.mycompany.practical3;

// Custom Exception Class
class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }
}

// Exception Demo Class
class ExceptionDemo {

    public void performTask(int value) throws CustomException {

        if (value < 0) {
            throw new CustomException("Value cannot be negative.");
        } else if (value > 100) {
            throw new CustomException("Value cannot be greater than 100.");
        } else {
            System.out.println("Task performed successfully for value: " + value);
        }
    }
}

// Main Class
public class p3b {

    public static void main(String[] args) {

        ExceptionDemo demo = new ExceptionDemo();

        // First Value
        try {
            demo.performTask(50);
        } catch (CustomException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Second Value
        try {
            demo.performTask(-10);
        } catch (CustomException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Third Value
        try {
            demo.performTask(120);
        } catch (CustomException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}