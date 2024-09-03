package Inheritance.SIngleLevel;

public class Main {
    public Main() {
        System.out.println("In Main");
    }
    public Main(int x){
        x = 5;
    }
}
class A extends Main{
    public A() {
        System.out.println("In A");
    }

    public A(int x) {
      super(5);
    }
}
class Print{
    public static void main(String[] args) {
        //THE CONSTRUCTOR OF PARENT CLASS IS ALWAYS CALLED BEFORE THE CONTRUCTOR OF CHILD CLASS HENCE THE OUTPUT
        A a = new A();
        A b = new A(5);

    }
}
