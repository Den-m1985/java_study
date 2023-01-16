public class Lesson20 {
    public static void main(String[] args) {
        Men person1 = new Men("abc", 25);
        Men person2 = new Men();
        System.out.println(person1);
        System.out.println(person2);
    }
}
// конструкторы нужны, что бы не создавать пустые объекты
class Men{
    private String name;
    private int age;


    public Men(){
        System.out.println("Ты создал пустой объект");
        this.name = "user defult";
        this.age = 0;
    }

    public Men(String name, int age){
        System.out.println("Третий конструктор");
        this.name = name;
        this.age = age;
    }
}
