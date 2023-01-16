public class ClassesIncapsulation {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        person1.setName("Denis");
        person1.setAge(38);
        person1.speak();
        System.out.println("Выводим значение в main методе: " + person1.getName());
        System.out.println("Выводим значение в main методе: " + person1.getAge());


    }
}
class Person1{
    private String name;
    private int age;

    public void setName (String username){
        if (username.isEmpty()){
            System.out.println("Ты ввел пустую строку");
        }else {
        name = username;}
    }
    public String getName(){
        return name;
    }

    public void setAge (int userAge){
        if (userAge < 0){
            System.out.println("Возраст должен быть больше 0");
        }else {
        age = userAge;}
    }
    public int getAge(){
        return age;
    }
    void speak(){
        System.out.println("My name " + name + "," + "my age is " + age);
    }

}
