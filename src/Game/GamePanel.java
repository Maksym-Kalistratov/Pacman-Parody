package Game;


import Timer.MyTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private int rows;
    private int cols ;


    private final int cellSize;

    private int[][] currentMaze;


    private final int[][] maze9x9 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
  private final  int[][] maze11x11 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
  private final int[][] maze13x13 = {
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
          {0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0},
          {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0},
          {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
          {0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
          {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
          {0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
          {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
          {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0},
          {0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0},
          {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
  };
  private final int[][] maze16x16 = {

            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

    };
  private final int[][] maze20x20 = {
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
          {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0},
          {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0},
          {0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0},
          {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0},
          {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
          {0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0},
          {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
          {0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0},
          {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
          {0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0},
          {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
          {0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0},
          {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
          {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
          {0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0},
          {0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0},
          {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
  };




    private final Cell[][] components;

    private final PlayWindow base;

    private final PacMan pacman;
    private final Ghost ghost1;
    private final Ghost ghost2;
    private final Ghost ghost3;

    private final MyTimer Anim;
    private final MyTimer ghostMove;

    private final MyTimer collisionChecker;
    private final MyTimer upgradeAdder;

    private final int upgradesNumber;

    private int points;



    public GamePanel(int size, PlayWindow base, int cellsize) {
       this.base = base;
       upgradesNumber = 3;
       points = 0;
       this.cellSize = cellsize;
        switch (size){
            case 240:
                this.currentMaze = maze9x9;
                this.cols = 9;
                this.rows = 9;
                break;
            case 300:
                this.currentMaze = maze11x11;
                this.cols = 11;
                this.rows = 11;
                break;
            case 375:
                this.currentMaze = maze13x13;
                this.cols = 13;
                this.rows = 13;
                break;
            case 450:
                this.currentMaze = maze16x16;
                this.cols = 16;
                this.rows = 16;
                break;
            case 600:
                this.currentMaze = maze20x20;
                this.cols = 20;
                this.rows = 20;
                break;

        }



        setLayout(new GridLayout(rows, cols));
        setBackground(Color.BLACK);

        components =  new Cell[rows][cols];

        pacman = new PacMan(1, 1, cellSize-10);
        ghost1 = new Ghost(4, 4, cellSize-10,1);
        ghost2 = new Ghost(4, 5, cellSize-10,2);
        ghost3 = new Ghost(4, 6, cellSize-10,3);
        loadMaze();



        Anim = new MyTimer(100, () -> {
            pacman.changeImage();
            ghost1.changeImage(pacman.getKillMode());
            ghost2.changeImage(pacman.getKillMode());
            ghost3.changeImage(pacman.getKillMode());
        });

        ghostMove = new MyTimer(500, () -> {
            moveGhost(ghost1);
            moveGhost(ghost2);
            moveGhost(ghost3);

        });
        collisionChecker = new MyTimer(100, () -> {
            if (ghost1.getX() == pacman.getX() && ghost1.getY() == pacman.getY()){
                collision(ghost1, pacman);
            } else if (ghost2.getX() == pacman.getX() && ghost2.getY() == pacman.getY()){
                collision(ghost2, pacman);
            } else if (ghost3.getX() == pacman.getX() && ghost3.getY() == pacman.getY()){
                collision(ghost3, pacman);
            }

        });
        upgradeAdder = new MyTimer(5000, () ->
                addUpgrade()
        );
        Anim.start();
        ghostMove.start();
        collisionChecker.start();
        upgradeAdder.start();

    }
    public int getPacmanHealth(){
        return pacman.getHealth();
    }
    public int getPacmanScore(){
        return pacman.getScore();
    }
    private void loadMaze() {


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean isWall = currentMaze[row][col] == 0;
                Cell cell = new Cell(isWall);
                if(!isWall) points +=1;
                if (row == pacman.getY() && col == pacman.getX()) {
                    cell.addPacman(pacman);
                }
                if (row == ghost1.getY() && col == ghost1.getX()) {
                    cell.addGhost(ghost1);
                }
                if (row == ghost2.getY() && col == ghost2.getX()) {
                    cell.addGhost(ghost2);
                }
                if (row == ghost3.getY() && col == ghost3.getX()) {
                    cell.addGhost(ghost3);
                }

                components[row][col] = cell;
                add(cell);
            }
        }
        for (int i = 0 ; i < upgradesNumber; i++) {
            int[] pill = randomCoordinates();

                components[pill[0]][pill[1]].addPill();

            }

    }

    public void addUpgrade(){
       int ghostNumber = (int) ((Math.random() * 3) + 1);
        int prob = (int) ((Math.random() * 4) + 1);
        if(prob == 1){
            if(ghostNumber == 1){
                components[ghost1.getY()][ghost1.getX()].addUpgrade();
            } else if (ghostNumber == 2){
                components[ghost2.getY()][ghost2.getX()].addUpgrade();
            }else if (ghostNumber == 3){
                components[ghost3.getY()][ghost3.getX()].addUpgrade();
            }
        }
    }
    public void close(){
        Anim.stop();
        ghostMove.stop();
        collisionChecker.stop();
        upgradeAdder.stop();
    }

    public int[] randomCoordinates(){
        int col = (int) (Math.random() * cols) ;
        int row = (int) (Math.random() * rows) ;
        if (currentMaze[row][col] == 1){
            return new int[]{row, col};
        }
        else return randomCoordinates();


    }

    public void moveGhost(Ghost ghost){
        int direction = (int) ((Math.random() * 4) + 1);
        int prevX = ghost.getX();
        int prevY = ghost.getY();
        if (direction == 1) {
            ghost.decX(1);
        }
        if (direction == 2) {
            ghost.decY(1);
        }
        if (direction == 3) {
            ghost.incX(1);
        }
        if (direction == 4) {
            ghost.incY(1);
        }
        if (currentMaze[ghost.getY()][ghost.getX()] == 1 ) {

            relocateGhost(ghost, prevX,prevY);

        }else{
            ghost.setX(prevX);
            ghost.setY(prevY);
            moveGhost(ghost);
        }

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int prevX = pacman.getX();
        int prevY = pacman.getY();
        if (code == KeyEvent.VK_LEFT) {
            pacman.decX(1);
            pacman.setDirection(3);
        }
        if (code == KeyEvent.VK_UP) {
            pacman.decY(1);
            pacman.setDirection(4);
        }
        if (code == KeyEvent.VK_RIGHT) {
           pacman.incX(1);
            pacman.setDirection(1);
        }
        if (code == KeyEvent.VK_DOWN) {
            pacman.incY(1);
            pacman.setDirection(2);
        }

        if (currentMaze[pacman.getY()][pacman.getX()] == 1) {
             movePacman(prevX,prevY);


        }else{
            pacman.setX(prevX);
            pacman.setY(prevY);
        }
    }

    public void movePacman(int prevX, int prevY){
        Cell prevCell = components[prevY][prevX];
        Cell newCell = components[pacman.getY()][pacman.getX()];
        if( newCell.hasPoint()){
            newCell.removePoint();
        pacman.incScore(10);
        base.updateScore(pacman.getScore());
        points -= 1;
        }
        if (newCell.hasPill()){
            newCell.removePill();
            pacman.setKillMode(true);
        }
        if (newCell.hasUpgrade()){
          int upgr = newCell.removeUpgrade();
            if(upgr == 1) {
                pacman.incHealth(1);
                base.updateHealthPanel();
            }
            if(upgr == 2) {
                pacman.setInvMode(true);

            }
        }

        prevCell.removePacman();
        newCell.addPacman(pacman);


        components[prevY][prevX] = prevCell;
        components[pacman.getY()][pacman.getX()] = newCell;


        prevCell.revalidate();
        prevCell.repaint();
        newCell.revalidate();
        newCell.repaint();

        if (points <= 0){
            new EndWindow(base, getPacmanScore(), base.getTimePassed());
            base.close();
        }
    }
    public void collision(Ghost ghost, PacMan pacman){
       if(!pacman.getInvMode()) {
           if (ghost.getX() == pacman.getX() && ghost.getY() == pacman.getY()) {
               if (pacman.getKillMode()) {
                   int ghostPrevY = ghost.getY();
                   int ghostPrevX = ghost.getX();
                   int[] ghostRand = randomCoordinates();
                   ghost.setY(ghostRand[0]);
                   ghost.setX(ghostRand[1]);
                   relocateGhost(ghost, ghostPrevX, ghostPrevY);
                   pacman.incScore(100);
               } else {
                   pacman.decHealth(1);
                   ghostMove.pause();
                   int pacPrevX = pacman.getX();
                   int pacPrevY = pacman.getY();
                   pacman.setX(1);
                   pacman.setY(1);
                   movePacman(pacPrevX, pacPrevY);
                   base.updateHealthPanel();
                   ghostMove.Continue();
               }
           }
       }
    }
    public void relocateGhost(Ghost ghost1, int prevX, int prevY){
        Cell prevCell = components[prevY][prevX];
        Cell newCell = components[ghost1.getY()][ghost1.getX()];

        prevCell.removeGhost();
        newCell.addGhost(ghost1);


        components[prevY][prevX] = prevCell;
        components[ghost1.getY()][ghost1.getX()] = newCell;


        prevCell.revalidate();
        prevCell.repaint();
        newCell.revalidate();
        newCell.repaint();
    }
}