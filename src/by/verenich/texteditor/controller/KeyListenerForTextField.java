package by.verenich.texteditor.controller;

import by.verenich.texteditor.Caret;
import by.verenich.texteditor.CreateLetter;
import by.verenich.texteditor.Letter;
import by.verenich.texteditor.LettersContainer;
import by.verenich.texteditor.Line;
import by.verenich.texteditor.TextField;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
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
        if(!chekKeyPressed(e)){
            lettersContainer.addNewLetter(createLetter.inputChar(e.getKeyChar()));
            textField.repaint();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_LEFT){
            for(int i=0; i< lettersContainer.letters.size(); i++){
                if(lettersContainer.letters.get(i).isChekCaret() == true){
                    caret.setCoordinatX(lettersContainer.letters.get(i-1).getCoordinatX());
                    lettersContainer.letters.get(i).setChekCaret(false);
                    lettersContainer.letters.get(i-1).setChekCaret(true);
                }
            }
        }
        if(e.getKeyCode() == e.VK_RIGHT){
            for(int i=0; i< lettersContainer.letters.size(); i++){
                if(lettersContainer.letters.get(i).isChekCaret() == true){
                    caret.setCoordinatX(lettersContainer.letters.get(i+1).getCoordinatX());
                    lettersContainer.letters.get(i).setChekCaret(false);
                    lettersContainer.letters.get(i+1).setChekCaret(true);
                }
            }
        }
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
