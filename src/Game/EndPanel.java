package Game;

import Menu.MainMenu;
import Other.MyList;
import Other.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



public class EndPanel extends JPanel {



    public EndPanel(JFrame base, JFrame endFrame, int score , double time) {
        setLayout(new GridLayout(3, 1, 10, 10));
        setBackground(Color.BLACK);


        JLabel message = new JLabel("Game Over, Enter your name to continue");
        message.setForeground(Color.YELLOW);
        message.setHorizontalAlignment(SwingConstants.CENTER);


        JTextField input = new JTextField(20);


        //this.score = score;
        JButton okButton = createButton("OK", e -> {
            String nickname = input.getText();
            MyList.add( new Record(score, time, nickname));
            new MainMenu();
            endFrame.dispose();
            base.dispose();

        });
        add(message);
        add(input);
        add(okButton);
    }



    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }

}
