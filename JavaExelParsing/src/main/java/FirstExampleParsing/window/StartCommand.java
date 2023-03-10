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

        GetPathFile getPathFile = new GetPathFile();
        String str = "";
        String pathCSV = "";
        String pathXLS = "";

        for (int i = 0; i < 2; i++) {
            while (true) {
                str = getPathFile.getPathFile();

                if (isExtension(str)) {
                    String[] strings = str.split("\\.");

                    if (!str.equals(pathCSV) && !str.equals(pathXLS)) {
                        if (strings[1].equals("csv")) {
                            pathCSV = str;
                            break;
                        } else if (strings[1].equals("xls")) {
                            pathXLS = str;
                            break;
                        }
                    } else JOptionPane.showMessageDialog(null, "Уже было");
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

        JOptionPane.showMessageDialog(null, "<html>Успешно" +
                "<li>кол-во строк не вошедших в price: </ul>" + startProgram.getCountNoFind()+
                "<li>число совпвдений: </ul>" + startProgram.getCountFind());


    }
}
