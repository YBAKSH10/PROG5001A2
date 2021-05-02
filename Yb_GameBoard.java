import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

abstract class Yb_GameBoard extends JPanel {    
    int xcells = 30;    
    int ycells = 30;
    int szcell = 10;       
       
    public Yb_GameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black);
        setFocusable(true);        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    /** Method Exit
     * This method will allow user to close the game window
     * 
     */
    public abstract void Exit();
    
    /** Method Resize
     * This method will allow user to change the screen size of the window
     * 
     */
    public abstract void Resize();
}




