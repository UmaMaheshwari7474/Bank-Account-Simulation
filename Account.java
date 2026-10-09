
import java.util.ArrayList;
import java.util.List;
public class Account {
    private final String accountHolder;
    private final String accountNumber;
    private double balance;
    private final List<String> transactionHistory;

    public Account(String accountHolder, String accountNumber,
                   double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative."
            );
        }
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(
            String.format("Account opened with balance: Rs. %.2f",
                          initialBalance)
        );
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add(
            String.format("Deposited: Rs. %.2f | Balance: Rs. %.2f",
                          amount, balance)
        );
        System.out.println("Deposit successful.");
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            transactionHistory.add(
                String.format("Failed withdrawal: Rs. %.2f", amount)
            );
            return;
        }
        balance -= amount;
        transactionHistory.add(
            String.format("Withdrawn: Rs. %.2f | Balance: Rs. %.2f",
                          amount, balance)
        );
        System.out.println("Withdrawal successful.");
    }
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }
    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}