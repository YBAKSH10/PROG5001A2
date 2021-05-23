import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
/**
 * This program demonstrates how to use JFrame and LayoutManager.
 * @author Yamini
 */

public class YB_SnakeGame extends JFrame {
    private JLabel GameOver;
    private JButton ClickToPlay;
    private JLabel TopLayersScore;   
    private JLabel CurrentPlayerScore;
    private Image Snake;
    private JLabel SnakeLabel;
    private JLabel Name;
    private JButton Quit;
    private Graphics g;
    private JLabel MySnakeGame; 
    
     public YB_SnakeGame(String SnakeGame) {  
         super(SnakeGame);
         //setTitle(SnakeGameTille);
        //setResizable(true);
         //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //pack();      
        
        
        
        GameOver = new JLabel("GAME OVER");
        ClickToPlay = new JButton("CLICK TO PLAY");   
        TopLayersScore = new JLabel("TOP LAYER'S SCORE");   
        CurrentPlayerScore = new JLabel("CURRENT PLAYER SCORE"); 
        Name = new JLabel("PROG5001:2021 YAMINI");
        SnakeLabel = new JLabel();
        Quit = new JButton("QUIT");
        MySnakeGame= new JLabel("MY SNAKE GAME");
        
        
        
        //MY SNAKE GAME
        //topconstraint.gridx = 20;
        //topconstraint.gridy = 20;     
        //MySnakeGame.setForeground(Color.white);
        //topPanel.add(MySnakeGame,topconstraint); 
        
        //TOP PANEL
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.BLUE);
        topPanel.setBounds(10,10,1350,50);
        MySnakeGame.setForeground(Color.white);
        GridBagConstraints topconstraint= new GridBagConstraints();
        topconstraint.anchor = GridBagConstraints.NORTH;
        topconstraint.insets = new Insets(10, 10, 10, 10);
        topPanel.add(MySnakeGame,topconstraint);
        
        //  LEFT PANEL 
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.black);
        leftPanel.setBounds(10,10,550,700);        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(50, 50, 50, 50);
        
        // GAME OVER
        constraints.gridx = 0;
        constraints.gridy = 0;     
        GameOver.setForeground(Color.white);
        leftPanel.add(GameOver,constraints);
        
        // CLICK TO PLAY
        constraints.gridx = 0;
        constraints.gridy = 1;  
        leftPanel.add(ClickToPlay, constraints);
        
        // RIGHT PANEL
        JPanel rightPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        //TOP LAYERS SCORE
        constraints.gridx = 0;
        constraints.gridy = 0;     
        rightPanel.add(TopLayersScore, constraints);
        TopLayersScore.setBorder(new LineBorder(Color.blue,2));
        
        //CURRENT PLAYER SCORE
        constraints.gridx = 0;  
        constraints.gridy = 1;
        rightPanel.add(CurrentPlayerScore, constraints);
        CurrentPlayerScore.setBorder(new LineBorder(Color.blue,2));
        
        //NAME PANEL
        constraints.gridx = 0;  
        constraints.gridy = 2;
        rightPanel.add(Name, constraints);
        Name.setBorder(new LineBorder(Color.blue,2));
        
        //SNAKE IMAGE
        constraints.gridx = 0;  
        constraints.gridy = 3;
        //ImageIcon i= new ImageIcon();
        SnakeLabel.setIcon(new ImageIcon("Images/snakeword.jpg"));
        rightPanel.add(SnakeLabel,constraints);
        
        //QUIT
        constraints.gridx = 0;  
        constraints.gridy = 4;
        rightPanel.add(Quit, constraints);
        
         
        
        add(topPanel);
        add(leftPanel);
        add(rightPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        
        //make the form apprear in the screen centre
        
        
    }
    public static void main(String[] args) {        
//        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new YB_SnakeGame("snake");
            sgame.setVisible(true);
//        });
    }
}