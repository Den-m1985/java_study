package FirstExampleParsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;

public class OldExel {
    public static void main(String[] args) {


        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        try {
            // Чтение .xls файла
            inputStream = new FileInputStream(new File("price.xls"));
            workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                HSSFRow row = (HSSFRow) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    HSSFCell cell = (HSSFCell) cellIterator.next();
                    System.out.print(cell.getStringCellValue() + " ");
                }
                System.out.println("");
            }

            // Запись в .xls файл
//        HSSFSheet outputSheet = workbook.createSheet("Output Sheet");
//        for (int i = 0; i < 5; i++) {
//            HSSFRow row = outputSheet.createRow(i);
//            for (int j = 0; j < 5; j++) {
//                HSSFCell cell = row.createCell(j);
//                cell.setCellValue("Cell " + i + "," + j);
//            }
//        }
//        FileOutputStream outputStream = new FileOutputStream("output.xls");
//        workbook.write(outputStream);
//        outputStream.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
