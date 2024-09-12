package Game;

import Menu.MainMenu;
import Timer.MyTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayWindow extends JFrame implements KeyListener {
    private final GamePanel gamePanel;
    private final JLabel timerLabel;
    private final JLabel scoreLabel;
    private double timePassed;
   private MyTimer timer1;
    private final ImageIcon heart;
    private final JPanel health;



    public PlayWindow( int width, int height){
            setTitle("Game");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(width, height);
        setBackground(Color.BLACK);

            gamePanel = new GamePanel(width, this, 25);
            timerLabel = new JLabel("Time: 0.0 seconds       ");
            timerLabel.setBounds(10, 0, 70, 20);
            timerLabel.setBackground(Color.BLACK);
            timerLabel.setForeground(Color.YELLOW);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(10, 0, 70, 20);
        scoreLabel.setBackground(Color.BLACK);
        scoreLabel.setForeground(Color.YELLOW);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.BLACK);


        health = new JPanel();
        health.setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("src/Textures/heart.png");
        heart  = new ImageIcon(icon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));

        updateHealthPanel();

            timer1 =  new MyTimer(() -> {
                setTime(timer1.time());
            });



        topPanel.add(timerLabel, BorderLayout.WEST);
        topPanel.add(scoreLabel, BorderLayout.CENTER);
        topPanel.add(health, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);
            add(gamePanel, BorderLayout.CENTER);
            timer1.start();
             addKeyListener(this);
            setLocationRelativeTo(null);
            setFocusable(true);
            setVisible(true);

        }
public double getTimePassed(){return timePassed;}


    public void setTime(double time) {
        this.timePassed = time;
        timerLabel.setText(String.format("Time: %.2f seconds       ", timePassed));
    }
    public void updateScore(int score) {

        scoreLabel.setText(String.format("Score: %d ", score));
    }
    public void updateHealthPanel() {
        health.removeAll();
        int hp = gamePanel.getPacmanHealth();
        for (int i = 0; i < hp; i++) {

            health.add(new JLabel(heart));
        }
        health.revalidate();
        health.repaint();
        if (hp == 0){
            new EndWindow(this, gamePanel.getPacmanScore(), timer1.time());
            this.close();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) {
            new MainMenu();
            this.close();
            this.dispose();
        } else if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_UP || code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_DOWN) {
            gamePanel.keyPressed(e);
        }else if(code == KeyEvent.VK_D){
            new EndWindow(this, gamePanel.getPacmanScore(), timer1.time());
           this.close();
           //this.dispose();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public void close(){
        timer1.stop();
        gamePanel.close();

    }

}