package FirstExampleParsing.window.helper_classes;

import javax.swing.*;
import java.util.Objects;

public class MyMenuBar {


    public JMenuBar menuBar (){
        JMenuBar menuBar = new JMenuBar();

        // Создание выпадающего меню
        JMenu file = new JMenu("Дополнительно");

        JMenuItem info = new JMenuItem();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/info40.png")));
        info.setIcon(icon);
        file.add(info);
        info.addActionListener(arg0 -> new Info());

        menuBar.add(file);
        return menuBar;
    }

}
