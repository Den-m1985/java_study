public class Arrays_and_Strings {
    public static void main(String[] args) {
        int [] numbers = new int [5];
        numbers[0] = 5;
        for (int i =0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        String [] strings = new String[3];
        strings [0] = "hello";
        strings [0] = "dfdf";
        strings [0] = "java";

        for (int i = 0; i < strings.length; i++){
            System.out.println(strings[i]);
        }
        System.out.println();
        // foreach он проходит по всему массиву strings, как на Python
        for (String string: strings){
            System.out.println(string);
        }

        int [] numbers1 = {1,2,3};
        int sum = 0;
        for (int x: numbers1){
            sum = sum + x;
        }
        System.out.println(sum);
    }
}
