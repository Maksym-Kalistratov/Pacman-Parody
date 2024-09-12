package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Ghost extends JLabel {
    private int x, y;
    private ImageIcon[] images;
    private final ImageIcon[] scared;
    private int imageIndex = 0;

    //private int[][] maze;

    public Ghost(int x, int y, int cellSize, int number) {
        this.x = x;
        this.y = y;

if (number == 1) {
    images = new ImageIcon[]{
            resize(new ImageIcon("src/Ghosts/red1.png"), cellSize, cellSize),
            resize(new ImageIcon("src/Ghosts/red2.png"), cellSize, cellSize),
            resize(new ImageIcon("src/Ghosts/red3.png"), cellSize, cellSize)
    };
}
else if (number == 2) {
            images = new ImageIcon[]{
                    resize(new ImageIcon("src/Ghosts/Pink1.png"), cellSize, cellSize),
                    resize(new ImageIcon("src/Ghosts/Pink2.png"), cellSize, cellSize),
                    resize(new ImageIcon("src/Ghosts/Pink3.png"), cellSize, cellSize)
            };
        }
else if (number == 3) {
    images = new ImageIcon[]{
            resize(new ImageIcon("src/Ghosts/Orange1.png"), cellSize, cellSize),
            resize(new ImageIcon("src/Ghosts/Orange2.png"), cellSize, cellSize),
            resize(new ImageIcon("src/Ghosts/Orange3.png"), cellSize, cellSize)
    };
}
        scared = new ImageIcon[]{
                resize(new ImageIcon("src/Ghosts/affraid1.png"), cellSize, cellSize),
                resize(new ImageIcon("src/Ghosts/affraid2.png"), cellSize, cellSize),
                resize(new ImageIcon("src/Ghosts/affraid3.png"), cellSize, cellSize)
        };
        setIcon(images[imageIndex]);
        setBounds(x, y, images[imageIndex].getIconWidth(), images[imageIndex].getIconHeight());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incX(int i) {
        x += i;
    }

    public void decX(int i) {
        x -= i;
    }

    public void incY(int i) {
        y += i;
    }

    public void decY(int i) {
        y -= i;
    }

    private ImageIcon resize(ImageIcon icon, int width, int height) {
        Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void changeImage(boolean scare) {
        imageIndex = (imageIndex + 1) % images.length;
        if (scare)  setIcon(scared[imageIndex]);
        else setIcon(images[imageIndex]);
    }
}