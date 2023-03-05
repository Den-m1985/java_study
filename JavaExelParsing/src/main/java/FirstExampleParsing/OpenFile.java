package FirstExampleParsing;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpenFile {

    public XSSFWorkbook openFile() throws IOException {
        String x = "1.xlsx";
        FileInputStream file = new FileInputStream(new File(x));
        System.out.println("Open");
        // Создаем экземпляр класса XSSFWorkbook для чтения xlsx-файла
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        System.out.println("Read");
        file.close();
        return workbook;
    }
}
