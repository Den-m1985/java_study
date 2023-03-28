package FirstExampleParsing.csvRead;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFilter {

    private final String fileName;

    public CsvFilter(String fileName) {
        this.fileName = fileName;
    }


    public List<String[]> csvFilter(int cellName, int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        List<String[]> dataCSV = new ArrayList<>();


        for (String[] row : rows) {
            boolean isUnique = true;

            // Проверяем уникальность текущего элемента среди уже имеющихся в новом списке
            for (String[] uniq : dataCSV) {
                if (row[cellName].equals(uniq[0])) {
                    // Строка не уникальна - выходим из цикла по поиску уникальных строк
                    isUnique = false;
                    System.out.println("Повтояющееся имя товара: " + row[cellName]);
                    break;
                }
            }

            if (isUnique) {
                // Если проверяемая строка уникальна, добавляем её в список уникальных строк
                if (isInteger(row[cellItem]))    // check - if cell item is integer?
                    dataCSV.add(row);
            }
        }



        System.out.println();
        System.out.println("количество товаров в csv: " + dataCSV.size());

        return dataCSV;
    }


    boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
