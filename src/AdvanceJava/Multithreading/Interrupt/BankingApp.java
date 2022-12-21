package AdvanceJava.Multithreading.Interrupt;

public class BankingApp {

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
                System.out.println("Waiting for Money ");
                Thread.sleep(3000);
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupt Exception - Thread Sonlandirildi");
            }
        }
        balance -= amount;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

}
