import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Введи возраст");
        int age = scaner.nextInt();

        /* Этот код можно переписать
        if (age == 10){
            System.out.println("Ты учишься в школе");
        } else if (age == 18) {
            System.out.println("Ты закончил школу");
        }*/
        switch (age){
            case 0:
                System.out.println("Ты родился");
                break;
            case 7:
                System.out.println("Ты пошел в школу");
                break;
            case 18:
                System.out.println("Ты закончил школу");
                break;
            default:
                System.out.println("Ни одно из условий не выполнилось");
        }
    }
}
