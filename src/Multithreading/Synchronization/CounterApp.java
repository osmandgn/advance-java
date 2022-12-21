package Multithreading.Synchronization;

public class CounterApp {
    static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> synchronizedCounter());
        Thread thread2 = new Thread(() -> synchronizedCounter());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("*".repeat(30));

        new Thread(() -> counter()).start();
        new Thread(() -> counter()).start();



    }

    public static void counter(){
        for (int i = 0; i < 100000; i++) {
            num++;
        }
        System.out.println(num);
    }

    public synchronized static void synchronizedCounter(){
        for (int i = 0; i < 100000; i++) {
            num++;
        }
        System.out.println(num);
    }
}


