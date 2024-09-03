package Inheritance.SIngleLevel;

public class BankAccount {
    int accountNumber;
    double balance;
    double interestRate;


    public BankAccount(int accountNumber,double balance, double interestRate){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;

    }

    public void deposit(double amount){
        if (amount > 0) {
            balance+=amount;
            System.out.println("Amount deposited:"+amount);
        }else{
            System.out.println("Deposit must be positive!");
        }
    }

    public double getBalance() {
        return balance;
    }

}

class SavingsAccount extends BankAccount{
    double minimumBalance;
    public SavingsAccount(int accountNumber,double balance, double interestRate,double amount,double minimumBalance){
        super(accountNumber,balance,interestRate);
        this.minimumBalance = minimumBalance;
    }

    public void withdraw(double amount){
        if (amount > 0 ) {
            if (balance - amount >= minimumBalance) {
                balance-=amount;
                System.out.println("Withdrew:"+amount);

            }else{
                System.out.println("Insuffiecient funds.Minimum balance of:"+minimumBalance);
            }
        }else{
            System.out.println("Withdrawal Amount must be positive!");
        }
    }
}

class Bank{
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1234,120000,.03);
        bankAccount.deposit(20000);
        SavingsAccount savingsAccount = new SavingsAccount(4567,100000,11.0,5000,90000);
        savingsAccount.deposit(30000);
        savingsAccount.withdraw(4000);
        System.out.println("Balance in savings account:"+savingsAccount.getBalance());
    }
}
