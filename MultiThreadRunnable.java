package java8;

public class MultiThreadRunnable implements Runnable {
    @Override
    public void run() {
        try {
            for (int a = 1; a <= 5; a++)
                System.out.println("Runnable: " + Thread.currentThread().getId() + " is running...");
        } catch (Exception e) {
            System.out.println("e: " + e);
        }
    }
}
