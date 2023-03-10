package FirstExampleParsing.window;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class Delete2 extends OutputStream{

    private JTextArea textArea;

    public Delete2(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
