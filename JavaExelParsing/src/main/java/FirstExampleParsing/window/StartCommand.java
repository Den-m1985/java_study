package FirstExampleParsing.window;

import FirstExampleParsing.Command;
import com.opencsv.exceptions.CsvException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartCommand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String pathCSV = null;
        String pathXLS = null;

        GetPathFile getPathFile = new GetPathFile();

        int i = 0;
        while (i < 2) {
            pathCSV = getPathFile.getPathFile("csv");
            if (pathCSV != null)
                break;
            else i++;
        }

        int j = 0;
        while (j < 2) {
            pathXLS = getPathFile.getPathFile("xls");
            if (pathXLS != null)
                break;
            else j++;
        }
        System.out.println();
        System.out.println("Файлы исходники:");
        System.out.println(pathCSV);
        System.out.println(pathXLS);
        System.out.println();

        Command startProgram = new Command();

        try {
            startProgram.command(pathCSV, pathXLS);

        } catch (IOException | CsvException ex) {
            throw new RuntimeException(ex);
        }

    }

}
