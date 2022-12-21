package AdvanceJava.Multithreading.Creation;

public class MultithreadCreationWay1 {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.setName("Counter 1");
        counter2.setName("Counter 2");
        counter1.start();
        counter2.start();
    }
}


class Counter extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
