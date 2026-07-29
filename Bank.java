import java.io.*;
import java.util.*;

// This is my Bank class.
// It manages all accounts using a HashMap.
// It also handles saving/loading accounts to a file.
public class Bank {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private final String FILE_NAME = "accounts.txt";

    // Add account but reject duplicates
    public void addAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            System.out.println("Account number already exists. Choose a different number.");
        } else {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Account created successfully.");
        }
    }

    // Find account by number
    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    // Transfer money between accounts
    public void transfer(int fromAcc, int toAcc, double amount) {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);
        if (from != null && to != null) {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transferred " + amount + " from " + fromAcc + " to " + toAcc);
            } else {
                System.out.println("Insufficient funds for transfer.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    // List all accounts
    public void listAccounts() {
        for (Account acc : accounts.values()) {
            System.out.println(acc);
        }
    }

    // Save accounts to file
    public void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts.values()) {
                writer.println(acc);
            }
            System.out.println("Accounts saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts from file
    public void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int accNum = Integer.parseInt(parts[0]);
                String owner = parts[1];
                double balance = Double.parseDouble(parts[2]);
                String type = parts[3];
                if (type.equals("Savings")) {
                    addAccount(new SavingsAccount(accNum, owner, balance, 0.05));
                } else if (type.equals("Checking")) {
                    addAccount(new CheckingAccount(accNum, owner, balance, 500));
                }
            }
            System.out.println("Accounts loaded from file.");
        } catch (IOException e) {
            System.out.println("No existing accounts file found.");
        }
    }
}
