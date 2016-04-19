package by.verenich.texteditor;

import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Created by 1o on 19.04.2016.
 */
public class Caret {
    private int coordinatX;
    private int coordinatY;
    private int size;
    private TextField textField;

    public Caret() {
        size = 12;
    }

    public void setCoordinatX(int coordinatX) {
        this.coordinatX = coordinatX;
        System.out.println(" ");
        System.out.print("x = ");
        System.out.println(coordinatX);
    }

    public void setCoordinatY(int coordinatY) {
        this.coordinatY = coordinatY;
        System.out.print("y = ");
        System.out.println(coordinatY);
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void drawCaret(){
        Graphics2D graphics2d = (Graphics2D) textField.getGraphics();
        graphics2d.setFont(new Font("Times New Roman", Font.PLAIN, size));
        graphics2d.drawString("|", coordinatX, coordinatY-1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        graphics2d.setColor(textField.getBackground());
        graphics2d.setFont(new Font("Times New Roman", Font.PLAIN, size));
        graphics2d.drawString("|", coordinatX, coordinatY);
    }

    public int getCoordinatX() {
        return coordinatX;
    }

    public int getCoordinatY() {
        return coordinatY;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
