package by.verenich.texteditor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TextFrame {
    private JFrame textFrame;
    private JMenuBar menu;
    private JToolBar instruments;
    private LettersContainer lettersContainer = new LettersContainer();
    private CreateLetter createLetter = new CreateLetter();
    private TextField textField = new TextField(lettersContainer, createLetter);

    public TextFrame() {
        createMainJFrame();
        createMenu();
        createToolBar();
        textFrame.add(textField);
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
        //addTextUnderlineToToolBar();
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
        textType.setBackground(Color.white);
        Dimension textTypeDimension = new Dimension(120, 40);
        textType.setMaximumSize(textTypeDimension);

        textType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    createLetter.type = e.getItem().toString();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        instruments.add(textType);
    }

    private void addTextSizeToToolBar() {
        String[] sizes = {
                "12",
                "14",
                "16",
                "18",
                "20",
                "24"
        };
        JComboBox textSize = new JComboBox(sizes);
        textSize.setBackground(Color.white);
        textSize.setSize(40, 40);
        Dimension textSizeDimension = new Dimension(60, 40);
        textSize.setMaximumSize(textSizeDimension);
        textSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    createLetter.size = Integer.parseInt("" + e.getItem());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        instruments.add(textSize);
    }

    private void addTextBoldfaceToToolBar() {
        JButton textBoldface = new JButton(new ImageIcon("resources/images/Boldface.png"));
        textBoldface.setSize(20, 20);

        textBoldface.setToolTipText("Жирный");

        textBoldface.setBackground(Color.white);

        textBoldface.addActionListener(new ActionListener() {
            int checked = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checked == 0) {
                    createLetter.checkedBoldface(true);
                    checked = 1;
                    textBoldface.setBackground(Color.decode("#b6e1fc"));
                } else {
                    createLetter.checkedBoldface(false);
                    checked = 0;
                    textBoldface.setBackground(Color.WHITE);
                }
            }
        });

        instruments.add(textBoldface);
    }

    private void addTextCursiveToToolBar() {
        JButton textCursive = new JButton(new ImageIcon("resources/images/Cursive.png"));
        textCursive.setSize(20, 20);

        textCursive.setToolTipText("Курсив");

        textCursive.setBackground(Color.white);

        textCursive.addActionListener(new ActionListener() {
            int checked = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checked == 0) {
                    createLetter.checkedCursive(true);
                    checked = 1;
                    textCursive.setBackground(Color.decode("#b6e1fc"));
                } else {
                    createLetter.checkedCursive(false);
                    checked = 0;
                    textCursive.setBackground(Color.WHITE);
                }
            }
        });

        instruments.add(textCursive);
    }

    private void addTextUnderlineToToolBar() {
        JButton textUnderline = new JButton(new ImageIcon("resources/images/Underline.png"));
        textUnderline.setSize(20, 20);

        textUnderline.setToolTipText("Подчеркнутый");

        textUnderline.setBackground(Color.white);

        instruments.add(textUnderline);
    }

    private void addTextCopyToToolBar() {
        JButton textCopy = new JButton(new ImageIcon("resources/images/Copy.png"));
        textCopy.setSize(20, 20);

        textCopy.setToolTipText("Копировать");

        textCopy.setBackground(Color.white);

        instruments.add(textCopy);
    }

    private void addTextInsertToToolBar() {
        JButton textInsert = new JButton(new ImageIcon("resources/images/Insert.png"));
        textInsert.setSize(20, 20);

        textInsert.setToolTipText("Вставить");

        textInsert.setBackground(Color.white);

        instruments.add(textInsert);
    }

    private void addTextSaveToToolBar() {
        JButton textSave = new JButton(new ImageIcon("resources/images/Save.png"));
        textSave.setSize(20, 20);

        textSave.setToolTipText("Сохранить");

        textSave.setBackground(Color.white);

        instruments.add(textSave);
    }

    private void addTextOpenToToolBar() {
        JButton textOpen = new JButton(new ImageIcon("resources/images/Open.png"));
        textOpen.setSize(20, 20);

        textOpen.setToolTipText("Открыть");

        textOpen.setBackground(Color.white);

        instruments.add(textOpen);
    }

}



