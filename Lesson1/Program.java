public class Program {
    public static void main(String[] args) {
        var i = 123;
        System.out.println(i);
        System.out.println(getType(i));

        int a = 123265;
        System.out.println(Integer.MAX_VALUE);

        String s = "sdfdf";
        s.charAt(1); // обращаемся к конкретному символу

        int b = 5;
        System.out.println(b++);    // приоритет у b++ (пофикстный инкремент) ниже чем вывод в консоль
        System.out.println(b);    // усли ++b (префиксный инкремент) то приоритет выше чем ввывода в консоль

        int c = 10;
        System.out.println(--c);
        System.out.println(c--);
        c = c-- - --c;
        System.out.println(c);

    }
    static String getType(Object o){
        return o.getClass().getSimpleName();
    }
}
