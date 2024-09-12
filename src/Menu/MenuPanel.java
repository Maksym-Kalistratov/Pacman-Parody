package Menu;

import Other.MyList;
import Other.RecordsWindow;
import Other.ResizeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public MenuPanel(JFrame Menuframe) {
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        setPreferredSize(new Dimension(450, 400));
        setBackground(Color.BLACK);


        GridBagConstraints cnstr = new GridBagConstraints();
        cnstr.ipadx = 30;
        cnstr.ipady = 5;
        cnstr.gridx = 0;
        cnstr.gridy = 0;
        cnstr.weighty = 0.5;
        cnstr.fill = GridBagConstraints.BOTH;

        ImageIcon icon = new ImageIcon("src/Menu/Icon2.png");
        JLabel image = new JLabel(icon);
        image.setPreferredSize(new Dimension(400, 100));
        image.setMaximumSize(new Dimension(400, 100));
        image.setMinimumSize(new Dimension(400, 100));
        add(image, cnstr);

        cnstr.gridy++;
        cnstr.fill = GridBagConstraints.HORIZONTAL;

        JButton Play = createButton("Play", e -> {
            new ResizeWindow();
            Menuframe.dispose();
        });
        add(Play, cnstr);
        cnstr.gridy++;

        JButton Records = createButton("High Scores", e -> {
            new RecordsWindow();
            Menuframe.dispose();
        });
        add(Records, cnstr);
        cnstr.gridy++;

        JButton Exit = createButton("Exit", e -> {
            MyList.write();
            System.exit(0);
                });
        add(Exit, cnstr);






    }

    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setPreferredSize(new Dimension(50, 30));
        button.setMaximumSize(new Dimension(50, 30));
        button.setMinimumSize(new Dimension(50, 30));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }
}

