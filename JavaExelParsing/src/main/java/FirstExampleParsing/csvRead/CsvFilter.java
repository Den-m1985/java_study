package FirstExampleParsing.csvRead;

import FirstExampleParsing.csvRead.csv.CsvRead;
import FirstExampleParsing.csvRead.csv.DuplicateGoods;
import FirstExampleParsing.csvRead.csv.OnlyGoods;
import FirstExampleParsing.csvRead.csv.StructureCSV;
import FirstExampleParsing.csvRead.csv.UniqueGoods;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class CsvFilter {

    private final String fileName;
    private List<String[]> error;

    public CsvFilter(String fileName) {
        this.fileName = fileName;
    }


    public List<StructureCSV> csvFilter(int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        OnlyGoods onlyGoods = new OnlyGoods();
        List<StructureCSV> dataWithItem = onlyGoods.onlyGoods(rows,cellItem);
        error = onlyGoods.reportCSV();

        // этот блок возвращает иникальные элементы
        UniqueGoods uniqueGoods = new UniqueGoods();
        List<StructureCSV> uniqueValues = uniqueGoods.uniqueGoods(dataWithItem);
        List<StructureCSV> duplicateNames = uniqueGoods.getDuplicateNames();

        // этот блок работатет с повторяющимися именами.
        if (duplicateNames != null) {
            List<StructureCSV> resolveDuplicatedNames = new DuplicateGoods().duplicateGoods(duplicateNames);
            uniqueValues.addAll(resolveDuplicatedNames);
        }

//        for (StructureCSV x:uniqueValues) {
//            System.out.println(x.toString());
//        }

        System.out.println();
        System.out.println("количество товаров в csv: " + uniqueValues.size());

        return uniqueValues;
    }

    public List<String[]> getError() {
        return error;
    }


}
