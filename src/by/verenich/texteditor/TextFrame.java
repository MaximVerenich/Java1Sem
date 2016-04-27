package by.verenich.texteditor;

import by.verenich.texteditor.xml.FileReader;
import by.verenich.texteditor.xml.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class TextFrame {
    private JFrame textFrame;
    private JMenuBar menu;
    private JToolBar instruments;
    private LettersContainer lettersContainer = new LettersContainer();
    private CreateLetter createLetter = new CreateLetter();
    private Caret caret = new Caret();
    private JScrollPane scrollPane;
    private TextField textField = new TextField(lettersContainer, createLetter, caret);
    private JButton textBoldface;
    private JButton textCursive;

    public TextFrame() {
        createMainJFrame();
        createMenu();
        createToolBar();
        scrollPane = new JScrollPane(textField);
        textField.setScrollPane(scrollPane);
        textFrame.add(scrollPane, BorderLayout.CENTER);
        textFrame.setVisible(true);
        textField.requestFocus();
    }

    private void createMainJFrame() {
        textFrame = new JFrame("Текстовый редактор");
        textFrame.setSize(700, 500);
        textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFrame.setLocationRelativeTo(null);
        textField.setTextFrame(textFrame);
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
        calibriMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setType("Calibri");
            }
        });
        JMenuItem cambriaMenu = new JMenuItem("Cambria");
        cambriaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setType("Cambria");
            }
        });
        JMenuItem georgiaMenu = new JMenuItem("Georgia");
        georgiaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setType("Georgia");
            }
        });
        JMenuItem timesNewRomanMenu = new JMenuItem("Times New Roman");
        timesNewRomanMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setType("Times New Roman");
            }
        });

        typeMenu.add(calibriMenu);
        typeMenu.add(cambriaMenu);
        typeMenu.add(georgiaMenu);
        typeMenu.add(timesNewRomanMenu);

        instrumentMenu.add(typeMenu);

        JMenu sizeMenu = new JMenu("Размер");

        JMenuItem size12Menu = new JMenuItem("12");
        size12Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setSize(12);
            }
        });
        JMenuItem size14Menu = new JMenuItem("14");
        size14Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setSize(14);
            }
        });
        JMenuItem size16Menu = new JMenuItem("16");
        size16Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setSize(16);
            }
        });
        JMenuItem size18Menu = new JMenuItem("18");
        size18Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setSize(18);
            }
        });
        JMenuItem size20Menu = new JMenuItem("20");
        size20Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setSize(20);
            }
        });
        JMenuItem size24Menu = new JMenuItem("24");
        size24Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLetter.setSize(24);
            }
        });

        sizeMenu.add(size12Menu);
        sizeMenu.add(size14Menu);
        sizeMenu.add(size16Menu);
        sizeMenu.add(size18Menu);
        sizeMenu.add(size20Menu);
        sizeMenu.add(size24Menu);

        instrumentMenu.add(sizeMenu);

        JMenuItem boldfaceMenu = new JMenuItem("Жирный");
        boldfaceMenu.addActionListener(new ActionListener() {
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
                textField.requestFocusInWindow();
            }
        });
        JMenuItem cursiveMenu = new JMenuItem("Курсив");
        cursiveMenu.addActionListener(new ActionListener() {
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
                textField.requestFocusInWindow();
            }
        });

        instrumentMenu.add(boldfaceMenu);
        instrumentMenu.add(cursiveMenu);

        menu.add(instrumentMenu);
    }

    private void createCorrection() {
        JMenu correction = new JMenu("Правка");
        JMenuItem copyMenu = new JMenuItem("Копировать");
        copyMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.getAllocation().copyText();
            }
        });
        JMenuItem insertMenu = new JMenuItem("Вставить");
        insertMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.getAllocation().pasteText();
            }
        });
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
                    createLetter.setType(e.getItem().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                textField.requestFocus();
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
                    createLetter.setSize(Integer.parseInt("" + e.getItem()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                textField.requestFocusInWindow();
            }
        });
        instruments.add(textSize);
    }

    private void addTextBoldfaceToToolBar() {
        textBoldface = new JButton(new ImageIcon("resources/images/Boldface.png"));
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
                textField.requestFocus();
            }
        });

        instruments.add(textBoldface);
    }

    private void addTextCursiveToToolBar() {
        textCursive = new JButton(new ImageIcon("resources/images/Cursive.png"));
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
                textField.requestFocusInWindow();
            }
        });

        instruments.add(textCursive);
    }

    private void addTextCopyToToolBar() {
        JButton textCopy = new JButton(new ImageIcon("resources/images/Copy.png"));
        textCopy.setSize(20, 20);

        textCopy.setToolTipText("Копировать");

        textCopy.setBackground(Color.white);

        instruments.add(textCopy);

        textCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.getAllocation().copyText();
            }
        });
    }

    private void addTextInsertToToolBar() {
        JButton textInsert = new JButton(new ImageIcon("resources/images/Insert.png"));
        textInsert.setSize(20, 20);

        textInsert.setToolTipText("Вставить");

        textInsert.setBackground(Color.white);

        instruments.add(textInsert);

        textInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.getAllocation().pasteText();
            }
        });
    }

    private void addTextSaveToToolBar() {
        JButton textSave = new JButton(new ImageIcon("resources/images/Save.png"));
        textSave.setSize(20, 20);

        textSave.setToolTipText("Сохранить");

        textSave.setBackground(Color.white);

        textSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        instruments.add(textSave);
    }

    private void addTextOpenToToolBar() {
        JButton textOpen = new JButton(new ImageIcon("resources/images/Open.png"));
        textOpen.setSize(20, 20);

        textOpen.setToolTipText("Открыть");

        textOpen.setBackground(Color.white);

        textOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        instruments.add(textOpen);
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\1o\\Desktop"));
        int result = fileChooser.showDialog(null, "xml");
        if (result == JFileChooser.APPROVE_OPTION) {
            new FileWriter(fileChooser.getSelectedFile().getPath(), lettersContainer);
        }
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\1o\\Desktop"));
        int result = fileChooser.showDialog(null, "open");
        if (result == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().getName().contains(".xml")) {
                new FileReader(fileChooser.getSelectedFile().getPath(), lettersContainer);
            }
        }
        textField.repaint();
        textField.requestFocus();
        caret.setPosition(lettersContainer.getLetters().size()-1);
    }

}






