import java.io.Serializable;

// This is my abstract Account class.
// It holds common properties (account number, owner name, balance)
// and provides default deposit/withdraw logic.
// I make it abstract because I don’t want to create "just an Account",
// but rather specific types like Savings or Checking.
public abstract class Account implements Transaction, Serializable {
    protected int accountNumber;
    protected String ownerName;
    protected double balance;

    // Constructor to initialize account details
    public Account(int accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Getters for account info
    public int getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    // Default deposit logic
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Default withdraw logic
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Each subclass must say what type it is
    public abstract String getAccountType();

    // I use toString() to save account info into a file easily
    @Override
    public String toString() {
        return accountNumber + "," + ownerName + "," + balance + "," + getAccountType();
    }
}
