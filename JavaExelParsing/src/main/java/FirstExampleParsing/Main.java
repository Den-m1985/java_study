package FirstExampleParsing;

import FirstExampleParsing.oldExel.ReadExel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        long start = System.nanoTime();

        Map<String, String> data = new HashMap<>();
        CsvRead csvRead = new CsvRead("СЕМЕНА.csv");
        data = csvRead.readCSV();

        int numberSheet = 0;  // номер страницы в файле.
        ReadExel readExel = new ReadExel("price.xls", numberSheet);
        readExel.findCellEXEL(data);

        long end = System.nanoTime();
        long a = end - start;
        System.out.println("Time in nano sec: " + a);

    }
}