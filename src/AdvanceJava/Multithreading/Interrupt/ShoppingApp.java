package AdvanceJava.Multithreading.Interrupt;

public class ShoppingApp {
    private static volatile int stock = 0;

    public static void main(String[] args) {
        ShoppingApp shop = new ShoppingApp();
        Thread thread1 = new Thread(() -> shop.getProdcut(6));
        Thread thread2 = new Thread(() -> {shop.addProduct(10); thread1.interrupt();});
        thread1.start();
        thread2.start();

    }

    public synchronized void addProduct(int amount){
        System.out.println(Thread.currentThread().getName() + " is adding product");
        stock+= amount;
        System.out.println("Products added new stock: " + stock);
        sleep();
    }

    public synchronized void getProdcut(int amount){
        if (amount > stock){
            System.out.println("Thre is not enough product");
            System.out.println("Waiting for new products to add");
            sleep();
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("New products added");
                if (amount<= stock){
                    stock -= amount;
                    System.out.println("You got the products new stock: " + stock);
                }else {
                    System.out.println("Still we dont have enough product pleas entry diffrent amount");
                }
            }

        }else {
            System.out.println("You got the products new stock: " + stock);
        }
    }


}
