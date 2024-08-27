public class Fibo {
    public static void main(String[] args) {
        int maxNums = 10;
        int f1stNum = 0;
        int secNum = 1;
        System.out.print(f1stNum);
        for (int i = 3; i <=maxNums; ++i) {
            int sum = f1stNum + secNum;
            System.out.print(" " +secNum);

            f1stNum = secNum;
            secNum = sum;

        }
    }
}
