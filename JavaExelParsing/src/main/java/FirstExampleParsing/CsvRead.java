package FirstExampleParsing;

import java.io.*;
import java.util.*;

public class CsvRead {
    private final String fileName;
    private final Map<String, String> dataCSV;

    public CsvRead(String fileName) {
        this.dataCSV = new HashMap<>();
        this.fileName = fileName;
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