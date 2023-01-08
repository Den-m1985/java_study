public class Arrays {
    public static void main(String[] args) {
        int number = 10;              // [10] примитивный тип данных
        int [] numbers = new int [5];   // numbers -> [массив]  Ссылочный тип данных
        for (int i = 0; i < numbers.length; i++){
            numbers [i] = i+1;
        }
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println();
        int [] number1 = {1,6,8,9,7,8};
        for (int i =0; i < number1.length; i++){
            System.out.println(number1[i]);
        }
    }
}
