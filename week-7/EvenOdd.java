class Printer {
    private int number = 1;
    private final int LIMIT = 10;

    // Called by Odd Thread
    public synchronized void printOdd() {
        while (number <= LIMIT) {
            // If the number is EVEN, it's NOT Odd's turn -> WAIT!
            while (number % 2 == 0) {
                try {
                    wait(); // Releases lock and sleeps on "this" printer object
                } catch (InterruptedException e) {}
            }

            if (number <= LIMIT) {
                System.out.println("Odd Thread : " + number);
                number++;
                notify(); // Wakes up the Even thread sleeping on "this" printer object
            }
        }
    }

    // Called by Even Thread
    public synchronized void printEven() {
        while (number <= LIMIT) {
            // If the number is ODD, it's NOT Even's turn -> WAIT!
            while (number % 2 != 0) {
                try {
                    wait(); // Releases lock and sleeps on "this" printer object
                } catch (InterruptedException e) {}
            }

            if (number <= LIMIT) {
                System.out.println("Even Thread: " + number);
                number++;
                notify(); // Wakes up the Odd thread sleeping on "this" printer object
            }
        }
    }
}

// CLASS 1: Odd Thread
class OddThread extends Thread {
    private Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        printer.printOdd();
    }
}

// CLASS 2: Even Thread
class EvenThread extends Thread {
    private Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        printer.printEven();
    }
}

public class EvenOdd {
    public static void main(String[] args) {
        // ONE shared printer object passed to BOTH threads
        Printer printer = new Printer();

        OddThread t1 = new OddThread(printer);
        EvenThread t2 = new EvenThread(printer);

        t1.start();
        t2.start();
    }
}