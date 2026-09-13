// a) demonstrates the use of overriding 

class Shape
{
    public void CalculateArea()
    {
        System.out.println("area cant be calculated");
    }
}

class Rectangle extends Shape
{
    int length, breadth;
    Rectangle(int l, int b)
    {
        length = l;
        breadth = b;
    }
    @Override
    public void CalculateArea()
    {
        super.CalculateArea();
        System.out.println("area of rectangle: " + (length * breadth));
    }
}

class Circle extends Shape
{
    int radius;
    Circle(int r)
    {
        radius = r;
    }
    @Override
    public void CalculateArea()
    {
        super.CalculateArea();
        System.out.println("area of circle: " + (3.14 * radius * radius));
    }
}
public class ShapesDemo 
{
    public static void main(String[] args) 
    {

        Rectangle r = new Rectangle(5, 10);
        r.CalculateArea();

        Circle c = new Circle(7);
        c.CalculateArea();
    }
}

/* expected output:
area cant be calculated
area of rectangle: 50
area cant be calculated
area of circle: 153.86
 */

/* actual output:
area cant be calculated
area of rectangle: 50
area cant be calculated
area of circle: 153.86
 */