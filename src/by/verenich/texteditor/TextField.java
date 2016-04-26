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

        allocation = new Allocation(this, lettersContainer, createLetter);

        MouseFocusForTextField mouseFocusForTextField = new MouseFocusForTextField(this, caret);

        this.addMouseListener(mouseFocusForTextField);

        this.addKeyListener(new KeyListenerForTextField(this, lettersContainer, createLetter, line, caret));

        this.addMouseListener(new AllocationWithMouse(allocation));

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
        caret.setCoordinatX(10);
        caret.setCoordinatY(g2D.getFont().getSize() + 10);

        for (Letter letter : lettersContainer.letters) {
            if (letter.getBoldface() == 1 && letter.getCursive() == 0) {
                g2D.setFont(new Font(letter.getType(), Font.BOLD, letter.getSize()));
            } else if (letter.getBoldface() == 0 && letter.getCursive() == 1) {
                g2D.setFont(new Font(letter.getType(), Font.ITALIC, letter.getSize()));
            } else if (letter.getBoldface() == 1 && letter.getCursive() == 1) {
                g2D.setFont(new Font(letter.getType(), Font.BOLD + Font.ITALIC, letter.getSize()));
            } else if (letter.getBoldface() == 0 && letter.getCursive() == 0) {
                g2D.setFont(new Font(letter.getType(), Font.PLAIN, letter.getSize()));
            }

            letter.setNumberOfLine(line.getNumberLine());
            letter.setCoordinatX(caret.getCoordinatX());
            letter.setCoordinatY(caret.getCoordinatY());

            if (letter.getSize() > line.getMaxSize()) {
                line.setMaxSize(letter.getSize());
                caret.setCoordinatY(caret.getCoordinatY() + line.getMaxSize() - 15);
                letter.setCoordinatY(caret.getCoordinatY());
            }

            g2D.drawString(letter.toString(), letter.getCoordinatX(), letter.getCoordinatY());
            caret.setSize(letter.getSize());
            caret.setCoordinatX(caret.getCoordinatX() + g2D.getFontMetrics().stringWidth(letter.toString()) + 2);

            if (caret.getCoordinatX() >= this.getPreferredSize().getWidth()) {
                int getPreferedSizeGetWidth = (int) this.getPreferredSize().getWidth();
                this.setPreferredSize(new Dimension(getPreferedSizeGetWidth + g2D.getFontMetrics().stringWidth(letter.toString()) + 2, this.getHeight()));
                this.setSize(new Dimension(getPreferedSizeGetWidth + g2D.getFontMetrics().stringWidth(letter.toString()) + 2, this.getHeight()));
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            }

            if (caret.getCoordinatY() >= this.getPreferredSize().getHeight()) {
                int getPreferedSizeGetHeight = (int) this.getPreferredSize().getHeight();
                this.setPreferredSize(new Dimension(this.getWidth(), getPreferedSizeGetHeight + g2D.getFont().getSize() + 3));
                this.setSize(new Dimension(this.getWidth(), getPreferedSizeGetHeight + g2D.getFont().getSize() + 3));
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            }

            if (letter.getSymbol() == 10) {
                caret.setCoordinatY(caret.getCoordinatY() + 12);
                caret.setCoordinatX(10);
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
