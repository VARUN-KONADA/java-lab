// b) performs basic arithmetic operations on two numbers
import java.util.Scanner;
import java.lang.Math;

public class Operation
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("First number: ");
        float a = sc.nextFloat();
        System.out.print("Second number: ");
        float b = sc.nextFloat();
        System.out.println("addition = "+(a+b));
        System.out.println("subtraction = "+(a-b));
        System.out.println("multipication = "+(a*b));
        System.out.println("division = "+(a/b));
        System.out.println("modulus = "+(a%b));
        System.out.println("exponation = "+(Math.pow(a,b)));
        sc.close();
    }
}

/* expected output:
First number: 10
Second number: 5
addition = 15.0
subtraction = 5.0
multipication = 50.0
division = 2.0
modulus = 0.0
exponation = 100000.0
*/

/* expected output:
First number: 15
Second number: 5
addition = 20.0
subtraction = 10.0
multipication = 75.0
division = 3.0
modulus = 0.0
exponation = 759375.0
*/