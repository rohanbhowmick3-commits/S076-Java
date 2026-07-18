package com.mycompany.practical3;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception for invalid deposit
class InvalidDepositException extends Exception {
    public InvalidDepositException(String message) {
        super(message);
    }
}

// Bank Account class
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0)
            balance = 0;
        else
            balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0)
            throw new InvalidDepositException("Deposit amount must be greater than 0.");

        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance.");

        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Main Class
public class Practical3 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        account.displayBalance();

        try {
            account.deposit(2000);
            account.withdraw(8000);
        } catch (InvalidDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal Error: " + e.getMessage());
        }

        try {
            account.deposit(-500);
        } catch (InvalidDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        }

        account.displayBalance();
    }
}