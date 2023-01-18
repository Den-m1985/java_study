public class Lesson24_ClassObject {
    public static void main(String[] args) {
        SomeHuman p1 = new SomeHuman("Bob", 22);
        SomeHuman p2 = new SomeHuman("Mob", 30);
        System.out.println(p1);
        System.out.println(p2);
    }
}

class SomeHuman{
    private String name;
    private int age;

    public SomeHuman(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return name+","+age;
    }

}
