// b) implementing interface abstract methods

interface shape
{
    void CalculateArea();
    void CalculatePerimeter();
}

class Rectangle implements shape
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
        System.out.println("area of rectangle: " + (length * breadth));
    }
    @Override
    public void CalculatePerimeter()
    {
        System.out.println("perimeter of rectangle: " + 2 * (length + breadth));
    }
}

class Circle implements shape
{
    int radius;
    Circle(int r)
    {
        radius = r;
    }
    @Override
    public void CalculateArea()
    {
        System.out.println("area of circle: " + (3.14 * radius * radius));
    }
    @Override
    public void CalculatePerimeter()
    {
        System.out.println("perimeter of circle: " + (2 * 3.14 * radius));
    }
}

public class InterfaceDemo 
{
    public static void main(String[] args) 
    {
        shape r = new Rectangle(5, 10);
        shape c = new Circle(7);
        r.CalculateArea();
        r.CalculatePerimeter();
        c.CalculateArea();
        c.CalculatePerimeter();
    }
}

/* expected output:
area of rectangle: 50
perimeter of rectangle: 30
area of circle: 153.86
perimeter of circle: 43.96
*/

/* actual output:
area of rectangle: 50
perimeter of rectangle: 30
area of circle: 153.86
perimeter of circle: 43.96
*/