package FirstExampleParsing.oldExel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public class CreateOldExel {

    private List<String> cell;

    public CreateOldExel() {
    }

    public HSSFWorkbook createOldExel(List<String> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        //Row  строка
        //Cell столб
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Артиклы не найденые в price");

        for (int i = 2; i < list.size(); i++) {
            Row row2 = sheet.createRow(i);
            row2.createCell(0).setCellValue(list.get(i));
        }

        return workbook;
    }
}
