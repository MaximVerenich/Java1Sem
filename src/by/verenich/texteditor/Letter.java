package by.verenich.texteditor;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    public char symbol;
    public int boldface;
    public int cursive;
    public int size;
    public String type;
    public int coordinatX;
    public int coordinatY;

    @Override
    public String toString() {
        return "" + symbol; //приведение типов для конкотинации
    }

}
