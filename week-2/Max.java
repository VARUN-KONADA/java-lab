// finding largest number in array
import java.util.Scanner;

public class Max
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter element : ");
            arr[i] = sc.nextInt();
        }
        
        // checking largest one 
        int max = arr[0];
        for(int i = 1; i < n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        
        System.out.println("maximum element is: " +max);
            
    }
}

/* expected output:
Enter number of elements : 5
Enter element : 10
Enter element : 20
Enter element : 30
Enter element : 40
Enter element : 50
maximum element is: 50
*/

/* actual output:
Enter number of elements : 3
Enter element : 15
Enter element : 35
Enter element : 25
maximum element is: 35
*/