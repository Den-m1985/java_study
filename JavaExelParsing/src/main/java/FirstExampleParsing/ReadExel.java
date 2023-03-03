package FirstExampleParsing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExel {

    public static void main(String[] args) {
        try {
//            FileInputStream file = new FileInputStream(new File("1.xlsx"));
//            System.out.println("Open");
//            // Создаем экземпляр класса XSSFWorkbook для чтения xlsx-файла
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            System.out.println("Read");


            OpenFile openFile = new OpenFile();
            XSSFWorkbook workbook = openFile.openFile();

            // Получаем первый лист в книге Excel
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Идем по строкам и столбцам в таблице
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    XSSFCell cell = row.getCell(j);
                    //System.out.println(cell);
                    //System.out.print(cell.getStringCellValue() + "\t\t");
                }
                //System.out.println("");
            }

//            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
