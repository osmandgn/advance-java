package AdvanceJava.Multithreading.Creation;

public class MultithreadCreationWay2 {
    public static void main(String[] args) {
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();
        Thread thread1 = new Thread(timer1);
        Thread thread2 = new Thread(timer2);
        thread1.start();
        thread2.start();
    }
}
class Timer implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}
