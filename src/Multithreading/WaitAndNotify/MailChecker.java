package Multithreading.WaitAndNotify;

public class MailChecker {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(message::getMessage).start();
        new Thread(() -> message.sendMessage("Hello World")).start();
    }
}

class Message {
    private String message;

    public synchronized void getMessage() {
        try {
            if (message == null) {
                System.out.println("Mail Bekleniyor...");
                wait();
            }
            System.out.println("Mailler Aliniyor...");
            Thread.sleep(3000);
            System.out.println(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String mail) {
        try {
            Thread.sleep(3000);
            System.out.println("Mail Gonderiliyor...");
            Thread.sleep(2000);
            message = mail;
            synchronized (this) {
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

