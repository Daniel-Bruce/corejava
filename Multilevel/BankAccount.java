package Multilevel;

// BankAccount.java
public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected double interestRate;

    public BankAccount(String accountNumber, double initialBalance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
}

// SavingsAccount.java
class SavingsAccount extends BankAccount {
    private double minimumBalance;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate, double minimumBalance) {
        super(accountNumber, initialBalance, interestRate);
        this.minimumBalance = minimumBalance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient funds or balance below minimum required.");
        }
    }
}

// FixedDepositAccount.java
class FixedDepositAccount extends SavingsAccount {
    private int term;  // term in months

    public FixedDepositAccount(String accountNumber, double initialBalance, double interestRate, double minimumBalance, int term) {
        super(accountNumber, initialBalance, interestRate, minimumBalance);
        this.term = term;
    }

    public double getInterest() {
        // Calculate interest based on the term and interest rate
        double interest = (balance * interestRate * term) / 100;
        return interest;
    }
}

// Main.java
class Main {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount bankAccount = new BankAccount("123456", 1000.00, 2.5);
        bankAccount.deposit(500.00);

        // Create a SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount("234567", 2000.00, 3.0, 100.00);
        savingsAccount.deposit(300.00);
        savingsAccount.withdraw(150.00);

        // Create a FixedDepositAccount object
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("345678", 5000.00, 4.0, 500.00, 12);
        fixedDepositAccount.deposit(500.00);
        System.out.println("Interest earned: " + fixedDepositAccount.getInterest());
    }
}
