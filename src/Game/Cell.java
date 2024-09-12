package Game;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {

    private final boolean isWall;
    private JLabel point;
    private JLabel pacman;
    private JLabel ghost;
    private JLabel pill;
    private JLabel upgrade;

    public Cell(boolean isWall) {

        this.isWall = isWall;

        this.setOpaque(true);
        this.setLayout(new BorderLayout());

        if (isWall) {
            this.add(new JLabel(new ImageIcon("src/map/wall.png")), BorderLayout.CENTER);
            this.setBackground(Color.BLACK);
        } else {
            point = new JLabel(new ImageIcon("src/Textures/point.png"));
            this.add(point, BorderLayout.CENTER);
            this.setBackground(Color.BLUE);
        }
    }


    public JLabel getPointLabel() {return point;}

    public boolean hasPoint(){return point != null;}
    public boolean hasPill(){return pill != null;}
    public boolean hasUpgrade(){return upgrade != null;}

    public void removePoint() {
        if (point != null) {
            this.remove(point);
            point = null;


        }
        //System.out.println("removed point");
    }
    public void addPill() {
        pill = new JLabel(new ImageIcon("src/Textures/Pill.png"));
        this.add(pill , BorderLayout.CENTER);
    }

    public void removePill(){
        if (pill != null) {
            this.remove(pill);
            pill = null;
        }
    }

    public void addUpgrade() {
        upgrade = new JLabel(new ImageIcon("src/Textures/Upgrade.png"));
        this.add(upgrade , BorderLayout.CENTER);
    }
    public int removeUpgrade(){
        if (upgrade != null) {
            this.remove(upgrade);
            upgrade = null;
            return (int) ((Math.random() * 2) + 1);
        }
        return 0;
    }



    public void addPacman(PacMan pacman) {
        this.pacman = pacman;
        this.add(this.pacman, BorderLayout.NORTH);

    }

    public void removePacman() {
        if (pacman != null) {
        this.remove(pacman);
        pacman = null;
        }
   }

    public void addGhost(Ghost ghost) {
        this.ghost = ghost;
        this.add(this.ghost, BorderLayout.NORTH);

    }

    public void removeGhost() {
        if (this.ghost != null) {
            this.remove(this.ghost);
            this.ghost = null;

         }
     }
}
