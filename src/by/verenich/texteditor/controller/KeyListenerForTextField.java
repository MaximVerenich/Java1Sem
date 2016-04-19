package by.verenich.texteditor.controller;

import by.verenich.texteditor.CreateLetter;
import by.verenich.texteditor.Letter;
import by.verenich.texteditor.LettersContainer;
import by.verenich.texteditor.TextField;

import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerForTextField implements KeyListener {
    private TextField textField;
    private LettersContainer lettersContainer;
    private CreateLetter createLetter;

    private int keyEnter = 10;
    private int keyDelete = 127;
    private int keyBackSpace = 8;

    public KeyListenerForTextField(TextField textField, LettersContainer lettersContainer, CreateLetter createLetter) {
        this.textField = textField;
        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(!chekKeyPressed(e)){
            lettersContainer.addNewLetter(createLetter.inputChar(e.getKeyChar()));
            textField.repaint();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if(e.VK_ENTER == e.getKeyCode()){
//            textField.inputKeyEnter();
//            textField.repaint();
//        }
//        else if(e.VK_DELETE == e.getKeyCode()){
//            textField.inputKeyDelete();
//            textField.repaint();
//        }
//        else if(e.VK_BACK_SPACE == e.getKeyCode()){
//            textField.inputKeyBackSpace();
//            textField.repaint();
//        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.VK_ENTER == e.getKeyCode()){
            lettersContainer.addNewLetter(createLetter.inputChar(e.getKeyChar()));
            textField.repaint();
        }
    }

    private boolean chekKeyPressed(KeyEvent e){
       return ((int) e.getKeyChar() == keyEnter ||
               (int) e.getKeyChar() == keyBackSpace ||
               (int) e.getKeyChar() == keyDelete);
    }
}
