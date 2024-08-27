class Phone{


         String name;
        int price;
        String brand;

        public void  show(){
            System.out.println("Name:"+name+" price:"+price+" brand:"+brand);
            }

    public static void loc(){
            System.out.println("Inside static block.....");

        }

}

public class CodeBlock {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.name = "Samsung s20";
        phone.brand = "Samsung";
        phone.price = 120000;

        Phone phone2 = new Phone();
        phone2.price = 110000;
        phone2.name = "Iphone 14";
        phone2.brand = "Apple";

        phone2.show();
        phone.show();

        Phone.loc();


    }
}
