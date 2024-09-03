package Inheritance.SIngleLevel;

public class Vehicle {
    public void start(){
        System.out.println("Vehicle started....");
    }
}
class Car extends Vehicle{
    @Override
    public void start(){
        System.out.println("Car started...");
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.start();
        Car car = new Car();
        car.start();
    }
}
