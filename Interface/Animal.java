package Interface;

interface Animal {
    void eat(); // Abstract method

    default void breathe() { // Default method
        System.out.println("Breathing...");
    }
}

interface Mammal {
    void giveBirth(); // Abstract method
}

class Dog implements Animal, Mammal {
    public void eat() {
        System.out.println("Dog is eating.");
    }

    public void giveBirth() {
        System.out.println("Dog is giving birth.");
    }
}

class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(); // Implementation of Animal's method
        dog.giveBirth(); // Implementation of Mammal's method
        dog.breathe(); // Default method from Animal
    }
}

