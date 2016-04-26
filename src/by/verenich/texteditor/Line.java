package by.verenich.texteditor;

public class Line {
    private int maxSize;
    private int numberLine;
    public int lines;

    public Line() {
        maxSize = 12;
        numberLine = 1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getNumberLine() {
        return numberLine;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }
}
