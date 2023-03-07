package FirstExampleParsing.oldExel;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Map;

public class ReadExel {
    private String fileNamePrice;
    private int numberSheet;



    public ReadExel(String fileNamePrice, int numberSheet) {
        this.fileNamePrice = fileNamePrice;
        this.numberSheet = numberSheet;
    }



    public void findCellEXEL(Map<String, String> data) {
        //Row  строка
        //Cell столб


        OpenOldExelFile openOldExelFile = new OpenOldExelFile(fileNamePrice);
        HSSFWorkbook workbook = openOldExelFile.openFile();
        HSSFSheet sheet = workbook.getSheetAt(numberSheet);


        int cellPoint = 5;  //номер строки куда мы записываем
        int count = 0;
        int count2 = 0;
        String code = "";

        for (Row row : sheet) {
            Cell cell1 = row.getCell(1);
            if (cell1 != null) {
                code = cell1.getStringCellValue();
                for (var csv : data.entrySet()) {
                    if (code.equals(csv.getKey())) {
                        count2++;
                        Row row2 = sheet.getRow(row.getRowNum()); // получаем  строку
                        Cell cell = row2.getCell(cellPoint); // получаем  ячейку

                        if (cell == null) { // если ячейка пустая, создаем ее
                            cell = row.createCell(cellPoint);
                        }
                        cell.setCellValue(csv.getValue());
                    }
                }
            }
            count++;
        }
        System.out.println("число строк " + count + " число строк от команды " + sheet.getRow(0).getHeight());
        System.out.println("число совпадений " + count2);

        // записываем данные в файл
        WriteOldExel writeOldExel = new WriteOldExel(workbook, fileNamePrice);
        writeOldExel.writeCellExel();


    }
}