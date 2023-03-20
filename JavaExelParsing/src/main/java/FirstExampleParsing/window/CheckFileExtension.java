package FirstExampleParsing.window;

public class CheckFileExtension {

    public static boolean isExtension(String str) {
        String[] array = str.split("\\.");
        int extention = array.length - 1;

        return array[extention].equals("csv") || array[extention].equals("xls");
    }

}
