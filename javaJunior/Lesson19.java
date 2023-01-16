public class Lesson19 {
    public static void main(String[] args) {
        Human person1 = new Human();
        person1.setName("Fgjfjgjfg");
        person1.setAge(20);
        person1.speak();
    }
}

class Human{
    private String name;
    private int age;

    public void setName (String name){
            this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge (int age){
        if (this.age < 0){
            System.out.println("Возраст должен быть больше 0");
        }else {
            this.age = age;}
    }
    public int getAge(){
        return age;
    }
    void speak(){
        System.out.println("My name " + name + "," + "my age is " + age);
    }
}
