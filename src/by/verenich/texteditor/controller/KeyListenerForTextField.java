package by.verenich.texteditor.controller;

import by.verenich.texteditor.LetterView;
import by.verenich.texteditor.storage.LettersContainer;

import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * Created by 1o on 08.03.2016.
 */
public class KeyListenerForTextField extends KeyAdapter {

    private LettersContainer lettersContainer;
    private JPanel text;

    public KeyListenerForTextField(LettersContainer lettersContainer1, JPanel text){
        this.lettersContainer = lettersContainer1;
        this.text = text;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        LetterView symbol = new LetterView();
        symbol.letter = e.getKeyChar();
        lettersContainer.addNewLetter(symbol);
        text.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
