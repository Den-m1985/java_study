public class Lesson1 {
    public static void main(String[] args) {
        float p = 2.7f;
        double pi = 3.1415;
        System.out.println(p); // 2.7
        System.out.println(pi); // 3.1415

        boolean flag1 = 123 <= 234;
        System.out.println(flag1); // true
        boolean flag2 = 123 >= 234 || flag1;
        System.out.println(flag2); // true
        boolean flag3 = flag1 ^ flag2;
        System.out.println(flag3); // false

        var u = 123;
        System.out.println(u); // 123
        var y = 123.456;
        System.out.println(y); // 123.456
        System.out.println(getType(u)); // Integer
        System.out.println(getType(y)); // Double
        y = 1022;
        System.out.println(y); // 1022
        //d = "mistake";
        //error: incompatible types:
        //String cannot be converted to double


        int a = 123;
        System.out.println(a++); // Постфиксный инкремент a++ не имеет приоритет над выводом в консоли.
        System.out.println(a);
        System.out.println(++a); // Префиксный инкремент имеет приоритет над выводом над консолью.

        int b = 10;
        a = a-- - --a;
        System.out.println(a);

        int c = 5;
        int d = 2;
        System.out.println(c | d);  // или
        // 101
        // 010
        // 111 получается
        System.out.println(c & d); //и
        //101
        //010
        //000

        String s = "qwer1";
        boolean e = s.length() >= 5 && s.charAt(4) == '1'; // длина строки >= 5 и 4й символ равен 1.
        System.out.println(e);

        int [] q = new int [10];
        q [1] = 10;
        System.out.println(q[1]);


        int [] arr [] = new int [3][5];
        for (int [] line : arr) {
            for (int item : line) {
                System.out.printf("%d", item);
            }
            System.out.println();
        }
        System.out.println();

        int [][] arr2 = new int [3][5];
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                System.out.printf("%d", arr2[i][j]);
            }
            System.out.println();
        }


    }
    static String getType(Object o){
        return o.getClass().getSimpleName();
    }
}
