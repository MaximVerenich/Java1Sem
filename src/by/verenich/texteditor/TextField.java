package by.verenich.texteditor;

import by.verenich.texteditor.controller.AllocationWithMouse;
import by.verenich.texteditor.controller.CursorControl;
import by.verenich.texteditor.controller.KeyListenerForTextField;
import by.verenich.texteditor.controller.MouseFocusForTextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
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
    private JScrollPane scrollPane;
    private JFrame textFrame;
    private Line line = new Line();

    TextField(LettersContainer lettersContainer, CreateLetter createLetter, Caret caret) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.WHITE);

        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
        this.caret = caret;
        caret.setTextField(this);
        CaretTimer caretTimer = new CaretTimer(this);

        allocation = new Allocation(this, lettersContainer, createLetter, caret);

        MouseFocusForTextField mouseFocusForTextField = new MouseFocusForTextField(this, caret, lettersContainer, line);

        this.addMouseListener(mouseFocusForTextField);

        this.addKeyListener(new KeyListenerForTextField(this, lettersContainer, createLetter, line, caret));

        this.addMouseListener(new AllocationWithMouse(allocation, lettersContainer, this));

        this.addMouseMotionListener(new CursorControl(this));

        this.setPreferredSize(new Dimension(681, 399));

        this.requestFocusInWindow();

    }

    public Caret getCaret() {
        return caret;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2D = (Graphics2D) g;
        int x = 10;
        int y = g2D.getFont().getSize() + 10;

        for (int i = 0; i < lettersContainer.getLetters().size(); i++) {
            if (lettersContainer.getLetters().get(i).isBoldface() == true && lettersContainer.getLetters().get(i).isCursive() == false) {
                g2D.setColor(lettersContainer.getLetters().get(i).getColor());
                g2D.setFont(new Font(lettersContainer.getLetters().get(i).getType(), Font.BOLD, lettersContainer.getLetters().get(i).getSize()));
            } else if (lettersContainer.getLetters().get(i).isBoldface() == false && lettersContainer.getLetters().get(i).isCursive() == true) {
                g2D.setColor(lettersContainer.getLetters().get(i).getColor());
                g2D.setFont(new Font(lettersContainer.getLetters().get(i).getType(), Font.ITALIC, lettersContainer.getLetters().get(i).getSize()));
            } else if (lettersContainer.getLetters().get(i).isBoldface() == true && lettersContainer.getLetters().get(i).isCursive() == true) {
                g2D.setColor(lettersContainer.getLetters().get(i).getColor());
                g2D.setFont(new Font(lettersContainer.getLetters().get(i).getType(), Font.BOLD + Font.ITALIC, lettersContainer.getLetters().get(i).getSize()));
            } else if (lettersContainer.getLetters().get(i).isBoldface() == false && lettersContainer.getLetters().get(i).isCursive() == false) {
                g2D.setColor(lettersContainer.getLetters().get(i).getColor());
                g2D.setFont(new Font(lettersContainer.getLetters().get(i).getType(), Font.PLAIN, lettersContainer.getLetters().get(i).getSize()));
            }

            lettersContainer.getLetters().get(i).setNumberOfLine(line.getNumberLine());
            lettersContainer.getLetters().get(i).setCoordinatX(x);
            lettersContainer.getLetters().get(i).setCoordinatY(y);

            if (lettersContainer.getLetters().get(i).getSize() > line.getMaxSize()) {
                line.setMaxSize(lettersContainer.getLetters().get(i).getSize());
                y += line.getMaxSize() - 15;
                lettersContainer.getLetters().get(i).setCoordinatY(y);
            }

            g2D.drawString(lettersContainer.getLetters().get(i).toString(), lettersContainer.getLetters().get(i).getCoordinatX(), lettersContainer.getLetters().get(i).getCoordinatY());
            if(i == caret.getPosition()){
                caret.setCoordinatX(lettersContainer.getLetters().get(i).getCoordinatX()+g2D.getFontMetrics().stringWidth(lettersContainer.getLetters().get(i).toString())+3);
                caret.setCoordinatY(lettersContainer.getLetters().get(i).getCoordinatY());
                caret.setSize(lettersContainer.getLetters().get(i).getSize());
            }
            x += g2D.getFontMetrics().stringWidth(lettersContainer.getLetters().get(i).toString())+3;

            if (x >= this.getPreferredSize().getWidth()) {
                int getPreferedSizeGetWidth = (int) this.getPreferredSize().getWidth();
                this.setPreferredSize(new Dimension(getPreferedSizeGetWidth + g2D.getFontMetrics().stringWidth(lettersContainer.getLetters().get(i).toString()) + 2, this.getHeight()));
                this.setSize(new Dimension(getPreferedSizeGetWidth + g2D.getFontMetrics().stringWidth(lettersContainer.getLetters().get(i).toString()) + 2, this.getHeight()));
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            }

            if (y >= this.getPreferredSize().getHeight()) {
                int getPreferedSizeGetHeight = (int) this.getPreferredSize().getHeight();
                this.setPreferredSize(new Dimension(this.getWidth(), getPreferedSizeGetHeight + g2D.getFont().getSize() + 3));
                this.setSize(new Dimension(this.getWidth(), getPreferedSizeGetHeight + g2D.getFont().getSize() + 3));
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            }

            if (lettersContainer.getLetters().get(i).getSymbol() == 10) {
                y += 12;
                x = 10;
                caret.setCoordinatX(x);
                caret.setCoordinatY(y);
                line.setMaxSize(12);
                line.setNumberLine(line.getNumberLine() + 1);
                line.lines = line.getNumberLine();
            }
        }
        line.setNumberLine(1);

    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setTextFrame(JFrame textFrame) {
        this.textFrame = textFrame;
    }

    public Allocation getAllocation() {
        return allocation;
    }
}
