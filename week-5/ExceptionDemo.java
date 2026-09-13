// handels Arithmetic and ArrayIndexOutOfBounds exceptions using try-catch block

public class ExceptionDemo 
{
    public static void main(String[] args) 
    {
        int a = 10, b = 0;
        int arr[] = {1, 2, 3, 4, 5};
        try
        {
            System.out.println("result: " + (a / b));
            System.out.println("arr[10]: " + arr[10]);
        }
        catch(ArithmeticException e)
        {
            System.out.println("error: cannot divide by zero");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("error: array index out of bounds");
        }
    }
}

/* expected output:
error: cannot divide by zero
error: array index out of bounds
*/

/* actual output:
error: cannot divide by zero
*/