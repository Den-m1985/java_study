public class Lesson21_Static {
    public static void main(String[] args) {
        People p1 = new People("Bob", 22);
        People p2 = new People("Mob", 30);
        /*
        People.description = "Nice";
        p1.getAllfield();
        p2.getAllfield();
        People.description = "Bad";
        p1.getAllfield();
        p2.getAllfield();
        вывод в консоле:
        Bob, 22, Nice
        Mob, 30, Nice
        Bob, 22, Bad
        Mob, 30, Bad
         */
        p1.printNumberOfPeople();
        p2.printNumberOfPeople();
    }
}
class People{
    private String name;
    private int age;

    //public static String description;
    public static int countPeople; // Эта переменная одна для всех объектов этого класса.
    public  People(String name, int age){
        this.name = name;
        this.age = age;
        countPeople ++; // Считаем кол-во объектов.
    }
    public  void  setName(String name){this.name = name;}
    public void  setAge(int age){this.age = age;}

    public void printNumberOfPeople(){
       System.out.println("Number of people is " + countPeople);
    }

}