// c) reverse the string given by user
import java.util.Scanner;

public class Reverse 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();
        String rev = "";
        for(int i = str.length() -1; i>=0; i--)
        {
            rev = rev + str.charAt(i);
        }
        System.out.println("Reversed string is: " + rev);
        sc.close();
    }    
}

/* expected output:
Enter a string : Hello world
Reversed string is: dlrow olleH
*/

/* actual output:
Enter a string : Hi bro 
Reversed string is:  orb iH
*/
