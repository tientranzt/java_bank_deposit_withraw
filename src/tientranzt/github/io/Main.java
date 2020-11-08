package tientranzt.github.io;

public class Main {

    public static void main(String[] args) {
	    BankAccount bankAccount = new BankAccount(1000.0,"12345-678");

	    Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(200.0);
                bankAccount.withdraw(50.0);
            }
        });
	    Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(100.0);
                bankAccount.withdraw(30.0);
            }
        });

    }
}


class BankAccount{
    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

//    public synchronized void deposit(double amount){
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount){
//        balance -= amount;
//    }

    public void deposit(double amount){
       synchronized (this){
           balance += amount;
       }
    }

    public void withdraw(double amount){
        synchronized (this){
            balance -= amount;
        }
    }
}