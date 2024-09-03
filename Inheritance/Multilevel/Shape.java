package Inheritance.Multilevel;

public class Shape {
    public double getArea(){
        return 0.0;
    }
}
class Rectangle extends Shape{
    float length;
    float width;
    public Rectangle(float length, float width){
        this.length=length;
        this.width=width;
    }
    @Override
    public double getArea(){
        return length*width;
    }
}
class Box extends Rectangle{
    double height;
    public Box(float length,float width,float height){
        super(length,width);
        this.height=height;
    }
    @Override
    public double getArea(){
        return (length*width)+(length*height)+(width*height);
    }
}
class Area{
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Shape area:"+shape.getArea());

        Rectangle rectangle = new Rectangle(12,12);
        System.out.println("Rectangle area:"+rectangle.getArea());

        Box box = new Box(11,11,11);
        System.out.println("Box surface area:"+box.getArea());
    }
}
