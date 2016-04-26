package by.verenich.texteditor;

public class CreateLetter {
    private Letter letter;
    private boolean boldface;
    private boolean cursive;
    private int size;
    private String type;

    public CreateLetter(){
        size = 12;
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
        letter.setSymbol(symbol);

        if(boldface == true){
            letter.setBoldface(1);
        }
        else letter.setBoldface(0);

        if(cursive == true){
            letter.setCursive(1);
        }
        else letter.setCursive(0);

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
