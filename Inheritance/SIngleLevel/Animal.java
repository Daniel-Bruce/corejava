package Inheritance.SIngleLevel;

public class Animal {
    public void makeSound(){
        System.out.println("Meeeeeeee");
    }
}
class Dog extends Animal{
    @Override
   public void makeSound(){
        System.out.println("Woof!");
    }
}
class Sound{
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
    }
}
