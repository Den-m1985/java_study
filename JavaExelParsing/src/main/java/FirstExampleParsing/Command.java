package FirstExampleParsing;

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
    public Command() {
    }


    public void command(String pathCSV, String pathXLS) throws IOException, CsvException {

        long start = System.nanoTime();

        // read csv
        Map<String, String> data;
        CsvRead2 csvRead = new CsvRead2(pathCSV);
        data = csvRead.readCSV();

        // read xls
        int numberSheet = 0;  // номер страницы в файле.
        ReadExel readExel = new ReadExel(pathXLS, numberSheet);
        HSSFWorkbook workbook = readExel.findCellEXEL(data);

        // write xls
        WriteOldExel writeOldExel = new WriteOldExel(workbook, pathXLS);
        writeOldExel.writeCellExel();

        //no find article
        List<String> list;
        list = readExel.getNotUseArticle();

        //create no find article
        CreateOldExel createOldExel = new CreateOldExel();
        HSSFWorkbook workbook2 = createOldExel.createOldExel(list);

        //write no find article
        Date date = new Date();
        String downloadsPath = date.currentDate();
        WriteOldExel writeOldExel2 = new WriteOldExel(workbook2, downloadsPath);
        writeOldExel2.writeCellExel();


        long end = System.nanoTime();
        long a = end - start;
        System.out.println("Time in sec: " + a / 1000000000);

    }

}