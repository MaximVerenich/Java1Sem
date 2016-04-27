package by.verenich.texteditor.controller;

import by.verenich.texteditor.Caret;
import by.verenich.texteditor.CreateLetter;
import by.verenich.texteditor.LettersContainer;
import by.verenich.texteditor.Line;
import by.verenich.texteditor.TextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerForTextField implements KeyListener {
    private TextField textField;
    private LettersContainer lettersContainer;
    private CreateLetter createLetter;
    private Line line;
    private Caret caret;


    private int keyEnter = 10;
    private int keyDelete = 127;
    private int keyBackSpace = 8;

    public KeyListenerForTextField(TextField textField, LettersContainer lettersContainer, CreateLetter createLetter, Line line, Caret caret) {
        this.textField = textField;
        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
        this.line = line;
        this.caret = caret;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!chekKeyPressed(e)) {
            if (caret.getPosition() != lettersContainer.getLetters().size() - 1) {
                lettersContainer.getLetters().add(caret.getPosition() + 1, createLetter.inputChar(e.getKeyChar()));
            } else {
                lettersContainer.addNewLetter(createLetter.inputChar(e.getKeyChar()));
            }
            caret.setPosition(caret.getPosition() + 1);
        }
        textField.repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_LEFT) {
            for (int i = 0; i < lettersContainer.getLetters().size(); i++) {
                if (caret.getPosition() == i) {
                    caret.setPosition(caret.getPosition() - 1);
                    caret.setCoordinatX(lettersContainer.getLetters().get(i - 1).getCoordinatX());
                }
            }
            textField.repaint();
        }
        if (e.getKeyCode() == e.VK_RIGHT) {
            for (int i = 0; i < lettersContainer.getLetters().size(); i++) {
                if (caret.getPosition() == i) {
                    caret.setPosition(caret.getPosition() + 1);
                    caret.setCoordinatX(lettersContainer.getLetters().get(i + 1).getCoordinatX());
                    break;
                }
            }
            textField.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.VK_ENTER == e.getKeyCode()) {
            lettersContainer.addNewLetter(createLetter.inputChar(e.getKeyChar()));
            textField.repaint();
            caret.setPosition(caret.getPosition() + 1);
        }

        if (e.VK_BACK_SPACE == e.getKeyCode()) {
            lettersContainer.getLetters().remove(caret.getPosition());
            caret.setPosition(caret.getPosition() - 1);
            textField.repaint();
        }

        if (e.VK_DELETE == e.getKeyCode()) {
            if (caret.getPosition() < lettersContainer.getLetters().size() - 1) {
                lettersContainer.getLetters().remove(caret.getPosition() + 1);
                textField.repaint();
            }
        }
    }

    private boolean chekKeyPressed(KeyEvent e) {
        return ((int) e.getKeyChar() == keyEnter ||
                (int) e.getKeyChar() == keyBackSpace ||
                (int) e.getKeyChar() == keyDelete);
    }
}
