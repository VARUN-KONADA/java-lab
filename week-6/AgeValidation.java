// b)inputs user age and validates it using exception handling

import java.util.Scanner;

public class AgeValidation 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.close();
        try 
        {
            if (age < 18) 
            {
                throw new InvalidAgeException("You must be at least 18 years old");
            }
            System.out.println("Age is valid");
        } 
        catch (InvalidAgeException e) 
        {
            System.out.println("Invalid age: " + e.getMessage());
        }
        
    }
}
