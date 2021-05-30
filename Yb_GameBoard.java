import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;

/**
 * Class YB_GameBoard explains about JPanel arranged in GridBag.
 *
 * @author (Yamini)
 * @version (2.0 or  May 13, 2021)
 */

//[https://www.geeksforgeeks.org/java-and-multiple-inheritance/]
//Syntax for multiple inheritance
public class YB_GameBoard extends JPanel implements ActionListener, KeyListener {
    //public class YB_GameBoard extends JFrame implements KeyListener{
    private final int BOARD_WIDTH = 600; 
    private final int BOARD_HEIGHT = 600;
    private final int BODY_SIZE = 10;  
    private final int MAXIMUM_PREYS = 3600; 
    private final int RANDOM_LOCATION = 29; 
    private final int Lag = 140; 
    private final int x[] = new int[MAXIMUM_PREYS]; 
    private final int y[] = new int[MAXIMUM_PREYS]; 
    public static int BodySnake;
    private boolean WestDirection1 = false; 
    private boolean EastDirection1 = true; 
    private boolean NorthDirection1 = false;
    private boolean SouthDirection1 = false; 
    private boolean OngoingGame = true;

    private Timer timer; 
    private Image tail; 
    private Image prey; 
    private Image face; 
    private YB_Prey yb_prey;
    private YB_Snake snake; 
    
    
    YB_SnakeGame PlayGame ;
    public YB_GameBoard(YB_SnakeGame PlayGame) {
        this.PlayGame=PlayGame;
        snake = new YB_Snake();
        yb_prey = new YB_Prey();

        initBoard();
    }

    // gameboard
    private void initBoard() {
        // removed TAdapter
        addKeyListener(this);
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        loadImages();
        initGame();
    }

    // gameboard
    private void loadImages() {

        tail = snake.tail;
        prey = yb_prey.smile;
        face = snake.face;
    }

    // gameboard
    private void initGame() {

        BodySnake = 3;

        for (int z = 0; z < BodySnake; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        yb_prey.position(RANDOM_LOCATION,BODY_SIZE);
        timer = new Timer(Lag, this);
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

        if (OngoingGame) {

            g.drawImage(prey,yb_prey.PreyAlongX,yb_prey.PreyAlongY, this);

            for (int z = 0; z < BodySnake; z++) {
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

        //String msg = "Game Over";
        //Font small = new Font("Times New Roman", Font.BOLD, 12);
        //FontMetrics metr = getFontMetrics(small);

        //g.setColor(Color.white);
        //g.setFont(small);
        //g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
       this.PlayGame.GameOverScreen();

    }

    private void move() {

        for (int z = BodySnake; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (WestDirection1) {
            x[0] -= BODY_SIZE;
        }

        if (EastDirection1) {
            x[0] += BODY_SIZE;
        }

        if (NorthDirection1) {
            y[0] -= BODY_SIZE;
        }

        if (SouthDirection1) {
            y[0] += BODY_SIZE;
        }
    }

    private void Collision() {

        for (int z = BodySnake; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                OngoingGame = false;
            }
        }
        // Collision  with Wlls using if condition
        if (y[0] >= BOARD_HEIGHT) {
            OngoingGame = false;
        }

        if (y[0] < 0) {
            OngoingGame = false;
        }

        if (x[0] >= BOARD_WIDTH) {
            OngoingGame = false;
        }

        if (x[0] < 0) {
            OngoingGame = false;
        }

        if (!OngoingGame) {
            timer.stop();
        }
    }

    // gameboard
    //@Override
    public void actionPerformed(ActionEvent e) {

        if (OngoingGame) {

            yb_prey.SnakePreyCollision(x[0],y[0],RANDOM_LOCATION,BODY_SIZE);
            Collision();
            move();
        }

        repaint();
    }

    //private class TAdapter extends KeyAdapter {
    //  @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        switch (key) {

            case KeyEvent.VK_LEFT :
            WestDirection1 = true;
            NorthDirection1 = false;
            SouthDirection1 = false;
            break;

            case KeyEvent.VK_RIGHT: 
            EastDirection1 = true;
            NorthDirection1 = false;
            SouthDirection1 = false;
            break;

            case KeyEvent.VK_UP: 
            NorthDirection1 = true;
            EastDirection1 = false;
            WestDirection1 = false;
            break;

            case KeyEvent.VK_DOWN: 
            SouthDirection1 = true;
            EastDirection1 = false;
            WestDirection1 = false;
            break;    

            //case KeyEvent.VK_SPACE:
            //downDirection = false;
            //upDirection = false;
            //leftDirection = false;
            //rightDirection = false;
            //break;

            //case KeyEvent.VK_SPACE && inGame:
        }
        if (key == KeyEvent.VK_SPACE ){            
            OngoingGame = !OngoingGame;        

            if (key == KeyEvent.VK_SPACE && !OngoingGame) {   
                timer.stop();          
            }           
            else if (key == KeyEvent.VK_SPACE && OngoingGame ){  
                timer.start();           
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}

        
