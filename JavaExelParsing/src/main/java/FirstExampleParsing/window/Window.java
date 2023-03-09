package FirstExampleParsing.window;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {


    public Window() {
        super("Заголовок");
        super.setBounds(200, 100, 400, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(1, 2, 5, 5));
        JButton button1 = new JButton("Поехали");
        container.add(button1);

        button1.addActionListener(new StartCommand());

    }
}
