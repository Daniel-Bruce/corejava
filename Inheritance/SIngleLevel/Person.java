package Inheritance.SIngleLevel;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void display(){
        System.out.println("Name:"+name+"Age:"+age);
    }
}
class Employee extends Person{
    float salary;

    public Employee(String name, int age, float salary) {
        super(name, age);
        this.salary = salary;
    }
    @Override
    public void display(){
        System.out.println("Name:"+name+" Age:"+age+" Salary:"+salary);
    }
}
class Display{
    public static void main(String[] args) {
        Person person = new Person("Bruce",20);
        person.display();
        Employee employee = new Employee("Daniel",21,120000);
        employee.display();
    }
}
