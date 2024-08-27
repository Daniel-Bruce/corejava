public class Main {
    /* Assignment ops are used to assign values to variables(=) while
    * arithmetic ops are used to perform arithmetic ops while
    * relational ops are used to compare values/variables while
    * logical ops are used to combine or invert boolean values */
    public static void main(String[] args) {
        int a = 258;
        byte n = (byte) a;

        float f = 5.6f;
        int t = (int) f;
        var s = "Hello World";

        //operators
        int c = 2;
        int b = 3;
        boolean result = c < b;
        System.out.println(!result);
    }
}