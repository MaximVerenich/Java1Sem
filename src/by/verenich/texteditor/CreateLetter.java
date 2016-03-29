package by.verenich.texteditor;

public class CreateLetter {
    public Letter letter;
    public boolean boldface;
    public boolean cursive;
    public int size;
    public String type;

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
        letter.symbol = symbol;

        if(boldface == true){
            letter.boldface = 1;
        }
        else letter.boldface = 0;

        if(cursive == true){
            letter.cursive = 1;
        }
        else letter.cursive = 0;

        letter.size = size;

        letter.type = type;

        return letter;
    }
}
