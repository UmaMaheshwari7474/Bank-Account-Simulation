
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(
            "Uma",
            "ACC1001",
            5000.00
        );
        int choice=0;
        do {
            System.out.println("\n===== BANK ACCOUNT SIMULATION =====");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    if (scanner.hasNextDouble()) {
                        account.deposit(scanner.nextDouble());
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.next();
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    if (scanner.hasNextDouble()) {
                        account.withdraw(scanner.nextDouble());
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.next();
                    }
                    break;

                case 4:
                    account.displayTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using our system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
        scanner.close();
    }
}