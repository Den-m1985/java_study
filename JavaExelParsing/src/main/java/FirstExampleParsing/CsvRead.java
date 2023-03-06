package FirstExampleParsing;

import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CsvRead {
    //private List<String> dataCSV;
    private String fileName;
    private Map<String, String> dataCSV;

    public CsvRead(String fileName) {
        //this.dataCSV = new ArrayList<>();
        this.dataCSV = new HashMap<>();
        this.fileName = fileName;
    }

    public static void main(String[] args) {


//        try {
//            List<String> data2 = new ArrayList<>();
//            //CSVReader reader = new CSVReader(new FileReader(fileName), "UTF-8");
//            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
//
//            String[] line2;
//
//            while ((line2 = reader.readNext()) != null) {
//
//                for (String cell : line2) {
//                    //System.out.println(cell);
//                    data2.add(cell);
//
//                }
//            }
//            reader.close();
//            // выводим данные на экран
//            for (String cell : data2) {
//                //System.out.println(cell + " ");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    public Map<String, String> readCSV() {
        String line;
        String[] values;
        StringBuilder str = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "windows-1251"))) {
            while ((line = bufferedReader.readLine()) != null) {
                values = line.split(";");

                if (values.length > 3 && values.length < 5) {
                    if (values[1] != null)
                        //dataCSV.add(values[1]);
                        dataCSV.put(values[1], values[3]);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataCSV;
    }

}
/*
HashMap
put(K,V) – добавить пару если или изменить значение,если ключ имеется.
putIfAbsent(K,V) – произвести добавление если ключ не найден.
get(K) - получение значения по указанному ключу.
remove(K) – удаляет пару по указанному ключу.
containsValue(V) – проверка наличия значения.
containsKey(V) – проверка наличия ключа.
keySet() – возвращает множество ключей.
values() – возвращает набор значений.
 */