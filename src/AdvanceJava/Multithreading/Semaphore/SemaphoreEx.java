package AdvanceJava.Multithreading.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // ayni anda 2 thread calisabilir
        System.out.println("Toplam park yapılabilecek yer sayısı : " + semaphore.availablePermits());


        CarPark car1 = new CarPark(semaphore, "Car 1");
        CarPark car2 = new CarPark(semaphore, "Car 2");
        CarPark car3 = new CarPark(semaphore, "Car 3");
        CarPark car4 = new CarPark(semaphore, "Car 4");
        car1.start();
        car2.start();
        car3.start();
        car4.start();

    }
}


class CarPark extends Thread {
    Semaphore semaphore;
    String threadname;

    public CarPark(Semaphore semaphore, String threadname) {
        super(threadname);
        this.semaphore = semaphore;
    }


    }
}
