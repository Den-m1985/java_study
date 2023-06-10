package FirstExampleParsing.csvRead.csv;

import java.util.ArrayList;
import java.util.List;

public class OnlyGoods {
    private List<String[]> reportCSV;

    public OnlyGoods() {
    }


    public List<StructureCSV> onlyGoods(List<String[]> rows, int cellItem) {

        List<StructureCSV> dataWithItem = new ArrayList<>();
        reportCSV = new ArrayList<>();

        for (String[] row : rows) {
            // Бывает, что в исходнике некорректно сделана структура, эти позиции отправляются в итоговый отчет.
            try {

                int wrong = row[4].length();
                if (wrong>0){
                    String[] error = {row[0], "Неверный формат CSV"};
                    reportCSV.add(error);
                }
            } catch (Exception ignored) {}

            // Если в ячейке price и item число, то эту строку добавляем для дальнейшей работы.
            if (isInteger(row[cellItem])) {
                int item = stringToInt(row[cellItem]);
                dataWithItem.add(new StructureCSV(row[0], row[1], row[2], item));
            }
        }
        return dataWithItem;
    }


    public List<String[]> reportCSV() {
        return reportCSV;
    }


    static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            stringToInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    static int stringToInt(String str) {
        return Integer.parseInt(str);
    }


}
