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
public class YB_Snake  extends JPanel
{

    Image face;
    Image tail;


    /**
     * Constructor for objects of class Snake
     */
    public YB_Snake(){
        // initialise instance variables   
        face = new ImageIcon("Images/face.png").getImage();
        tail = new ImageIcon("Images/tail.png").getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(100, 100);
        setPreferredSize(size);

    }
}