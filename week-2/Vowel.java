// finding number of vowels in string
import java.util.Scanner;

public class Vowel
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();
        
        int size = str.length();
        char ch;
        int count=0;
        
        for(int i = 0 ; i < size ; i++)
        {
            ch = Character.toLowerCase(str.charAt(i));
            
            if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u')
            {
                count++;
            }
        }
        
        System.out.println("There are " + count + " vowels" );
        
        sc.close();
            
    }
}

/* expected output:
Enter a string : Hello world
There are 3 vowels
*/
/* actual output:
Enter a string : Hi bro
There are 2 vowels
*/