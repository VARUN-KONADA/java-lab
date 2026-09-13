// storing employee details using different constructors

public class Employee 
{
    int id;
    String name;
    double salary;
    
    // constructor with no parameter
    Employee()
    {
        id = 0;
        name = "Not assigned";
        salary = 0.0;
    }

    // constructor with parameters
    Employee(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;  
    }

    // copy constructor 
    Employee(Employee e)
    {
        this.id = e.id;
        this.name = e.name;
        this.salary = e.salary; 
    }

    // display employee details
    void display()
    {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
        System.out.println();
    }
}
