/*Write a Java program to solve the producer-consumer problem using
multithreading and synchronization techniques. Implement a shared buffer
to store items produced by a producer thread and consumed by a
consumer thread. */

class Buffer
{
    private int value;
    private boolean available = false;

    public synchronized void produce(int n)
    {
        try
        {
            while(available)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        value = n;
        available = true;
        System.out.println("value produced: "+n);
        notify();

    }

    public synchronized void consume()
    {
        try
        {
            while(!available)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        available = false;
        System.out.println("value consumed: "+value);
        notify();

    }
}

public class ProducerConsumer
{
    public static void main(String args[])
    {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(()-> {
            for(int i = 0; i < 5; i++)
            {
                buffer.produce(i);
            }
        });

        Thread consumer = new Thread(()-> {
            for(int i = 0; i < 5; i++)
            {
                buffer.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}

/*expected output
value produced: 0
value consumed: 0
value produced: 1
value consumed: 1
value produced: 2
value consumed: 2
value produced: 3
value consumed: 3
value produced: 4
value consumed: 4
*/

/*actual output
value produced: 0
value consumed: 0
value produced: 1
value consumed: 1
value produced: 2
value consumed: 2
value produced: 3
value consumed: 3
value produced: 4
value consumed: 4
*/