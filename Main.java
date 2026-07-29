import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadAccounts();
        Scanner scanner = new Scanner(System.in);

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
                    System.out.print("Enter account number: ");
                    int sAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String sOwner = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double sBalance = scanner.nextDouble();
                    bank.addAccount(new SavingsAccount(sAccNum, sOwner, sBalance, 0.05));
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int cAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String cOwner = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double cBalance = scanner.nextDouble();
                    bank.addAccount(new CheckingAccount(cAccNum, cOwner, cBalance, 500));
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int dAccNum = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double dAmount = scanner.nextDouble();
                    Account dAcc = bank.getAccount(dAccNum);
                    if (dAcc != null) dAcc.deposit(dAmount);
                    else System.out.println("Account not found.");
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int wAccNum = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double wAmount = scanner.nextDouble();
                    Account wAcc = bank.getAccount(wAccNum);
                    if (wAcc != null) wAcc.withdraw(wAmount);
                    else System.out.println("Account not found.");
                    break;
                case 5:
                    System.out.print("Enter source account number: ");
                    int fromAcc = scanner.nextInt();
                    System.out.print("Enter destination account number: ");
                    int toAcc = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double tAmount = scanner.nextDouble();
                    bank.transfer(fromAcc, toAcc, tAmount);
                    break;
                case 6:
                    bank.listAccounts();
                    break;
                case 7:
                    bank.saveAccounts();
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
