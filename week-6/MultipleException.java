// c) handling multiple exceptions

import java.util.Scanner;

public class MultipleException 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("Enter the number :");
            int num = sc.nextInt();
            int result = 100/num;
            System.out.println("result is "+result);
            String str = null;
            System.out.println("string length is "+str.length());
        }
        catch(ArithmeticException e)
        {
            System.out.println("cannot divide by zero");
        }
        catch(NullPointerException e)
        {
            System.out.println("cant access a null object");
        }
        catch(Exception e)
        {
            System.out.println("some other exception thrown");
        }
        sc.close();
    }
}

/* expected output:
Enter the number :0 
cannot divide by zero
*/

/* expected output:
Enter the number :10 
result is 10
cant access a null object
*/
