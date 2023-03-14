package FirstExampleParsing.window;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Date;

public class Delete  extends JFrame{

    /**
     * The text area which is used for displaying logging information.
     */
    private JTextArea textArea;

    private JButton buttonStart = new JButton("Start");
    private JButton buttonClear = new JButton("Clear");

    private PrintStream standardOut;

    public Delete() {
        super("Demo printing to JTextArea");

        textArea = new JTextArea(50, 10);   // число строк и кол-во их
        textArea.setEditable(false);

        //Печатает текст в окно
        PrintStream printStream = new PrintStream(new Delete2(textArea));

        // keeps reference of standard output stream
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);  // вывод текста на экран с кнопки старт
        System.setErr(printStream);

        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        //Делает рамку вокруг
        constraints.insets = new Insets(10, 10, 10, 10);
        //Делает кнопки рядом
        constraints.anchor = GridBagConstraints.WEST;

        // Добавляем кнопку
        add(buttonStart, constraints);

        // если его нет, то кнопки одна на одной
        constraints.gridx = 1;
        add(buttonClear, constraints);

        // окно для текста по центру
        constraints.gridx = 0;
        constraints.gridy = 1;  // кнпки поверх текстового окна.
        constraints.gridwidth = 2;  // разметка текстового окна
        constraints.fill = GridBagConstraints.BOTH;  //текстовое окно
        constraints.weightx = 1.0;  // разметка текстового окна
        constraints.weighty = 1.0;  // разметка текстового окна

        add(new JScrollPane(textArea), constraints);  // Добавляет текстовое поле.

        // adds event handler for button Start
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                printLog();
            }
        });

        // adds event handler for button Clear
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // clears the text area
                try {
                    textArea.getDocument().remove(0,
                            textArea.getDocument().getLength());
                    standardOut.println("Text area cleared");
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);    // centers on screen
    }

    /**
     * Prints log statements for testing in a thread
     */
    private void printLog() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Time now is " + (new Date()));
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    /**
     * Runs the program
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Delete().setVisible(true);
            }
        });
    }





}
