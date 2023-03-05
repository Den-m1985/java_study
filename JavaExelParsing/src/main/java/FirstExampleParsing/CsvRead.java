package FirstExampleParsing;

import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvRead {
    public static void main(String[] args) {
        String fileName = "СЕМЕНА.csv";
        String line;
        String[] values;
        StringBuilder str = new StringBuilder();
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "windows-1251"))) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                values = line.split(";");
                System.out.println(values);
                data.add(String.valueOf(line.split(";")));

                //data.add(values[1]);

//                for (String value : data) {
//                    System.out.println(value + " ");
//                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }





        try {
            List<String> data2 = new ArrayList<>();
            //CSVReader reader = new CSVReader(new FileReader(fileName), "UTF-8");
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            String[] line2;

            while ((line2 = reader.readNext()) != null) {

                for (String cell : line2) {
                    //System.out.println(cell);
                    data2.add(cell);

                }
            }
            reader.close();
            // выводим данные на экран
            for (String cell : data2) {
                //System.out.println(cell + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
