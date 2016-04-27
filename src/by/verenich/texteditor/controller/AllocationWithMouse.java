package by.verenich.texteditor.controller;

import by.verenich.texteditor.Allocation;
import by.verenich.texteditor.LettersContainer;
import by.verenich.texteditor.Line;
import by.verenich.texteditor.TextField;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class AllocationWithMouse implements MouseMotionListener, MouseListener{
    private Allocation allocation;
    private int firstClickX;
    private int firstClickY;
    private LettersContainer lettersContainer;
    private TextField textField;

    public AllocationWithMouse(Allocation allocation, LettersContainer lettersContainer, TextField textField) {
        this.allocation = allocation;
        this.lettersContainer = lettersContainer;
        this.textField = textField;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        firstClickX = e.getX();
        firstClickY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int secondClickX = e.getX();
        int secondClickY = e.getY();
        allocation.setFirstClickX(firstClickX);
        allocation.setFirstClickY(firstClickY);
        allocation.setSecondClickX(secondClickX);
        allocation.setSecondClickY(secondClickY);
        for(int i = 0; i<lettersContainer.getLetters().size(); i++){
            if(lettersContainer.getLetters().get(i).getCoordinatX() >= firstClickX && lettersContainer.getLetters().get(i).getCoordinatX() <= secondClickX){
                if(lettersContainer.getLetters().get(i).getCoordinatY() >= firstClickY && lettersContainer.getLetters().get(i).getCoordinatY() <= secondClickY){
                    lettersContainer.getLetters().get(i).setColor(Color.BLUE);
                }
            }
        }
        textField.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
