package by.verenich.texteditor.controller;

import by.verenich.texteditor.Allocation;
import by.verenich.texteditor.Caret;
import by.verenich.texteditor.CreateLetter;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFocusForTextField implements MouseListener {

    private JPanel text;
    private Caret caret;

    public MouseFocusForTextField(JPanel text, Caret caret) {
        this.text = text;
        this.caret = caret;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        caret.setCoordinatX(e.getX());
        caret.setCoordinatY(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

