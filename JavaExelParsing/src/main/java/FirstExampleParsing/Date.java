package FirstExampleParsing;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    private String downloadsPath;

    public Date() {

    }

    public String getDownloadsPath() {
        return downloadsPath;
    }

    public String currentDate() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        String formattedDate = currentDate.format(formatter);
        //System.out.println(formattedDate); // напечатает текущую дату в формате "дд.мм.гггг"

        // где File.separator - это разделитель для текущей операционной системы
        downloadsPath = System.getProperty("user.home") + File.separator +
                "Downloads\\No_Find_" + formattedDate + ".xls";

        return downloadsPath;
    }

}
