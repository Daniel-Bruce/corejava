import java.util.Arrays;

public class ArraYs {
    //explore 1d,2d, 3d and multidimensional array
    public static void main(String[] args) {
        /* 1d array
        String [] names = {"Bruce","Daniel","Otieno","King"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        int [] num = {1,2,3,4,5};
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }*/

        int[][] num = {{1,2,3},{4,5,6}};
        //System.out.println(num[0][1]);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j]+ " ");
            }
            System.out.println();
        }

        for (int n [] : num){
            for (int m : n){
                System.out.print(m + " ");
            }
            System.out.println();
        }

    }
}
