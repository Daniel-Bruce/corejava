public class Jaggedd {
    public static void main(String[] args) {
       int jagged [][] = new int[3][];
       jagged [0] = new int[3];
       jagged [1] = new int[2];
       jagged [2] = new int[1];

       jagged [0][0] = 1;
       jagged [0][1] = 2;
       jagged [0][2] = 3;

       jagged [1][0] = 4;
       jagged [1][1] = 5;

       jagged [2][0] = 6;

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}
