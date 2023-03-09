package FirstExampleParsing;

import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static FirstExampleParsing.CheckFileExtenton.isExtettion;

public class StartCommand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Command startProgram = new Command();
        String str = "";
        String pathCSV = "";
        String pathXLS = "";

        for (int i = 0; i < 2; i++) {
            while (true) {
                GetPathFile getPathFile1 = new GetPathFile();
                str = getPathFile1.getPathFile();
                //System.out.println(str);
                if (!isExtettion(str)) JOptionPane.showMessageDialog(null, "Не тот формат");

                String[] strings = str.split("\\.");
                if (strings[1].equals("csv")) {
                    pathCSV = str;
                    break;
                } else pathXLS = str;
                break;


            }
            System.out.println(i);
        }
        System.out.println(pathCSV);
        System.out.println(pathXLS);

        //startProgram.command();

        JOptionPane.showMessageDialog(null, "Успешно");


    }
}
