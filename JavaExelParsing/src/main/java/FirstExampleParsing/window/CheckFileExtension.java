package FirstExampleParsing.window;

public class CheckFileExtension {

    public static boolean isExtension(String str) {
        String[] array = str.split("\\.");

        return array[1].equals("csv") || array[1].equals("xls");
    }

}
