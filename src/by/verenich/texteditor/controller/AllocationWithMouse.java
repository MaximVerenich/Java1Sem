package by.verenich.texteditor.controller;

import by.verenich.texteditor.Allocation;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class AllocationWithMouse implements MouseMotionListener, MouseListener{
    private Allocation allocation;
    private int firstClickX;
    private int firstClickY;

    public AllocationWithMouse(Allocation allocation) {
        this.allocation = allocation;
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
        allocation.allocation(firstClickX, firstClickY, secondClickX, secondClickY);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
