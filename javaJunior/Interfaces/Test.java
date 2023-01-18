package Interfaces;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal(1);
        Person person = new Person("Bob");
        animal.sleep();
        person.seyHello();
        animal.showInfo();

        Info info = new Animal(1);
        info.showInfo();

        outputInfo(person);
        outputInfo(animal);


    }
    public static void outputInfo(Info info){
        info.showInfo();
    }
}
