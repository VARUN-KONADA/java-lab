import java.util.Scanner;
import java.lang.Math;

public class Operation
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("First number: ");
        float a = sc.nextFloat();
        System.out.println("Second number: ");
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
