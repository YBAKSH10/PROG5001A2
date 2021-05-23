import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Class YB_GameBoard explains about JPanel arranged in GridBag.
 *
 * @author (Yamini)
 * @version (2.0 or  May 13, 2021)
 */

public class YB_GameBoard extends JPanel implements ActionListener {

    private final int B_WIDTH = 300; 
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;  
    private final int ALL_DOTS = 900; 
    private final int RAND_POS = 20; 
    private final int DELAY = 140; 
    private final int x[] = new int[ALL_DOTS]; 
    private final int y[] = new int[ALL_DOTS]; 
    public static int dots;

    private boolean leftDirection = false; 
    private boolean rightDirection = true; 
    private boolean upDirection = false;
    private boolean downDirection = false; 
    private boolean inGame = true;

    private Timer timer; 
    private Image tail; 
    private Image prey; 
    private Image face; 
    private YB_Prey Prey;
    private YB_Snake snake; 

    public YB_GameBoard() {
        // CONTRUCTOR FOR SNAKE AND PREY
        snake = new YB_Snake();
        Prey = new YB_Prey();

        initBoard();
    }

    // gameboard
    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    // gameboard
    private void loadImages() {

        tail = snake.tail;
        prey = Prey.smile;
        face = snake.face;
    }

    // gameboard
    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        Prey.position(RAND_POS,DOT_SIZE);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    // gameboard
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

    }
    // gameboard
    private void doDrawing(Graphics g) {

        if (inGame) {
            // IMAGE OF PREY IS DRAWN
            g.drawImage(prey,Prey.PreyAlongX,Prey.PreyAlongY, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(face, x[z], y[z], this);
                } else {
                    g.drawImage(tail, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        // CODE TO WRITE "GAME OVER " ON THE PANEL WHICH IS NOT REQUIRED!!!! 
        //String msg = "Game Over";
        //Font small = new Font("Times New Roman", Font.BOLD, 12);
        //FontMetrics metr = getFontMetrics(small);

        //g.setColor(Color.white);
        //g.setFont(small);
        //g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        YB_SnakeGame game = new YB_SnakeGame("Snake"); 
        game.setVisible(true);

    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void Collision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    // gameboard
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            Prey.checkPrey(x[0],y[0],RAND_POS,DOT_SIZE);
            Collision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            //SPACE BAR USED TO PAUE THE GAME!!
            //if ( key == KeyEvent.VK_SPACE){
            //  downDirection = false;
            //upDirection = false;
            //leftDirection = false;
            //rightDirection = false;
            //IMPLEMENTED ANOTHER FUNCTION FOR PLAY/PAUSE BOTH
            if (key == KeyEvent.VK_SPACE ){            
                inGame = !inGame;        
            }           
            if (key == KeyEvent.VK_SPACE && !inGame) {   
                timer.stop();          
            }           
            else if (key == KeyEvent.VK_SPACE && inGame ){  
                timer.start();           
            }

        }
    }
}

