import java.util.Scanner;

public class Prime
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        boolean prime = true;
        System.out.print("enter number: ");
        int p = sc.nextInt();
        for(int i = 2;i < p;i++)
        {
            if((p%i) == 0)
            {
                prime = false;
                break;
            }
        }
        if(prime)
        {
            System.out.println(p + " is a prime number ");
        }
        else
        {
            System.out.println(p + " is not a prime number ");
        }

        sc.close();
    }
}
