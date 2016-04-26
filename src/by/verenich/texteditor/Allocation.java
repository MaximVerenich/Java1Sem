package by.verenich.texteditor;

public class Allocation {

    private TextField textField;
    private LettersContainer lettersContainer;
    private CreateLetter createLetter;
    private int firstClickX;
    private int firstClickY;
    private int secondClickX;
    private int secondClickY;
    private boolean copy;
    private LettersContainer dopLettersContainer;
    public Allocation(TextField textField, LettersContainer lettersContainer, CreateLetter createLetter) {
        this.textField = textField;
        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
    }

    public void copyText() {
        LettersContainer dopLettersContainer = new LettersContainer();
        this.dopLettersContainer = dopLettersContainer;
        for (int i = 0; i<lettersContainer.letters.size(); i++){
            if(lettersContainer.letters.get(i).getCoordinatX() >= firstClickX && lettersContainer.letters.get(i).getCoordinatX() <= secondClickX){
                if(lettersContainer.letters.get(i).getCoordinatY() >= firstClickY && lettersContainer.letters.get(i).getCoordinatY() <= secondClickY){
                    dopLettersContainer.addNewLetter(lettersContainer.letters.get(i));
                }
            }
        }
    }

    public void pasteText() {
        for(int i = 0; i<dopLettersContainer.letters.size(); i++){
            lettersContainer.addNewLetter(dopLettersContainer.letters.get(i));
        }
        textField.repaint();
        textField.requestFocus();
    }

    public int getFirstClickX() {
        return firstClickX;
    }

    public void setFirstClickX(int firstClickX) {
        this.firstClickX = firstClickX;
    }

    public int getFirstClickY() {
        return firstClickY;
    }

    public void setFirstClickY(int firstClickY) {
        this.firstClickY = firstClickY;
    }

    public int getSecondClickX() {
        return secondClickX;
    }

    public void setSecondClickX(int secondClickX) {
        this.secondClickX = secondClickX;
    }

    public int getSecondClickY() {
        return secondClickY;
    }

    public void setSecondClickY(int secondClickY) {
        this.secondClickY = secondClickY;
    }

}
