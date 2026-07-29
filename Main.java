import java.util.Scanner;

// This is my Main class.
// It runs the banking system and provides a command-line menu.
// I want users to interact with the Bank class through simple options.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(); // I create a Bank object to manage accounts
        bank.loadAccounts();    // Load saved accounts when the program starts
        Scanner scanner = new Scanner(System.in);

        // I use a loop so the menu keeps showing until the user chooses to exit
        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. List Accounts");
            System.out.println("7. Save & Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create Savings Account
                    System.out.print("Enter account number: ");
                    int sAccNum = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter owner name: ");
                    String sOwner = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double sBalance = scanner.nextDouble();
                    // I set interest rate to 5% by default
                    bank.addAccount(new SavingsAccount(sAccNum, sOwner, sBalance, 0.05));
                    break;

                case 2:
                    // Create Checking Account
                    System.out.print("Enter account number: ");
                    int cAccNum = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter owner name: ");
                    String cOwner = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double cBalance = scanner.nextDouble();
                    // I set overdraft limit to 500 by default
                    bank.addAccount(new CheckingAccount(cAccNum, cOwner, cBalance, 500));
                    break;

                case 3:
                    // Deposit money
                    System.out.print("Enter account number: ");
                    int dAccNum = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double dAmount = scanner.nextDouble();
                    Account dAcc = bank.getAccount(dAccNum);
                    if (dAcc != null) {
                        dAcc.deposit(dAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Withdraw money
                    System.out.print("Enter account number: ");
                    int wAccNum = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double wAmount = scanner.nextDouble();
                    Account wAcc = bank.getAccount(wAccNum);
                    if (wAcc != null) {
                        wAcc.withdraw(wAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    // Transfer money between accounts
                    System.out.print("Enter source account number: ");
                    int fromAcc = scanner.nextInt();
                    System.out.print("Enter destination account number: ");
                    int toAcc = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double tAmount = scanner.nextDouble();
                    bank.transfer(fromAcc, toAcc, tAmount);
                    break;

                case 6:
                    // List all accounts
                    bank.listAccounts();
                    break;

                case 7:
                    // Save accounts to file and exit program
                    bank.saveAccounts();
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
