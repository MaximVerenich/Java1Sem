package by.verenich.texteditor;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class LetterView {
    private boolean boldface;
    private boolean cursive;
    private boolean underline;
    public char letter;

    @Override
    public String toString(){
        return "" + letter; //приведение типов для конкотинации
    }
}
