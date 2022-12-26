package AdvanceJava.Multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        Car car1 = new Car(latch);
        Car car2 = new Car(latch);
        car1.start();
        car2.start();



        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finally Main Thread is Working");
    }
}



class Car extends Thread{
    CountDownLatch latch;
    Car(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " is working");
        try{
            Thread.sleep(3000);
            latch.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
