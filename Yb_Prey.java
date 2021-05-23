import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;  
/**
 * Class Prey represents any prey object.
 *
 * @Yamini(23706019) 
 * @Version 2.0
 */

public class YB_Prey extends JPanel {
    Image img;
    public YB_Prey(String image_path, int width, int height) {
        img = new ImageIcon(image_path).getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        repaint();
    }
  
  public static void main(String args[]) {
    JFrame frame = new JFrame("Image prey");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    YB_Prey panel = new YB_Prey("images/smile.png",1237, 50);
    
    frame.add(panel);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  /**
   * Method Position
   * This allows prey to chnage its position
   */
  public void Position()
  {
      
    }
}


  
