package FirstExampleParsing.window;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {


    public Window() {
        super("Програмка для Оли");
        super.setBounds(200, 100, 450, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(2, 1, 5, 5));
        JButton button1 = new JButton("Жмякай");
        JLabel label = new JLabel("Выбирай файлы xls(прайс поставщика) и csv(с СП39) в любом порядке");
        container.add(button1);
        container.add(label);

        button1.addActionListener(new StartCommand());

    }
}
