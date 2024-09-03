package Inheritance.Multilevel;

public class Animal {
    public void makeSound(){
        System.out.println("Animal produces generic sound....");
    }
}
class Mammal extends Animal{
    public void giveBirth(){
        System.out.println("Giving Birth");

    }
}
class Dog extends Mammal{
    @Override
    public void makeSound(){
        System.out.println("Wooof!");

    }
}
class Dit{
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Mammal mammal = new Mammal();
        mammal.makeSound();
        mammal.giveBirth();

        Dog dog = new Dog();
        dog.makeSound();
        dog.giveBirth();
    }
}
