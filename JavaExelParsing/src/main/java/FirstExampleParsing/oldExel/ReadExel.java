package FirstExampleParsing.oldExel;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadExel {
    private final String fileNamePrice;
    private final int numberSheet;


    private final List<String> notUseArticle= new ArrayList<>();


    public ReadExel(String fileNamePrice, int numberSheet) {
        this.fileNamePrice = fileNamePrice;
        this.numberSheet = numberSheet;
    }


    public List<String> getNotUseArticle() {
        return notUseArticle;
    }


    public HSSFWorkbook findCellEXEL(Map<String, String> data) {
        //Row  строка
        //Cell столб

        OpenOldExelFile openOldExelFile = new OpenOldExelFile(fileNamePrice);
        HSSFWorkbook workbook = openOldExelFile.openFile();
        HSSFSheet sheet = workbook.getSheetAt(numberSheet);

        int cellPoint = 5;  //номер строки куда мы записываем
        int count = 1;
        int count2 = 1;
        String code = "";
        List<String> list = new ArrayList<>();

        for (var csv : data.entrySet()) {
            String key = csv.getKey();

            for (Row row : sheet) {
                Cell cell1 = row.getCell(1);
                if (cell1 != null) {
                    code = cell1.getStringCellValue();
                    if (code.equals(key)) {
                        count2++;
                        list.add(key);

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

        for (var csv : data.entrySet()) {
            String str = csv.getKey();
            if (list.contains(str)) {
            } else {
                notUseArticle.add(str);

            }
        }

        System.out.println("кол-во строк не вошедших в price " + notUseArticle.size());
        System.out.println("число строк " + count);
        System.out.println("число строк от команды sheet.getRow(0).getHeight() " + sheet.getRow(0).getHeight());
        System.out.println("число совпадений " + count2);

        return workbook;
    }


}