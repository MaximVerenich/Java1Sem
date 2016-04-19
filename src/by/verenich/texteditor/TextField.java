package by.verenich.texteditor;

import by.verenich.texteditor.controller.AllocationWithMouse;
import by.verenich.texteditor.controller.KeyListenerForTextField;
import by.verenich.texteditor.controller.MouseFocusForTextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TextField extends JPanel {

    private LettersContainer lettersContainer;
    private CreateLetter createLetter;
    private Allocation allocation;
    private Caret caret;
    public JScrollPane scrollPane;
    public JFrame textFrame;

    TextField(LettersContainer lettersContainer, CreateLetter createLetter, Caret caret) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.WHITE);

        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
        this.caret = caret;
        caret.setTextField(this);
        CaretTimer caretTimer = new CaretTimer(this);

        allocation = new Allocation(this, lettersContainer, createLetter);

        MouseFocusForTextField mouseFocusForTextField = new MouseFocusForTextField(this,caret);

        this.addMouseListener(mouseFocusForTextField);

        this.addKeyListener(new KeyListenerForTextField(this, lettersContainer, createLetter));

        this.addMouseListener(new AllocationWithMouse(allocation));

        this.setPreferredSize(new Dimension(681, 399));

        this.requestFocusInWindow();

    }

    public Caret getCaret() {
        return caret;
    }

    public int returnHeight(){
        return this.getHeight();
    }

    public int returnWidth(){
        return this.getWidth();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2D = (Graphics2D) g;
        caret.setCoordinatX(10);
        caret.setCoordinatY(g2D.getFont().getSize() + 10);
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
            L.coordinatX = caret.getCoordinatX();
            L.coordinatY = caret.getCoordinatY();
            g2D.drawString(L.toString(), caret.getCoordinatX(), caret.getCoordinatY());
            caret.setSize(L.size);
            caret.setCoordinatX(caret.getCoordinatX()+g2D.getFontMetrics().stringWidth(L.toString())+2);
            caret.setCoordinatY(caret.getCoordinatY());
            if(caret.getCoordinatX() >= this.getPreferredSize().getWidth()){
                int getPreferedSizeGetWidth = (int) this.getPreferredSize().getWidth();
                this.setPreferredSize(new Dimension(getPreferedSizeGetWidth + g2D.getFontMetrics().stringWidth(L.toString())+2, this.getHeight()));
                this.setSize(new Dimension(getPreferedSizeGetWidth + g2D.getFontMetrics().stringWidth(L.toString())+2, this.getHeight()));
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            }
            if ( L.symbol == 10) {
                caret.setCoordinatY(caret.getCoordinatY()+g2D.getFont().getSize() + 3);
                caret.setCoordinatX(10);
            }

            if (caret.getCoordinatY() >= this.getPreferredSize().getHeight()){
                int getPreferedSizeGetHeight = (int) this.getPreferredSize().getHeight();
                this.setPreferredSize(new Dimension(this.getWidth(), getPreferedSizeGetHeight + g2D.getFont().getSize() + 3));
                this.setSize(new Dimension(this.getWidth(), getPreferedSizeGetHeight + g2D.getFont().getSize() + 3));
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            }
        }
    }
}
