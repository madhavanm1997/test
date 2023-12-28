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

    }
}
