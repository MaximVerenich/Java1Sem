package by.verenich.texteditor;

import by.verenich.texteditor.controller.KeyListenerForTextField;
import by.verenich.texteditor.controller.MouseFocusForTextField;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TextField extends JPanel {

    private LettersContainer lettersContainer;
    private CreateLetter createLetter;

    TextField(LettersContainer lettersContainer, CreateLetter createLetter) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.setBackground(Color.WHITE);

        this.lettersContainer = lettersContainer;

        this.createLetter = createLetter;

        this.addMouseListener(new MouseFocusForTextField(this));

        this.addKeyListener(new KeyListenerForTextField(this, lettersContainer, createLetter));

    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2D = (Graphics2D) g;
        int x = 5;
        int y = g2D.getFont().getSize()+10;

        for (Letter L : lettersContainer.letters) {
            if (L.boldface == 1 && L.cursive == 0) {
                g2D.setFont(new Font(L.type, Font.BOLD, L.size));
            } else if (L.boldface == 0 && L.cursive == 1) {
                g2D.setFont(new Font(L.type, Font.ITALIC, L.size));
            } else if (L.boldface == 1 && L.cursive == 1) {
                g2D.setFont(new Font(L.type, Font.BOLD + Font.ITALIC, L.size));
            } else if (L.boldface == 0 && L.cursive == 0) {
                g2D.setFont(new Font(L.type, Font.PLAIN, L.size));
            }
            g2D.drawString(L.toString(), x, y);
            x += g2D.getFontMetrics().stringWidth(L.toString());
            if (x > this.getWidth() - 10) {
                y += g2D.getFont().getSize();
                x = 5;
            }
        }
    }
}
