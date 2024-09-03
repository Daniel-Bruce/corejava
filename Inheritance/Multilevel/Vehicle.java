package Inheritance.Multilevel;

public class Vehicle {
    public void start(){
        System.out.println("Vehicles started");
    }
}
class Car extends Vehicle{
    public void drive(){
        System.out.println("Car driving");
    }
}
class SportsCar extends Car{
    @Override
    public void drive(){
        System.out.println("Sports car driving fast");
    }
}
class Drain{
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.start();

        Car car = new Car();
        car.drive();

        SportsCar sportsCar = new SportsCar();
        sportsCar.start();
        sportsCar.drive();

    }
}
