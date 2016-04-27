package by.verenich.texteditor.controller;

import by.verenich.texteditor.Caret;
import by.verenich.texteditor.LettersContainer;
import by.verenich.texteditor.Line;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFocusForTextField implements MouseListener {

    private JPanel text;
    private Caret caret;
    private LettersContainer lettersContainer;
    private Line line;

    public MouseFocusForTextField(JPanel text, Caret caret, LettersContainer lettersContainer, Line line) {
        this.text = text;
        this.caret = caret;
        this.lettersContainer = lettersContainer;
        this.line = line;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

