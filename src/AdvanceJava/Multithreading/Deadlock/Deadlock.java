package AdvanceJava.Multithreading.Deadlock;

public class Deadlock {
    static String spoon = "Spoon";
    static String knife = "Knife";

    public static void main(String[] args) {

        new Thread(()-> {
            synchronized (spoon){
                Thread.currentThread().setName("Jack");
                System.out.println(Thread.currentThread().getName() + " is using Spoon and waiting for Knife ");
                synchronized (knife){
                    System.out.println(Thread.currentThread().getName() + " is using Knife");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (knife){
                Thread.currentThread().setName("Tom");
                System.out.println(Thread.currentThread().getName() + " is using Knife and waiting for Spoon");
                synchronized (spoon){
                    System.out.println(Thread.currentThread().getName() + " is using Spoon");
                }
            }
        }).start();


    }
}
