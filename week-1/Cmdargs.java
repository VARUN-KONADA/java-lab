// displaying cmd args

public class Cmdargs
{
    public static void main(String args[])
    {
        System.out.println("name : " + args[0]);
        System.out.println("age : " + args[1]);
        System.out.println("college : " + args[2]);
            
    }
}

/* expected output:
name : varun
age : 18
college : anits
*/

/* actual output:
name : Varun
age : 18
college : ANITS
*/