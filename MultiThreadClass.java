package java8;

public class MultiThreadClass extends Thread {
    public void run() {
        try {
            for (int a = 1; a <= 5; a++) {
                System.out.println("ThreadClass " + Thread.currentThread().getId() + " is running...");
            }
        } catch (Exception e) {
            System.out.println("e: " + e);
        }
    }
}
