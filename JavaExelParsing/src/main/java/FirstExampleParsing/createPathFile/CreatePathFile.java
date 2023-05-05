package FirstExampleParsing.createPathFile;

import java.io.File;

public class CreatePathFile {

    public CreatePathFile() {
    }


    public String  createPathFile (String fileName, String extension){

        Date date = new Date();
        String str = date.currentDate();

        // где File.separator - это разделитель для текущей операционной системы
//        String downloadsPath = System.getProperty("user.home") + File.separator +
//                "Downloads\\No_Find_" + str + ".xls";

        return System.getProperty("user.home") + File.separator +
                "Downloads\\" + fileName + "_" + str + extension;
    }


}
