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
        } 
        else if (value > 100) {
            throw new CustomException("Value cannot be greater than 100.");
        } 
        else {
            System.out.println("Task performed successfully.");
        }
    }
}

// Main Class
public class practical3b {

    public static void main(String[] args) {

        ExceptionDemo demo = new ExceptionDemo();

        try {
            demo.performTask(50);    // Valid
            demo.performTask(-10);   // Exception
            demo.performTask(120);   // Won't execute because previous exception is caught
        } 
        catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
    }
}