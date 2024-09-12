package Game;

import javax.swing.*;


public class EndWindow extends JFrame {


    public EndWindow(JFrame base ,int score ,double time) {
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);



        add(new EndPanel(base, this, score , time));
        setVisible(true);
        setLocationRelativeTo(null);
    }





}
