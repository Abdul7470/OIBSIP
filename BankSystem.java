import java.util.Scanner;

class Account {
    private int balance;
    private int lastTransaction;
    private String customerName;
    private String customerId;
    private int loginAttempts = 0;

    // Constructor to initialize account
    Account(String name, String id) {
        customerName = name;
        customerId = id;
    }

    // Clear the console
    private void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    // Authenticate customer ID
    private void authenticate() {
        clearConsole();
        System.out.println("Welcome, " + customerName + "!");
        System.out.print("Enter your Customer ID to log in: ");
        Scanner scanner = new Scanner(System.in);
        String inputId = scanner.nextLine();
    
        if (inputId.equals(customerId)) {
            clearConsole();
            displayMenu();
        } else {
            System.out.println("Incorrect ID. Please try again.");
            System.out.println("Press Enter to continue...");
            scanner.nextLine(); // Wait for the user to press Enter
    
            if (loginAttempts < 3) {
                loginAttempts++;
                authenticate();
            } else {
                System.out.println("Too many failed attempts. Exiting...");
            }
        }
    }
    

    // Deposit money
    private void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            lastTransaction = amount;
        }
    }

    // Withdraw money
    private void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            lastTransaction = -amount;
        } else {
            clearConsole();
            System.out.println("Insufficient balance.");
        }
    }

    // Show last transaction
    private void showLastTransaction() {
        if (lastTransaction > 0) {
            System.out.println("Last Deposit: $" + lastTransaction);
        } else if (lastTransaction < 0) {
            System.out.println("Last Withdrawal: $" + Math.abs(lastTransaction));
        } else {
            System.out.println("No transactions yet.");
        }
    }

    // Transfer funds
    private void transfer(int amount, Account recipient) {
        if (balance >= amount) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("---------------------------------");
            System.out.println("Transfer Successful!");
            System.out.println("Transferred Amount: $" + amount);
            System.out.println("Recipient Name: " + recipient.customerName);
            System.out.println("Recipient ID: " + recipient.customerId);
            System.out.println("Your New Balance: $" + balance);
            System.out.println("---------------------------------");
        } else {
            System.out.println("---------------------------------");
            System.out.println("Transfer Failed. Insufficient Balance.");
            System.out.println("---------------------------------");
        }
    }
    

    // Display menu
    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Last Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    clearConsole();
                    System.out.println("Current Balance: $" + balance);
                    break;

                case 2:
                    clearConsole();
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    break;

                case 3:
                    clearConsole();
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    clearConsole();
                    showLastTransaction();
                    break;

                case 5:
                    clearConsole();
                    System.out.print("Enter amount to transfer: ");
                    int transferAmount = scanner.nextInt();
                    Account recipient = new Account("MURTAZA", "1001");
                    transfer(transferAmount, recipient);
                    break;

                case 6:
                    clearConsole();
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 6);
    }

    // Entry point for customer authentication
    public void start() {
        authenticate();
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Account myAccount = new Account("ABDUL QADIR", "1022");
        myAccount.start();
    }
}
