package by.verenich.texteditor;


import java.util.ArrayList;
import java.util.List;

public class LettersContainer {

    public List<Letter> letters = new ArrayList<>();

    public void addNewLetter(Letter letter) {
        letters.add(letter);
    }
}
