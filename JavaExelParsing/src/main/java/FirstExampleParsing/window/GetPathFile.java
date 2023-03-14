package FirstExampleParsing.window;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class GetPathFile {
    private String path;


    public String getPathFile() {

        JFileChooser fileopen = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.xls), XML files (*.csv)", "xls", "csv");
        fileopen.setFileFilter(filter);

        // open directory by default.
        fileopen.setCurrentDirectory(new File(System.getProperty("user.home") + File.separator +
                "Downloads"));
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            path = file.getAbsolutePath();
        }

        return path;
    }
}