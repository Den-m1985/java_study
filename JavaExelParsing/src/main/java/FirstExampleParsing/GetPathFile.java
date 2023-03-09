package FirstExampleParsing;

import javax.swing.*;
import java.io.File;

public class GetPathFile {
    private String path;


    public String  getPathFile() {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            path = file.getAbsolutePath();
        }

        return path;
    }
}