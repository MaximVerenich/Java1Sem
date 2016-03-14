package by.verenich.texteditor.storage;

import by.verenich.texteditor.LetterView;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class LettersContainer {
    public List<LetterView> letterViews = new ArrayList<>();

    public void addNewLetter(LetterView letterView) {
        letterViews.add(letterView);
    }


}