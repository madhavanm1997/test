package java8;

public class MultiThreadTest {
    public static void main(String[] args) {

        //thread class...
        MultiThreadClass multiThreadClass = new MultiThreadClass();
        multiThreadClass.start();
        for (int i = 0; i <= 5; i++) {
            System.out.println("ManiThreadClass: " + i);
        }

        //runnable implementation
        Thread thread = new Thread(new MultiThreadRunnable());
        thread.start();
        for (int a = 1; a <= 5; a++) {
            System.out.println("MainRunnable: " + a);
        }

        //runnable interface using a Lambda
        Runnable runnable = () -> {
            for (int c = 1; c <= 5; c++)
                System.out.println("Thread: " + Thread.currentThread().getId());
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        for (int d = 1; d <= 10; d++) {
            System.out.println("d: " + d);
        }


    }
}
