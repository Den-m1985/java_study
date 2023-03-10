package FirstExampleParsing;

import FirstExampleParsing.createPathFile.CreatePathFile;
import FirstExampleParsing.csvRead.CsvRead2;
import FirstExampleParsing.oldExel.CreateOldExel;
import FirstExampleParsing.oldExel.ReadExel;
import FirstExampleParsing.oldExel.WriteOldExel;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Command {
    int countNoFind;
    int countFind;
    public Command() {
    }


    public void command(String pathCSV, String pathXLS) throws IOException, CsvException {

        long start = System.nanoTime();

        CreatePathFile createPathFile = new CreatePathFile();

        // read csv
        Map<String, String> data;
        CsvRead2 csvRead = new CsvRead2(pathCSV);
        data = csvRead.readCSV();

        // read xls
        int numberSheet = 0;  // номер страницы в файле.
        ReadExel readExel = new ReadExel(pathXLS, numberSheet);
        HSSFWorkbook workbook = readExel.findCellEXEL(data);

        // write xls. new path "Price" in downloads
        String pricePath = createPathFile.createPathFile("Price");
        WriteOldExel writeOldExel = new WriteOldExel(workbook, pricePath);
        writeOldExel.writeCellExel();

        //no find article
        List<String> list;
        list = readExel.getNotUseArticle();
        countNoFind = list.size();
        countFind = readExel.getCount2();

        //create no find article
        CreateOldExel createOldExel = new CreateOldExel();
        HSSFWorkbook workbook2 = createOldExel.createOldExel(list);

        //write no find article, xls file in downloads
        String downloadsPath = createPathFile.createPathFile("No_Find");
        WriteOldExel writeOldExel2 = new WriteOldExel(workbook2, downloadsPath);
        writeOldExel2.writeCellExel();


        long end = System.nanoTime();
        long a = end - start;
        System.out.println("Time in sec: " + a / 1000000000);

    }


    public int getCountNoFind() {
        return countNoFind;
    }

    public int getCountFind() {
        return countFind;
    }
}