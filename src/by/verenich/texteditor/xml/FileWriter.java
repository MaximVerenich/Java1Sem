package by.verenich.texteditor.xml;

import by.verenich.texteditor.Letter;
import by.verenich.texteditor.LettersContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class FileWriter {
    private LettersContainer lettersContainer;
    private String fileName;

    public FileWriter(String fileName, LettersContainer lettersContainer) {
        this.fileName = fileName;
        this.lettersContainer = lettersContainer;
        writeFile();
    }

    private void writeFile() {
        try {

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element element = document.createElement("text");
            document.appendChild(element);

            for (Letter letter1 : lettersContainer.getLetters()) {

                String size = Integer.toString(letter1.getSize());

                Element letter = document.createElement("letter");
                element.appendChild(letter);

                letter.setAttribute("symbol", letter1.toString());
                letter.setAttribute("type", letter1.getType());
                letter.setAttribute("size", size);
                letter.setAttribute("boldface", String.valueOf(letter1.isBoldface()));
                letter.setAttribute("cursive", String.valueOf(letter1.isCursive()));
            }

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}


