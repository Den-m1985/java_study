package FirstExampleParsing;

import FirstExampleParsing.csvRead.CsvRead2;
import FirstExampleParsing.oldExel.CreateOldExel;
import FirstExampleParsing.oldExel.ReadExel;
import FirstExampleParsing.oldExel.WriteOldExel;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Command {
    public Command() {
    }

    public void command() throws IOException, CsvException {

        long start = System.nanoTime();

        Map<String, String> data;
        CsvRead2 csvRead = new CsvRead2("СЕМЕНА.csv");
        data = csvRead.readCSV();

        String fileNamePrice = "price.xls";
        int numberSheet = 0;  // номер страницы в файле.
        ReadExel readExel = new ReadExel(fileNamePrice, numberSheet);
        HSSFWorkbook workbook = readExel.findCellEXEL(data);

        WriteOldExel writeOldExel = new WriteOldExel(workbook, fileNamePrice);
        writeOldExel.writeCellExel();

        //Записываем то, что не вошло.
        List<String> list;
        list = readExel.getNotUseArticle();

        String fileName = "No_Find.xls";
        CreateOldExel createOldExel = new CreateOldExel();
        HSSFWorkbook workbook2 = createOldExel.createOldExel(list);

        WriteOldExel writeOldExel2 = new WriteOldExel(workbook2, fileName);
        writeOldExel2.writeCellExel();


        long end = System.nanoTime();
        long a = end - start;
        System.out.println("Time in sec: " + a / 1000000000);

    }

}