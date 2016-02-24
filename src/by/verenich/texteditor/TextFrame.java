package by.verenich.texteditor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class TextFrame {

    public TextFrame() {
        JFrame textFrame = new JFrame("Текстовый редактор");
        textFrame.setSize(700, 500);
        textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFrame.setLocationRelativeTo(null);

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.LIGHT_GRAY);
        textFrame.setJMenuBar(menu);

        JMenu fileMenu = new JMenu("Файл");
        JMenu instrumentMenu = new JMenu("Инструменты");
        JMenu correction = new JMenu("Правка");

        JMenuItem openMenu = new JMenuItem("Открыть");
        JMenuItem saveMenu = new JMenuItem("Сохранить");

        JMenu typeMenu = new JMenu("Шрифт");
        JMenu sizeMenu = new JMenu("Размер");
        JMenuItem boldfaceMenu = new JMenuItem("Жирный");
        JMenuItem cursiveMenu = new JMenuItem("Курсив");
        JMenuItem underlineMenu = new JMenuItem("Подчеркнутый");
        JMenuItem copyMenu = new JMenuItem("Копировать");
        JMenuItem insertMenu = new JMenuItem("Вставить");

        JMenuItem calibriMenu = new JMenuItem("Calibri");
        JMenuItem cambriaMenu = new JMenuItem("Cambria");
        JMenuItem georgiaMenu = new JMenuItem("Georgia");
        JMenuItem timesNewRomanMenu = new JMenuItem("Times New Roman");

        JMenuItem size8Menu = new JMenuItem("8");
        JMenuItem size9Menu = new JMenuItem("9");
        JMenuItem size10Menu = new JMenuItem("10");
        JMenuItem size11Menu = new JMenuItem("11");
        JMenuItem size12Menu = new JMenuItem("12");
        JMenuItem size14Menu = new JMenuItem("14");
        JMenuItem size16Menu = new JMenuItem("16");

        typeMenu.add(calibriMenu);
        typeMenu.add(cambriaMenu);
        typeMenu.add(georgiaMenu);
        typeMenu.add(timesNewRomanMenu);

        sizeMenu.add(size8Menu);
        sizeMenu.add(size9Menu);
        sizeMenu.add(size10Menu);
        sizeMenu.add(size11Menu);
        sizeMenu.add(size12Menu);
        sizeMenu.add(size14Menu);
        sizeMenu.add(size16Menu);

        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);

        instrumentMenu.add(typeMenu);
        instrumentMenu.add(sizeMenu);
        instrumentMenu.add(boldfaceMenu);
        instrumentMenu.add(cursiveMenu);
        instrumentMenu.add(underlineMenu);

        correction.add(copyMenu);
        correction.add(insertMenu);

        menu.add(fileMenu);
        menu.add(correction);
        menu.add(instrumentMenu);

        JToolBar instruments = new JToolBar();
        instruments.setSize(700, 40);
        instruments.setBackground(Color.lightGray);

        JTextArea text = new JTextArea();
        text.setSize(700, 420);
        text.setLayout(new FlowLayout(FlowLayout.LEFT)); //arrangement
        text.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setHorizontalScrollBar(null);

        textFrame.add(instruments, BorderLayout.NORTH);
        textFrame.add(scrollPane, BorderLayout.CENTER);

        String[] types = {
                "Calibri",
                "Cambria",
                "Georgia",
                "Times New Roman"
        };
        JComboBox textType = new JComboBox(types);
        Dimension textTypeDimension = new Dimension(120, 40);
        textType.setMaximumSize(textTypeDimension);

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

        JButton textBoldface = new JButton(new ImageIcon("resources/images/Boldface.png"));
        textBoldface.setSize(20, 20);
        textBoldface.setVisible(true);

        JButton textCursive = new JButton(new ImageIcon("resources/images/Cursive.png"));
        textCursive.setSize(20, 20);
        textCursive.setVisible(true);

        JButton textUnderline = new JButton(new ImageIcon("resources/images/Underline.png"));
        textUnderline.setSize(20, 20);
        textUnderline.setVisible(true);

        JButton textCopy = new JButton(new ImageIcon("resources/images/Copy.png"));
        textCopy.setSize(20, 20);
        textCopy.setVisible(true);

        JButton textInsert = new JButton(new ImageIcon("resources/images/Insert.png"));
        textInsert.setSize(20, 20);
        textInsert.setVisible(true);

        JButton textSave = new JButton(new ImageIcon("resources/images/Save.png"));
        textSave.setSize(20, 20);
        textSave.setVisible(true);

        JButton textOpen = new JButton(new ImageIcon("resources/images/Open.png"));
        textOpen.setSize(20, 20);
        textOpen.setVisible(true);

        instruments.add(textType);
        instruments.add(textSize);
        instruments.add(textBoldface);
        instruments.add(textCursive);
        instruments.add(textUnderline);
        instruments.add(textCopy);
        instruments.add(textInsert);
        instruments.add(textSave);
        instruments.add(textOpen);

        textFrame.setVisible(true);
    }
}


