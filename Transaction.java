// This is my interface for transactions.
// I want all accounts to be able to deposit and withdraw money,
// so I force them to implement these two methods.
public interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
}
