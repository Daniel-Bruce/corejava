class Computer{
    public void Music(){
        System.out.println("Music playing..");
    }

    public int Cost(int cost1, int cost2){

        return cost1 + cost2;
    }
}

public class Mathods {
    public static void main(String[] args) {
        Computer com = new Computer();
        com.Music();
        int r = com.Cost(10,20);
        System.out.println(r);
    }
}
