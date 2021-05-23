import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;  
/**
 * Class Prey represents any prey object.
 *
 * @Yamini(23706019) 
 * @Version 2.0
 */

public class YB_Prey extends JFrame {
    // Image object taken as "smile"
    public Image smile;
    public int PreyAlongX;
    public int PreyAlongY;
    
    
    public YB_Prey() {
        smile = new ImageIcon("Images/prey.png").getImage();
        Dimension size = new Dimension(10, 10);
        setPreferredSize(size);
    }
      
      
    /**
    * Method Position
    * This allows prey to chnage its position
    */
    public void position(int RAND_POS,int DOT_SIZE)
    {
      int r = (int) (Math.random() * RAND_POS);
        PreyAlongX= ((r * DOT_SIZE));
    
        r = (int) (Math.random() * RAND_POS);
        PreyAlongY = ((r * DOT_SIZE));
    }
        
    public void checkPrey(int x, int y , int RAND_POS, int DOT_SIZE) 
    {
    
        if ((x == PreyAlongX) && (y == PreyAlongY)) {

            YB_GameBoard.dots++;
            position(RAND_POS,DOT_SIZE);
        }
    }     
}
    
 




  
