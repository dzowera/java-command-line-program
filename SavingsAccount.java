public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate;
        System.out.println("Interest applied. New balance: " + balance);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
