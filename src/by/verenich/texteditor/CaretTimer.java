package by.verenich.texteditor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 1o on 19.04.2016.
 */
public class CaretTimer {
    private Caret caret;

    public CaretTimer(TextField textField) {
        caret = textField.getCaret();
        final Timer time = new Timer();
        time.schedule(new TimerTask() {
            public void run() {
                caret.drawCaret();
            }
        }, 500, 1000);
    }
}
