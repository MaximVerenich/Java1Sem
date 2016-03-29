package by.verenich.texteditor.controller;

import by.verenich.texteditor.TextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerForShift implements KeyListener{
    private TextField textField;

    public KeyListenerForShift(TextField textField){
        this.textField = textField;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isShiftDown() && e.VK_LEFT == e.getKeyCode()) {

        }
        if (e.isShiftDown() && e.VK_RIGHT == e.getKeyCode()) {

        }
        if (e.isShiftDown() && e.VK_UP == e.getKeyCode()) {

        }
        if (e.isShiftDown() && e.VK_DOWN == e.getKeyCode()) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
