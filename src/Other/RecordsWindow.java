package Other;

import Menu.MainMenu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RecordsWindow extends JFrame implements KeyListener {
    public RecordsWindow(){
        setTitle("Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 400);


        addKeyListener(this);
        add(new RecordsPanel());
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

