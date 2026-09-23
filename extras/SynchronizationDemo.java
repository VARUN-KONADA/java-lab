public class SynchronizationDemo {

    public static void main(String[] args) throws Exception {

        // Shared Counter object
        Counter c = new Counter();

        // Thread 1
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10000; i++) {
                    c.increment();
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10000; i++) {
                    c.increment();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        System.out.println("Expected Count = 20000");
        System.out.println("Actual Count   = " + c.count);
    }
}
class Counter {

    int count = 0;

    // Synchronized method
    synchronized void increment() {
        count++;
    }
}
