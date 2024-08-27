class Person{
    String name;
    int age;
    int marks;
}

public class Oarray {

    public static void main(String[] args) {

        Person oarray1 = new Person();
        oarray1.name = "liverpool";
        oarray1.age = 10;
        oarray1.marks = 45;

       Person oarray2 = new Person();
        oarray2.name = "lille";
        oarray2.age = 16;
        oarray2.marks = 65;

        Person oarray3 = new Person();
        oarray3.name = "limpopo";
        oarray3.age = 19;
        oarray3.marks = 75;

        Person person [] = new Person[3];
        person[0] = oarray1;
        person[1] = oarray2;
        person[2] = oarray3;

        /*for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].name+" "+person[i].age+" "+person[i].marks);
        }*/

        for (Person people : person){
            System.out.print("name: "+people.name+ " "+ " age:"+people.age+ " "+ " marks:"+people.marks);
            System.out.println();
        }


    }
}
