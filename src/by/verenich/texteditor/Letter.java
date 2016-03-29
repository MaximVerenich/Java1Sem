package by.verenich.texteditor;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    public char symbol;
    public int boldface;
    public int cursive;
    public int size;
    public String type;
    private boolean underline;

    @Override
    public String toString() {
        return "" + symbol; //приведение типов для конкотинации
    }

}
