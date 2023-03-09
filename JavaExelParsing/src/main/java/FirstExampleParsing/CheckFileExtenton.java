package FirstExampleParsing;

public class CheckFileExtenton {

   public static boolean isExtettion(String str){
        String [] array = str.split("\\.");

        if (array[1].equals("csv") && array[1].equals("xls")) return true;

        return false;
    }

}
