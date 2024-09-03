package Interface;

//class -> class -> extends
//class -> interface -> implements
//interface -> interface -> extends

interface Text {
    void mainText();
    int y = 8;
    default void newText(){
        System.out.println("A New Text...");
    }
}
interface Doc{
    void req();
}
class Paper implements Text,Doc{

    @Override
    public void mainText() {
        System.out.println("Academic writing...");
    }

    @Override
    public void req() {
        System.out.println("You'll need this document to apply");
    }
}

class MAin{
    public static void main(String[] args) {
        Paper paper = new Paper();
        paper.mainText();
        paper.newText();
        paper.req();
        System.out.println(paper.y);
    }
}
