package Encapsulation;

public class Person {
    private String name;
    private int age;
    private String jobT;
    private float salary;

    public Person(String name, int age, String jobT, float salary) {
        this.salary = salary;
        this.age = age;
        this.jobT = jobT;
        this.name = name;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobT() {
        return jobT;
    }

    public void setJobT(String jobT) {
        this.jobT = jobT;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
