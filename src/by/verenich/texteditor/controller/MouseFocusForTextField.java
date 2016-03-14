package by.verenich.texteditor.controller;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseFocusForTextField extends MouseAdapter {
    private JPanel text;

    public MouseFocusForTextField(JPanel text) {

        this.text = text;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        text.requestFocusInWindow();
    }
}
