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
