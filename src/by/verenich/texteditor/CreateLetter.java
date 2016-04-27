package by.verenich.texteditor;

import java.awt.Color;

public class CreateLetter {
    private Letter letter;
    private boolean boldface;
    private boolean cursive;
    private int size;
    private String type;

    public CreateLetter(){
        size = 12;
        type = "Georgia";
    }

    public void checkedBoldface(boolean checked){
        if(checked == true){
            this.boldface = true;
        }
        else this.boldface = false;
    }

    public void checkedCursive(boolean checked){
        if(checked == true){
            this.cursive = true;
        }
        else this.cursive = false;
    }

    public Letter inputChar(char symbol){
        letter = new Letter();
        letter.setColor(Color.BLACK);
        letter.setSymbol(symbol);

        if(boldface == true){
            letter.setBoldface(true);
        }
        else letter.setBoldface(false);

        if(cursive == true){
            letter.setCursive(true);
        }
        else letter.setCursive(false);

        letter.setSize(size);

        letter.setType(type);

        return letter;
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

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

}
