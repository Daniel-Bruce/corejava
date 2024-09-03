package InnerClasses;

public class A {
    public void a(){
        System.out.println("In A");
    }
     class B{
        public void b(){
            System.out.println("In B");
        }
    }
}
class Demo{
    public static void main(String[] args) {
       A aa = new A();
        //aa.a();

        //If we make B static thats when we can use this format.
        /*A.B bb = new A.B();
        bb.b();*/

       A.B bb = aa.new B();
       bb.b();
    }
}

