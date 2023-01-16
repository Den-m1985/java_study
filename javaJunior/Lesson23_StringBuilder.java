public class Lesson23_StringBuilder {
    public static void main(String[] args) {
        String x = "hello";  // не изменяемый тип строки
        x.toUpperCase();
        //System.out.println(x);  // hello
        x = x.toUpperCase();
        //System.out.println(x);  // HELLO

        String str1 = "Hello";
        String str2 = "my";
        String str3 = "jrjrjrj";
        String strAll = str1 + str2 + str3; // Здесь программа создает доп. 2 строки (str1 + str2) и (str1 + str2) + str3.
        //System.out.println(strAll);

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" my").append(" friends");
        System.out.println(sb.toString());
    }
}
