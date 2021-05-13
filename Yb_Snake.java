import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Write a description of class Snake here.
 *
 * @author (Yamini)
 * @version (2.0 or  May 13, 2021)
 */
public class Yb_Snake  extends JPanel
{

    Image face;
    Image tail;

    /**
     * Constructor for objects of class Snake
     */
    public Yb_Snake() {
        // initialise instance variables   
        face = new ImageIcon("images/face.png").getImage();
        tail = new ImageIcon("images/tail.png").getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(100, 100);
        setPreferredSize(size);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(face, 100, 100, null);
        repaint();

        for(int i=1; i<=2;i++)
        {
            g.drawImage(tail, 95+(i*42), 190, null);
            repaint();
        }

        for(int j=0; j<=2;j++)
        {
            g.drawImage(tail, 100, 140+(j*25), null);
            repaint();
        }

        g.drawImage(tail, 180, 167, null);

    }

    public static void main(String[] args) {        
        JFrame frame = new JFrame("Image Of Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Yb_Snake panel = new Yb_Snake();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    /**
     * Method Move
     * this method will help the snake to move in various directions with the help of Arrow keys
     */
    public void Move()
    {

    }

    /**
     * Method EatPrey
     * the snake will change it direction through arrow keys
     */
    public void EatPrey()
    {

    }

    /**
     * Method grow
     * the snake will grow longer when it will eat prey
     */
    public void Grow()
    {

    }

}