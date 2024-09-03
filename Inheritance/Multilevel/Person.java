package Inheritance.Multilevel;

public class Person{
    String name;
    int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void display(){
        System.out.println("Name:"+name+" Age:"+age);
    }
}
class Employee extends Person{
    double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void display(){
        System.out.println("Name:"+name+" Age:"+age+" Salary:"+salary);
    }
}
class Manager extends Employee{
    String department;

    public Manager(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    @Override
    public void display(){
        System.out.println("Name:"+name+" Age:"+age+" Salary:"+salary+" Department:"+department);
    }
}
class Details{
    public static void main(String[] args) {
        Person person = new Person("Bruce",20);
        person.display();
        Employee employee = new Employee("Daniel",21,100000.00);
        employee.display();
        Manager manager = new Manager("Otieno",23,200000.00,"Software");
        manager.display();
    }
}