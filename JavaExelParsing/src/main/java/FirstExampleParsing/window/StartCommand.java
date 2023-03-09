package FirstExampleParsing.window;

import FirstExampleParsing.Command;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static FirstExampleParsing.window.CheckFileExtension.isExtension;

public class StartCommand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {


        String str = "";
        String pathCSV = "";
        String pathXLS = "";

        for (int i = 0; i < 2; i++) {
            while (true) {
                GetPathFile getPathFile1 = new GetPathFile();
                str = getPathFile1.getPathFile();

                if (isExtension(str)) {
                    String[] strings = str.split("\\.");
                    if (strings[1].equals("csv")) {
                        pathCSV = str;
                        break;
                    } else pathXLS = str;
                    break;
                }
                JOptionPane.showMessageDialog(null, "Не тот формат");
            }
        }


        System.out.println(pathCSV);
        System.out.println(pathXLS);

        Command startProgram = new Command();
        try {

            startProgram.command(pathCSV, pathXLS);


        } catch (IOException | CsvException ex) {
            throw new RuntimeException(ex);
        }

        JOptionPane.showMessageDialog(null, "Успешно");


    }
}
