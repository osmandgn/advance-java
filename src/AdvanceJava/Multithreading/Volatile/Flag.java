package AdvanceJava.Multithreading.Volatile;

/*
The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
More precisely that means, that every read of a volatile variable will be read from the computer's main memory,
and not from the CPU cache, and that every write to a volatile variable will be written to main memory,
and not just to the CPU cache
 */

public class Flag {
     public static volatile boolean flag = true;

    public static void main(String[] args) {

        Thread threadOne = new Thread(()-> {
            Thread.currentThread().setName("ThreadOne");
            while (flag){
                System.out.println(Thread.currentThread().getName() + " is working");
            }
        });
        threadOne.start();

        Thread threadTwo = new Thread(() -> {
            Thread.currentThread().setName("ThreadTwo");
            try{
                Thread.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            flag = false;
            System.out.println(Thread.currentThread().getName() + " made the flag false");
        });

        threadTwo.start();




    }
}
