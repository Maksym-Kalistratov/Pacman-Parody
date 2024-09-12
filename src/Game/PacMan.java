package Game;

import javax.swing.*;
import java.awt.*;
import Timer.MyTimer;

public class PacMan extends JLabel {
    private int x, y;
    private final ImageIcon[] right_images;
    private final ImageIcon[] left_images;
    private final ImageIcon[] up_images;
    private final ImageIcon[] down_images;
    private final ImageIcon[] death_images;
    private int imageIndex = 0;
    private int direction;
    //private int cellSize;
    private int health;
    private int score;
    private boolean killmode;
    private boolean invincible;

    private MyTimer killModeSwitch;
    private MyTimer invModeSwitch;

    public PacMan(int x, int y, int cellSize) {
        this.x = x;
        this.y = y;
        this.health = 3;
        this.direction = 1;
        this.score = 0;
        this.killmode = false;
        this.invincible = false;
        killModeSwitch = createKillTimer();
        invModeSwitch = createInvTimer();


        right_images = new ImageIcon[]{
                resize(new ImageIcon("src/pacman/rigth_pacman1.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/right_pacman2.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/right_pacman3.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/right_pacman4.png"), cellSize, cellSize)
        };
        left_images = new ImageIcon[]{
                resize(new ImageIcon("src/pacman/left_pacman1.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/left_pacman2.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/left_pacman3.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/left_pacman4.png"), cellSize, cellSize)
        };
        up_images = new ImageIcon[]{
                resize(new ImageIcon("src/pacman/up_pacman1.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/up_pacman2.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/up_pacman3.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/up_pacman4.png"), cellSize, cellSize)
        };
        down_images = new ImageIcon[]{
                resize(new ImageIcon("src/pacman/down_pacman1.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/down_pacman2.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/down_pacman3.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/down_pacman4.png"), cellSize, cellSize)
        };
        death_images = new ImageIcon[]{
                resize(new ImageIcon("src/pacman/pacman_death1.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/pacman_death2.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/pacman_death3.png"), cellSize, cellSize),
                resize(new ImageIcon("src/pacman/pacman_death4.png"), cellSize, cellSize)
        };
        changeImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean getKillMode() {
        return killmode;
    }

    public boolean getInvMode() {
        return invincible;
    }

    public int getScore() {
        return score;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void incX(int i) {
        x += i;
    }

    public void incScore(int i) {
        score += i;
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

    public void decHealth(int i) {
        if (this.health > 0) this.health -= i;
        else if (this.health < 0) this.health = 0;
    }

    public void incHealth(int i) {
        this.health += i;
    }

    public void setKillMode(boolean killmode) {
        this.killmode = killmode;
        if (killmode) {
            System.out.println("kill");
            killModeSwitch = createKillTimer();
            killModeSwitch.setTime(0.0);
            killModeSwitch.start();
        } else {
            killModeSwitch.stop();
        }
    }

    public void setInvMode(boolean invincible) {
        this.invincible = invincible;
        if (invincible) {
            System.out.print("invincible");
            invModeSwitch = createInvTimer();
            invModeSwitch.setTime(0.0);
            invModeSwitch.start();
        } else {
            invModeSwitch.stop();
        }
    }


    private MyTimer createKillTimer() {
        return new MyTimer(1000, () -> {
            if (killModeSwitch.time() >= 10.0) {
                setKillMode(false);
                System.out.println("time passed");
            }
        });
    }

    private MyTimer createInvTimer() {
        return new MyTimer(1000, () -> {
            if (invModeSwitch.time() >= 10.0) {
                setInvMode(false);
                System.out.println("time passed");
            }
        });
    }


    private ImageIcon resize(ImageIcon icon, int width, int height) {
        Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void changeImage() {
        ImageIcon[] images = new ImageIcon[0];
        if (health > 0) {
            images = switch (direction) {
                case 1 -> right_images;
                case 2 -> down_images;
                case 3 -> left_images;
                case 4 -> up_images;
                default -> images;
            };
        } else images = death_images;

        imageIndex = (imageIndex + 1) % right_images.length;
        setIcon(images[imageIndex]);
    }
}