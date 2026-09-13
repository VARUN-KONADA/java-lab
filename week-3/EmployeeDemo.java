// creating multiple constructors in a class

public class EmployeeDemo
{
    public static void main(String[] args)
    {
        Employee e1 = new Employee();
        Employee e2 = new Employee(397,"varun konada", 10000);
        Employee e3 = new Employee(e2);
        System.out.println("default constructor:");
        e1.display();
        System.out.println("parameterized constructor:");
        e2.display();
        System.out.println("copy constructor:");
        e3.display();
    }
}

/* expected output:
default constructor:
Employee ID: 0
Employee Name: Not assigned
Employee Salary: 0.0

parameterized constructor:
Employee ID: 397
Employee Name: varun konada
Employee Salary: 10000.0

copy constructor:
Employee ID: 397
Employee Name: varun konada
Employee Salary: 10000.0
*/

/* actual output 
default constructor:
Employee ID: 0
Employee Name: Not assigned
Employee Salary: 0.0

parameterized constructor:
Employee ID: 397
Employee Name: varun konada
Employee Salary: 10000.0

copy constructor:
Employee ID: 397
Employee Name: varun konada
Employee Salary: 10000.0
*/