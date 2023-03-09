package FirstExampleParsing.csvRead;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.util.*;


public class CsvRead2 {


    private final String fileName;
    private final Map<String, String> dataCSV;

    public CsvRead2(String fileName) {
        this.dataCSV = new HashMap<>();
        this.fileName = fileName;
    }


    public Map<String, String> readCSV() throws IOException, CsvException {

        Reader reader = new InputStreamReader(new FileInputStream(fileName), "windows-1251");
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); // задание разделителя
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
        List<String[]> rows = csvReader.readAll(); // чтение всех строк в файле

        for (String[] row : rows) {
            if (row.length > 3) {
                if (row[1] != null) {
                    dataCSV.put(row[1], row[3]);
//                    System.out.println(row.length + "      " + row[0] + "      " + row[1] + "        " + row[2] +
//                            "       " + row[3] + "     "+ row[4]);
                    //System.out.println(row[3]);
                }
            }
        }
        reader.close();
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
