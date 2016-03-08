/**
 * Created by 1o on 21.02.2016.
 */
package by.verenich.texteditor;

import javax.swing.SwingUtilities;

public class Components {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextFrame();
            }
        });
    }
}

