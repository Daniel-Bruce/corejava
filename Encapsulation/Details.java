package Encapsulation;

public class Details {
    public static void main(String[] args) {
        //parameterized constructor used
        Person person = new Person();
        person.setName("Bruce");
        person.setAge(22);
        person.setJobT("Software engineer");
        person.setSalary(100_000);
        System.out.println("name:"+person.getName()+" job:"+person.getJobT()+" salary:$"+person.getSalary()+" age:"+person.getAge());

        //default constructor used
        Person person1 = new Person("Daniel",21,"Software engineer",120000);
        System.out.println("name:"+person1.getName()+" job:"+person1.getJobT()+" salary:£"+person1.getSalary()+" age:"+person1.getAge());

    }
}
