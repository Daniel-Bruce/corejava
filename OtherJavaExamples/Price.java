class Comodity{
    public String Pen(int cost){
        return "Cost of pen: "+cost;
    }
}

public class Price {
    public static void main(String[] args) {
        Comodity com = new Comodity();
        String p = com.Pen(10);
        System.out.println(p);
    }
}
