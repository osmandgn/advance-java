package AdvanceJava.Multithreading.Creation;

public class AnonymousAndLambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Anonymous");
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " Lambda")).start();




    }
}
