/*Write a Java program to Create two threads: one for printing even numbers
and the other for printing odd numbers. Ensure proper synchronization to
avoid interleaving output and guarantee correct sequence of numbers. */

class Printer 
{
    private int number = 1;
    private final int LIMIT = 10;

    public synchronized void printOdd() 
    {
        while (number <= LIMIT) 
        {
            
            while (number % 2 == 0) 
            {
                try 
                {
                    wait(); 
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }

            if (number <= LIMIT) 
            {
                System.out.println("Odd Thread : " + number);
                number++;
                notify(); 
            }
        }
    }

    public synchronized void printEven() 
    {
        while (number <= LIMIT) 
        {
            
            while (number % 2 != 0) 
            {
                try 
                {
                    wait(); 
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }

            if (number <= LIMIT) 
            {
                System.out.println("Even Thread: " + number);
                number++;
                notify();
            }
        }
    }
}

// Odd Thread
class OddThread extends Thread 
{
    private Printer printer;

    public OddThread(Printer printer) 
    {
        this.printer = printer;
    }

    public void run() 
    {
        printer.printOdd();
    }
}

// Even Thread
class EvenThread extends Thread 
{
    private Printer printer;

    public EvenThread(Printer printer) 
    {
        this.printer = printer;
    }

    public void run() 
    {
        printer.printEven();
    }
}

public class EvenOdd 
{
    public static void main(String args[]) 
    {
        // ONE shared printer object passed to BOTH threads
        Printer printer = new Printer();

        OddThread t1 = new OddThread(printer);
        EvenThread t2 = new EvenThread(printer);

        t1.start();
        t2.start();
    }
}

/* expected output:
Odd Thread : 1
Even Thread: 2
Odd Thread : 3
Even Thread: 4
Odd Thread : 5
Even Thread: 6
Odd Thread : 7
Even Thread: 8
Odd Thread : 9
Even Thread: 10
*/

/* actual output:
Odd Thread : 1
Even Thread: 2
Odd Thread : 3
Even Thread: 4
Odd Thread : 5
Even Thread: 6
Odd Thread : 7
Even Thread: 8
Odd Thread : 9
Even Thread: 10
*/