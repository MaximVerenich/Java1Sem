package by.verenich.texteditor.xml;

import by.verenich.texteditor.Letter;
import by.verenich.texteditor.LettersContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class FileReader {
    private LettersContainer lettersContainer;
    private String xmlFilePath;

    public FileReader(String xmlFilePath, LettersContainer lettersContainer) {
        this.xmlFilePath = xmlFilePath;
        this.lettersContainer = lettersContainer;
        readFile();
    }

    private void readFile() {
        try {
            lettersContainer.getLetters().clear();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));

            NodeList letters = document.getElementsByTagName("letter");
            for (int letterIndex = 0; letterIndex < letters.getLength(); letterIndex++) {
                Element letterElement = (Element) letters.item(letterIndex);
                buildLetterObject(letterElement);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Letter buildLetterObject(Element letterElement) {
        Letter letter = new Letter();
        letter.setSymbol(letterElement.getAttribute("symbol").charAt(0));
        letter.setType(letterElement.getAttribute("type"));
        letter.setSize(Integer.parseInt(letterElement.getAttribute("size")));
        letter.setBoldface(Boolean.valueOf(letterElement.getAttribute("boldface")));
        letter.setCursive(Boolean.valueOf(letterElement.getAttribute("cursive")));
        lettersContainer.addNewLetter(letter);
        return letter;
    }
}


