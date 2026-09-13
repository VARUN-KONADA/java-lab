// method overloading example
public class Calc
{
    public static void main(String args [])
    {
        Calculator c =  new Calculator();
        System.out.println("Integer addition: " + c.add(10, 20));
        System.out.println("Double addition: " + c.add(10.5, 20.5));
        System.out.println("Integer subtraction: " + c.sub(20, 10));
        System.out.println("Double subtraction: " + c.sub(20.5, 10.5));
        System.out.println("Integer multiplication: " + c.mul(10, 20));
        System.out.println("Double multiplication: " + c.mul(10.5, 20.5));
        System.out.println("Integer division: " + c.div(20, 10));
        System.out.println("Double division: " + c.div(20.5, 10.5));
    }
}

/* expected output:
Integer addition: 30
Double addition: 31.0
Integer subtraction: 10
Double subtraction: 10.0
Integer multiplication: 200
Double multiplication: 210.25
Integer division: 2
Double division: 2.0
*/

/* actual output:
Integer addition: 30
Double addition: 31.0
Integer subtraction: 10
Double subtraction: 10.0
Integer multiplication: 200
Double multiplication: 215.25
Integer division: 2
Double division: 1.9523809523809523
*/