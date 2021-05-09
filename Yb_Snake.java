/**
 * The given snake class is an abstract class that defines its methods.
 *
 * @author Yamini
 * @version 2.0 (23706019)
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Yb_Snake extends JPanel {
    Image face;
    Image tail;
    public Yb_Snake() {
        face= new ImageIcon("Images/face.png").getImage();
        tail= new ImageIcon("Images/tail.png").getImage();
        Dimension dimension = new Dimension(50,50);
        setPreferredSize(dimension);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(face, 20, 20, null);
        repaint();

        int x_axis = 100;
        int y_axis = 150;

        for(int i=0; i<3; i++)
        {
            g.drawImage(tail, 90,100+(i*250), null);
            //repaint();
            //y_axis = y_axis + 30;
        }

        for(int j=0; j<4; j++)
        { 
            g.drawImage(tail,900,100+(j*250), null);
            //repaint();
            //x_axis = x_axis + 30;
        }
        repaint();
        g.drawImage(tail, 100, 100, null);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Image Of Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Yb_Snake panel = new Yb_Snake();

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }


    
    /** Method Move
     * This method will help the snake to move in various directions using the arrow keys.
     * 
     */
    public void Move()
    {
    }
    
    /** Method EatPrey
     * This method will allow snake to eat the prey
     * 
     */
    public void EatPrey()
    {
    }
    
    /** Method Grow
     * This method will allow snake to eat the prey and grow.
     * 
     */
    public void Grow()
    {
    }
}

