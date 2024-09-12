package Other;

import Game.PlayWindow;
import Menu.MainMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ResizeWindow extends JFrame implements KeyListener {
    public ResizeWindow(){
        setTitle("Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 200);

        add(new ResizePanel(this));
        addKeyListener(this);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

            new MainMenu();
            dispose();
        }
    }
    public void keyReleased(KeyEvent e) {

    }

}

