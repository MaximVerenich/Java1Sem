package by.verenich.texteditor;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private char symbol;
    private int boldface;
    private int cursive;
    private int size;
    private String type;
    private int coordinatX;
    private int coordinatY;
    private int numberOfLine;
    private boolean chekCaret;

    @Override
    public String toString() {
        return "" + symbol; //приведение типов для конкотинации
    }

    public char getSymbol() {
        return symbol;
    }

    public int getBoldface() {
        return boldface;
    }

    public int getCursive() {
        return cursive;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public int getCoordinatY() {
        return coordinatY;
    }

    public int getCoordinatX() {
        return coordinatX;
    }

    public int getNumberOfLine() {
        return numberOfLine;
    }

    public boolean isChekCaret() {
        return chekCaret;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setBoldface(int boldface) {
        this.boldface = boldface;
    }

    public void setCursive(int cursive) {
        this.cursive = cursive;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinatX(int coordinatX) {
        this.coordinatX = coordinatX;
    }

    public void setCoordinatY(int coordinatY) {
        this.coordinatY = coordinatY;
    }

    public void setNumberOfLine(int numberOfLine) {
        this.numberOfLine = numberOfLine;
    }

    public void setChekCaret(boolean chekCaret) {
        this.chekCaret = chekCaret;
    }
}
