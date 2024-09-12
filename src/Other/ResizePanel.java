package Other;

import Game.PlayWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ResizePanel extends JPanel {
    public ResizePanel(JFrame resizeFrame){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600,200));
        setBackground(Color.BLACK);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 5, 10, 5));
        buttons.setBackground(Color.BLACK);

        JLabel header = new JLabel("Choose the map size:");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBackground(Color.BLACK);
        header.setForeground(Color.YELLOW);
        JButton size1 = createButton("9x9", e -> {
            new PlayWindow(240,240);
            resizeFrame.dispose();
        });
        JButton size2 = createButton("11x11", e -> {
            new PlayWindow(300,300);
            resizeFrame.dispose();
        });
        JButton size3 = createButton("13x13", e -> {
            new PlayWindow(375,375);
            resizeFrame.dispose();
        });
        JButton size4 = createButton("16x16", e -> {
            new PlayWindow(450,450);
            resizeFrame.dispose();
        });
        JButton size5 = createButton("20x20", e -> {
            new PlayWindow(600,600);
            resizeFrame.dispose();
        });

        buttons.add(size1);
        buttons.add(size2);
        buttons.add(size3);
        buttons.add(size4);
        buttons.add(size5);

        add(header, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);

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
