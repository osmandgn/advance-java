package AdvanceJava.Multithreading.WaitAndInterrupt;

public class BankApplication {
    public static void main(String[] args) {
        Bank account = new Bank();
        Thread th1 = new Thread(() -> account.withdraw(800));
        Thread th2 = new Thread(() -> {account.deposit(1000); th1.interrupt();});
        th1.start();
        th2.start();

    }
}

class Bank {
    private int balance = 0;

    public synchronized void withdraw(int amount) {
        if (balance <= 0) {
            try {
                System.out.println("Waiting for deposit ");
                Thread.sleep(5000);
                wait();
            } catch (InterruptedException e) {
                System.out.println("Deposit complete, withdraw in proccess");
                balance -= amount;
                System.out.println("New Balance is " + balance);
            }
        }
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

}

