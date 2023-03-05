package FirstExampleParsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class OldExel {
    public static void main(String[] args) {
        //Row  строка
        //Cell столб

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        try {
            // Чтение .xls файла
            inputStream = new FileInputStream(new File("price.xls"));
            workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rowIterator = sheet.iterator();


            ArrayList<String> article = new ArrayList<>();
            String xxvc = "УТ000008562";
            int count = 0;

            // Читаем столбец с артиклем полностью. Находим совпадения.
            for (Row x : sheet) {
                Cell cell1 = x.getCell(1);
                count++;
                if (cell1 != null) {
                    String code = "";
                    code = cell1.getStringCellValue();
                    article.add(code);

                    if (code.equals(xxvc)) {
                        System.out.println(cell1);
                        System.out.println(count);




                        Row row = sheet.getRow(count); // получаем  строку
                        Cell cell = row.getCell(5); // получаем  ячейку

                        if (cell == null) { // если ячейка пустая, создаем ее
                            cell = row.createCell(5);
                        }

                        cell.setCellValue("Пример строки2");



                        try {
                            FileOutputStream outputStream = new FileOutputStream("price.xls");
                            workbook.write(outputStream);
                            workbook.close();
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                    }
                    //System.out.println(cell1);
                }
            }

            for (String x : article) {
                //System.out.println(x);
            }


            while (rowIterator.hasNext()) {

                HSSFRow row = (HSSFRow) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    HSSFCell cell = (HSSFCell) cellIterator.next();
                    //System.out.print(cell.getStringCellValue() + " ");
                    //System.out.println(row.getRowNum());
                }
                //System.out.println("");
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
