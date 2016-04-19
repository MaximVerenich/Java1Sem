package by.verenich.texteditor;

public class Allocation {

    public TextField textField;
    private LettersContainer lettersContainer;
    private CreateLetter createLetter;

    public Allocation(TextField textField, LettersContainer lettersContainer, CreateLetter createLetter) {
        this.textField = textField;
        this.lettersContainer = lettersContainer;
        this.createLetter = createLetter;
    }

    public void allocation(int firstClickX, int firstClickY, int secondClickX, int secondClickY) {
        for (int i = 0; i < lettersContainer.letters.size(); i++) {
            if (lettersContainer.letters.get(i).coordinatX >= firstClickX && lettersContainer.letters.get(i).coordinatX <= secondClickX) {
                if (lettersContainer.letters.get(i).coordinatY >= firstClickY && lettersContainer.letters.get(i).coordinatY <= secondClickY) {
                if (createLetter.boldface == true)
                    lettersContainer.letters.get(i).boldface = 1;
                else lettersContainer.letters.get(i).boldface = 0;

                if (createLetter.cursive == true)
                    lettersContainer.letters.get(i).cursive = 1;
                else lettersContainer.letters.get(i).cursive = 0;
                lettersContainer.letters.get(i).size = createLetter.size;
                lettersContainer.letters.get(i).type = createLetter.type;
            }
            }
        }
        textField.repaint();
    }

}
