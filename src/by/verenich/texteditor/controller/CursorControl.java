package by.verenich.texteditor.controller;

import by.verenich.texteditor.TextField;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CursorControl implements MouseMotionListener {

    private TextField textField;

    public CursorControl(TextField textField) {
        this.textField = textField;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }

}
