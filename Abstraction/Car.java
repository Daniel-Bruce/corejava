package Abstraction;

public abstract class Car {
    public abstract void drive();
    public void engine(){
        System.out.println("Engine revsss.....");
    }
}
class BMW extends Car{
    @Override
    public void drive() {
        System.out.println("car driving....");
    }
    public void goal(){
        System.out.println("Best car in the world...");
    }
}
class Print{
    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.drive();
        bmw.goal();
        bmw.engine();

        //Cannot instantiate an abstract class
        //Car car = new Car();
    }
}
