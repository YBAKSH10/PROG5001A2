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
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
/**
 * This program demonstrates how to use JFrame and LayoutManager.
 * @author Yamini
 */

public class YB_SnakeGame extends JFrame implements ActionListener {
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
    JPanel rightPanel = new JPanel(new GridBagLayout());
    YB_GameBoard leftPanel = new  YB_GameBoard(this);
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
        MySnakeGame= new JLabel("MY SNAKE GAME ©");

        //MY SNAKE GAME
        //topconstraint.gridx = 20;
        //topconstraint.gridy = 20;     
        //MySnakeGame.setForeground(Color.white);
        //topPanel.add(MySnakeGame,topconstraint); 

        //TOP PANEL
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.BLUE);
        topPanel.setSize(1350,50);
        MySnakeGame.setForeground(Color.white);
        GridBagConstraints topconstraint= new GridBagConstraints();
        topconstraint.anchor = GridBagConstraints.NORTH;
        topconstraint.insets = new Insets(10, 10, 10, 10);
        topPanel.add(MySnakeGame,topconstraint);

        //  LEFT PANEL 

        leftPanel.setBackground(Color.black);
        leftPanel.setBounds(20,60,550,700);        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(50, 50, 50, 50);

        // GAME OVER
        constraints.gridx = 0;
        constraints.gridy = 1;     

        ClickToPlay.addActionListener(this);
        leftPanel.add(ClickToPlay, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        GameOver.setForeground(Color.white);
        leftPanel.add(GameOver,constraints);

        GameOver.setVisible(false);
        ClickToPlay.setVisible(false);
        // CLICK TO PLAY

        // RIGHT PANEL
        //JPanel rightPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //TOP LAYERS SCORE
        constraints.gridx = 0;
        constraints.gridy = 0;     
        rightPanel.add(TopLayersScore, constraints);
        TopLayersScore.setBorder(new LineBorder(Color.BLACK,2));

        //CURRENT PLAYER SCORE
        constraints.gridx = 0;  
        constraints.gridy = 1;
        rightPanel.add(CurrentPlayerScore, constraints);
        CurrentPlayerScore.setBorder(new LineBorder(Color.BLACK,2));

        //NAME PANEL
        constraints.gridx = 0;  
        constraints.gridy = 2;
        rightPanel.add(Name, constraints);
        Name.setBorder(new LineBorder(Color.BLACK,2));

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
        Quit.addActionListener(this);

         
        add(topPanel);
        add(leftPanel);
        add(rightPanel);
        // To make the action Listener works
        rightPanel.setVisible(false);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    // Displays the screen once the game gets over
    public void GameOverScreen()
    {
        rightPanel.setVisible(true);
        GameOver.setVisible(true);
        ClickToPlay.setVisible(true);
        leftPanel.setLayout(null);
        GameOver.setBounds(200,200,100,20);
        ClickToPlay.setBounds(200,340,120,30);

    }

    public void actionPerformed(ActionEvent e) {

        // Calling class YB_SnakeGame through the object on click play event and quit
      
        YB_SnakeGame Game1 = null;
        // [https://www.codota.com/code/java/methods/java.awt.event.ActionEvent/getSource]
        if(e.getSource()==ClickToPlay)
        {
            Game1= new YB_SnakeGame("snake");
            Game1.setSize(1200,1200);
            // [https://www.codota.com/code/java/methods/javax.swing.JFrame/dispose]
            this.dispose();
        }
        else if(e.getSource()==Quit)        
        //[https://www.edureka.co/blog/system-exit-in-java/]
        System.exit(0);
    }

    //make the form apprear in the screen centre
    //public static void main(String[] args) {        
    //EventQueue.invokeLater(() -> {
    //create the game with a game title as follow: The Snake Game (C) Your_Name
    //JFrame sgame = new YB_SnakeGame("Snake");
    // sgame.setVisible(true);
    //sgame.setSize(1300,800);
    // });
    // }

}