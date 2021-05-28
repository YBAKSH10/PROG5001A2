import java.awt.Image;
import javax.swing.ImageIcon;
 
/**
 * Class Prey represents any prey object.
 *
 * @Yamini(23706019) 
 * @Version 2.0
 */

public class YB_Prey  {
    // The objects are made for the proper implemetation of the prey
    public Image smile;
    public int PreyAlongX;
    public int PreyAlongY;
    
    
    public YB_Prey() {
        // Path for the Prey
        smile = new ImageIcon("Images/prey.png").getImage();
        //Dimension size = new Dimension(10, 10);
        //setPreferredSize(size);
    }
      
      
    /**
    * Method Position
    * This allows prey to chnage its position
    */
    public void position(int RANDOM_LOCATION,int BODY_SIZE)
    {
        // For the Random position of the prey using X-axis and Y-axis
      int r = (int) (Math.random() * RANDOM_LOCATION);
        PreyAlongX= ((r * BODY_SIZE));
    
        r = (int) (Math.random() * RANDOM_LOCATION);
        PreyAlongY = ((r * BODY_SIZE));
    }
        
    public void SnakePreyCollision(int x, int y , int RANDOM_LOCATION, int BODY_SIZE) 
    {
        // Collision of snake with prey and its increament. 
    
        if ((x == PreyAlongX) && (y == PreyAlongY)) {

            YB_GameBoard.BodySnake++;
            position(RANDOM_LOCATION,BODY_SIZE);
        }
    }     
}
    
 




  
