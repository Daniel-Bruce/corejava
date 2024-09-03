package Inheritance.SIngleLevel;

public class Shape {
    public double getArea(){
        return 0.0;
    }
}
class Rectangle extends Shape{
    int length;
    int width;
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea(){
        return length*width;
    }
}

class Calc{
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Area of shape:"+shape.getArea());
        Rectangle rectangle = new Rectangle(11,2);
        System.out.println("Areaf of rectangle:"+rectangle.getArea());
    }
}
