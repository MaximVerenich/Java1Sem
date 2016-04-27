package by.verenich.texteditor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Letter {
    private char symbol;
    private boolean boldface;
    private boolean cursive;
    private int size;
    private String type;
    private int coordinatX;
    private int coordinatY;
    private int numberOfLine;
    private Color color;

    @Override
    public String toString() {
        return "" + symbol; //приведение типов для конкотинации
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isBoldface() {
        return boldface;
    }

    public boolean isCursive() {
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

    public Color getColor() {
        return color;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setBoldface(boolean boldface) {
        this.boldface = boldface;
    }

    public void setCursive(boolean cursive) {
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

    public void setColor(Color color) {
        this.color = color;
    }
}
