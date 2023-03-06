package FirstExampleParsing;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {

        //List<String> data = new ArrayList<>();
        Map<String, String> data = new HashMap<>();
        CsvRead csvRead = new CsvRead("СЕМЕНА.csv");
        data = csvRead.readCSV();
        //System.out.println(data.size());
//        for (var x : data.entrySet()) {
//            System.out.println(x.getKey());
//            System.out.println(x.getValue());
//        }


        //FileInputStream inputStream = null;
        //HSSFWorkbook workbook = null;
        try {
            // Чтение .xls файла
            FileInputStream inputStream = new FileInputStream(new File("price.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);


            //ArrayList<String> article = new ArrayList<>();
            int count = 0;
            String code = "";

            for (Row row : sheet) {
                count++;
                Cell cell1 = row.getCell(1);
                if (cell1 != null) {
                    code = cell1.getStringCellValue();
                    //article.add(code);
                    for (var csv : data.entrySet()) {
                        if (code.equals(csv.getKey())) {
                            System.out.println(cell1);
                            System.out.println(count);


                            Row row2 = sheet.getRow(count); // получаем  строку
                            Cell cell = row2.getCell(5); // получаем  ячейку

                            if (cell == null) { // если ячейка пустая, создаем ее
                                cell = row.createCell(5);
                            }

                            cell.setCellValue(csv.getValue());

                            try {
                                FileOutputStream outputStream = new FileOutputStream("price.xls");
                                workbook.write(outputStream);
                                workbook.close();
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }


                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}