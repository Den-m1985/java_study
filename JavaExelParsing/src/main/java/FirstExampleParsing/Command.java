package FirstExampleParsing;

import FirstExampleParsing.createPathFile.CreatePathFile;
import FirstExampleParsing.csvRead.CsvFilter;
import FirstExampleParsing.csvRead.csv.StructureCSV;
import FirstExampleParsing.oldExel.CreateOldExel;
import FirstExampleParsing.oldExel.ReadExel;
import FirstExampleParsing.oldExel.WriteOldExel;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Command {

    public Command() {
    }


    public void command(String pathCSV, String pathXLS) throws IOException, CsvException {

        long start = System.nanoTime();

        // Read csv
        int cellItem = 3;   // Cell with item to order
        CsvFilter csvFilter = new CsvFilter(pathCSV);
        List<StructureCSV> data = csvFilter.csvFilter(cellItem);
        List<String[]> reportList = new ArrayList<>(csvFilter.getError());

        // read xls
        int numberSheet = 0;  // номер страницы в файле.
        int cellEXL = 1;  //  // Cell with articular
        int cellPoint = 5;  //номер строки куда мы записываем
        ReadExel readExel = new ReadExel(pathXLS);
        HSSFWorkbook workbook = readExel.findCellEXEL(data, cellEXL, cellPoint, numberSheet);

        // write xls. new path "Price" in downloads
        CreatePathFile createPathFile = new CreatePathFile();
        String pricePath = createPathFile.createPathFile("Price", ".xls");

        WriteOldExel writeOldExel = new WriteOldExel(workbook, pricePath);
        writeOldExel.writeCellExel();

        //no find article
        reportList.addAll(readExel.getNotUseArticle());

        //create no find article
        CreateOldExel createOldExel = new CreateOldExel();
        HSSFWorkbook workbook2 = createOldExel.createOldExel(reportList);

        //write no find article, xls file in downloads
        String downloadsPath = createPathFile.createPathFile("No_Find_Seeds", ".xls");
        WriteOldExel writeOldExel2 = new WriteOldExel(workbook2, downloadsPath);
        writeOldExel2.writeCellExel();

        System.out.println();
        System.out.println("Сохраненные файлы");
        System.out.println(pricePath);
        System.out.println(downloadsPath);
        System.out.println();

        long end = System.nanoTime();
        long a = end - start;

        System.out.println("У С П Е Ш Н О");
        System.out.println("Время выполнения: " + a / 1000000000 + "сек");
        System.out.println("Оля молодец");
        System.out.println();
        System.out.println("Попей чайку");
        System.out.println();

    }

}