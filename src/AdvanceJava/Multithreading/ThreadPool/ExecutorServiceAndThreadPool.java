package AdvanceJava.Multithreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceAndThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Thread(() -> paintAndPrint()));
        }
        executorService.shutdown();

    }
    public static void paintAndPrint(){
        System.out.println(Thread.currentThread().getName() + " is printing" );
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
