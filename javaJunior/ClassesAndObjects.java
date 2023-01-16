public class ClassesAndObjects {
    public static void main(String[] args) {
        Person person1 = new Person();
        //person1.name = "Denis";
        person1.setName("Denis");
        person1.age = 38;
        person1.speak();
        int years1 = person1.calculateYearsToRetirement();
        System.out.println(years1 + " лет осталось до пенсии");

        System.out.println();

        Person person2 = new Person();
        person2.name = "Olga";
        person2.age = 25;
        person2.speakFor();

    }
}
class Person{
    String name;
    int age;
    void speak(){
        System.out.println("My name " + name + "," + "my age is " + age);
    }
    void speakFor(){
        for (int i = 0; i < 3; i++){
            System.out.println("My name " + name + "," + "my age is " + age);
        }
    }
    int calculateYearsToRetirement(){
        int yars = 65 - age;
        return yars;
    }

    void setName(String username){
        name = username;
    }
}
