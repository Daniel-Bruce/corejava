public class Looops {
    public static void main(String[] args) {
        /*int i = 1;

        while (i<=5){
            System.out.println("Hi "+i);
            int j = 1;
            while (j<=3){
                System.out.println("Hello");
                j++;
            }
            i++;
        }
        System.out.println("bye"+i);*/
        for (int o = 0; o < 10; o++) {
            System.out.print(" "+ o+ " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(i+ " ");
            //This inner loop print the values of j. from o-9. It prints each value in a row
            for (int j = 0; j < 10; j++) {

                System.out.print(i*j+" ");
            }
            //this empty println enable/prints out a new line and the loop iterates over again
            //for each outerloop the innerloop iterates 10 times
            System.out.println();

        }
    }
}
