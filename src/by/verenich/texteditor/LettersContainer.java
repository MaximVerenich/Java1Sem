package by.verenich.texteditor;


import java.util.ArrayList;
import java.util.List;

public class LettersContainer {

    private List<Letter> letters = new ArrayList<>();

    public void addNewLetter(Letter letter) {
        letters.add(letter);
    }

    public List<Letter> getLetters() {
        return letters;
    }
}
