package FirstExampleParsing.csvRead;

import FirstExampleParsing.csvRead.csv.CsvRead;
import FirstExampleParsing.csvRead.csv.OnlyGoods;
import FirstExampleParsing.csvRead.csv.StructureCSV;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class TestCSV {
    public static void main(String[] args) throws IOException, CsvException {

        String fileName = "C:\\Users\\denis\\OneDrive\\Рабочий стол\\ForOrder\\семена 16.03.csv";
        int cellItem = 3;   // Cell with item to order

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        OnlyGoods onlyGoods = new OnlyGoods();
        List<StructureCSV> dataWithItem = onlyGoods.onlyGoods(rows, cellItem);
        List<String[]> error = onlyGoods.reportCSV();

        for (StructureCSV x : dataWithItem) {
            System.out.println(x.getName() + "----" + x.getPrice());
        }
    }
}
