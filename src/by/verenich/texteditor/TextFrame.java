package by.verenich.texteditor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextFrame {
    private JFrame textFrame;
    private JMenuBar menu;
    private JToolBar instruments;

    public TextFrame() {
        createMainJFrame();
        createMenu();
        createToolBar();
        createTextField();
        textFrame.setVisible(true);
    }

    private void createMainJFrame() {
        textFrame = new JFrame("Текстовый редактор");
        textFrame.setSize(700, 500);
        textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFrame.setLocationRelativeTo(null);
    }

    private void createMenu() {
        menu = new JMenuBar();
        menu.setBackground(Color.LIGHT_GRAY);

        createFileMenu();
        createCorrection();
        createInstrumentMenu();

        textFrame.setJMenuBar(menu);
    }

    private void createFileMenu() {
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem openMenu = new JMenuItem("Открыть");
        JMenuItem saveMenu = new JMenuItem("Сохранить");
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);

        menu.add(fileMenu);
    }

    private void createInstrumentMenu() {
        JMenu instrumentMenu = new JMenu("Инструменты");

        JMenu typeMenu = new JMenu("Шрифт");

        JMenuItem calibriMenu = new JMenuItem("Calibri");
        JMenuItem cambriaMenu = new JMenuItem("Cambria");
        JMenuItem georgiaMenu = new JMenuItem("Georgia");
        JMenuItem timesNewRomanMenu = new JMenuItem("Times New Roman");

        typeMenu.add(calibriMenu);
        typeMenu.add(cambriaMenu);
        typeMenu.add(georgiaMenu);
        typeMenu.add(timesNewRomanMenu);

        instrumentMenu.add(typeMenu);

        JMenu sizeMenu = new JMenu("Размер");

        JMenuItem size8Menu = new JMenuItem("8");
        JMenuItem size9Menu = new JMenuItem("9");
        JMenuItem size10Menu = new JMenuItem("10");
        JMenuItem size11Menu = new JMenuItem("11");
        JMenuItem size12Menu = new JMenuItem("12");
        JMenuItem size14Menu = new JMenuItem("14");
        JMenuItem size16Menu = new JMenuItem("16");

        sizeMenu.add(size8Menu);
        sizeMenu.add(size9Menu);
        sizeMenu.add(size10Menu);
        sizeMenu.add(size11Menu);
        sizeMenu.add(size12Menu);
        sizeMenu.add(size14Menu);
        sizeMenu.add(size16Menu);

        instrumentMenu.add(sizeMenu);

        JMenuItem boldfaceMenu = new JMenuItem("Жирный");
        JMenuItem cursiveMenu = new JMenuItem("Курсив");
        JMenuItem underlineMenu = new JMenuItem("Подчеркнутый");

        instrumentMenu.add(boldfaceMenu);
        instrumentMenu.add(cursiveMenu);
        instrumentMenu.add(underlineMenu);

        menu.add(instrumentMenu);
    }

    private void createCorrection() {
        JMenu correction = new JMenu("Правка");
        JMenuItem copyMenu = new JMenuItem("Копировать");
        JMenuItem insertMenu = new JMenuItem("Вставить");
        correction.add(copyMenu);
        correction.add(insertMenu);

        menu.add(correction);
    }

    private void createToolBar() {
        instruments = new JToolBar();
        instruments.setSize(700, 40);
        instruments.setBackground(Color.lightGray);

        addTextTypeToToolBar();
        addTextSizeToToolBar();
        addTextBoldfaceToToolBar();
        addTextCursiveToToolBar();
        addTextUnderlineToToolBar();
        addTextCopyToToolBar();
        addTextInsertToToolBar();
        addTextSaveToToolBar();
        addTextOpenToToolBar();

        textFrame.add(instruments, BorderLayout.NORTH);
    }

    private void addTextTypeToToolBar() {
        String[] types = {
                "Calibri",
                "Cambria",
                "Georgia",
                "Times New Roman"
        };
        JComboBox textType = new JComboBox(types);
        Dimension textTypeDimension = new Dimension(120, 40);
        textType.setMaximumSize(textTypeDimension);

        instruments.add(textType);
    }

    private void addTextSizeToToolBar() {
        String[] sizes = {
                "8",
                "9",
                "10",
                "11",
                "12",
                "14",
                "16"
        };
        JComboBox textSize = new JComboBox(sizes);
        textSize.setSize(40, 40);
        Dimension textSizeDimension = new Dimension(60, 40);
        textSize.setMaximumSize(textSizeDimension);
        instruments.add(textSize);
    }

    private void addTextBoldfaceToToolBar() {
        JButton textBoldface = new JButton(new ImageIcon("resources/images/Boldface.png"));
        textBoldface.setSize(20, 20);

        textBoldface.setToolTipText("Жирный");

        instruments.add(textBoldface);
    }

    private void addTextCursiveToToolBar() {
        JButton textCursive = new JButton(new ImageIcon("resources/images/Cursive.png"));
        textCursive.setSize(20, 20);

        textCursive.setToolTipText("Курсив");

        instruments.add(textCursive);
    }

    private void addTextUnderlineToToolBar() {
        JButton textUnderline = new JButton(new ImageIcon("resources/images/Underline.png"));
        textUnderline.setSize(20, 20);

        textUnderline.setToolTipText("Подчеркнутый");

        instruments.add(textUnderline);
    }

    private void addTextCopyToToolBar() {
        JButton textCopy = new JButton(new ImageIcon("resources/images/Copy.png"));
        textCopy.setSize(20, 20);

        textCopy.setToolTipText("Копировать");


        instruments.add(textCopy);
    }

    private void addTextInsertToToolBar() {
        JButton textInsert = new JButton(new ImageIcon("resources/images/Insert.png"));
        textInsert.setSize(20, 20);

        textInsert.setToolTipText("Вставить");

        instruments.add(textInsert);
    }

    private void addTextSaveToToolBar() {
        JButton textSave = new JButton(new ImageIcon("resources/images/Save.png"));
        textSave.setSize(20, 20);

        textSave.setToolTipText("Сохранить");

        instruments.add(textSave);
    }

    private void addTextOpenToToolBar() {
        JButton textOpen = new JButton(new ImageIcon("resources/images/Open.png"));
        textOpen.setSize(20, 20);

        textOpen.setToolTipText("Открыть");

        instruments.add(textOpen);
    }

    public void createTextField() {
        JPanel text = new JPanel();
        text.setSize(700, 420);
        text.setLayout(new FlowLayout(FlowLayout.LEFT)); //arrangemen
        textFrame.add(text);
        text.setBackground(Color.WHITE);
        text.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                text.requestFocusInWindow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
//      paintComponent()
//      переопределение и перегрузка
//      коллекции (ИНТЕРФЕЙСЫ List, Set)
//      анонимные классы
//      alt+insert
}


