package by.verenich.texteditor;

import java.awt.Color;

public class Allocation {

    private TextField textField;
    private LettersContainer lettersContainer;
    private CreateLetter createLetter;
    private int firstClickX;
    private int firstClickY;
    private int secondClickX;
    private int secondClickY;
    private LettersContainer dopLettersContainer;
    private Caret caret;

    public Allocation(TextField textField, LettersContainer lettersContainer, CreateLetter createLetter, Caret caret) {
        this.textField = textField;
        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
        this.caret = caret;
    }

    public void copyText() {
        LettersContainer dopLettersContainer = new LettersContainer();
        this.dopLettersContainer = dopLettersContainer;
        for (int i = 0; i<lettersContainer.getLetters().size(); i++){
            if(lettersContainer.getLetters().get(i).getCoordinatX() >= firstClickX && lettersContainer.getLetters().get(i).getCoordinatX() <= secondClickX){
                if(lettersContainer.getLetters().get(i).getCoordinatY() >= firstClickY && lettersContainer.getLetters().get(i).getCoordinatY() <= secondClickY){
                    dopLettersContainer.addNewLetter(lettersContainer.getLetters().get(i));
                    lettersContainer.getLetters().get(i).setColor(Color.BLACK);
                }
            }
        }
        textField.requestFocus();
    }

    public void pasteText() {
        for(int i = 0; i<dopLettersContainer.getLetters().size(); i++){
            lettersContainer.addNewLetter(dopLettersContainer.getLetters().get(i));
        }
        caret.setPosition(caret.getPosition()+dopLettersContainer.getLetters().size());
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
