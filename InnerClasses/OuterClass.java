package InnerClasses;

public class OuterClass {
    int x = 10;

    class InnerClass{
        int y = 5;

        public int myInner(){
            return x + y;
        }
    }
}
class Main{
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        System.out.println(innerClass.myInner());
    }
}
