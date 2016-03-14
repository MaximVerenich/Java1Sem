package by.verenich.texteditor;

import by.verenich.texteditor.controller.KeyListenerForTextField;
import by.verenich.texteditor.controller.MouseFocusForTextField;
import by.verenich.texteditor.storage.LettersContainer;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Created by 1o on 15.03.2016.
 */
public class TextField extends JPanel {

    private LettersContainer lettersContainer;

    TextField() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT)); //arrangemen

        lettersContainer = new LettersContainer();

        this.setBackground(Color.WHITE);

        this.addMouseListener(new MouseFocusForTextField(this));

        this.addKeyListener(new KeyListenerForTextField(lettersContainer, this));
    }

    @Override
    public void paintComponent(Graphics g){
        g.clearRect(0,0, this.getWidth(), this.getHeight());
        Graphics2D g2D = (Graphics2D)g;
        int x = 1;
        int y = g2D.getFont().getSize();
        for(LetterView L: lettersContainer.letterViews){
            g2D.drawString(L.toString(), x, y);
            x += g2D.getFontMetrics().stringWidth(L.toString());
            if (x > this.getWidth()){
                y += g2D.getFont().getSize();
                x = 1;
            }
        }
    }
}
