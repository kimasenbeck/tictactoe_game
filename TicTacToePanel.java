
/** 
 * FILE NAME: TicTacToePanel.java
 * WHO: CS230 staff
 * WHAT: Sets up the Panel that contains the TicTacToe game.
 * It communicates with the TicTacToe.java class where 
 * the functionality of the game resides.
 *
 * Stella Feb 13: added the "play again" button and its functionality
 * Sohie Sep 13: updated border layout locations to page_start, page_end, etc, and added background colors
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToePanel extends JPanel {
  //instance vars
  
  //private ImageIcon xImg, oImg, tieImg; //these images will be used in a couple
  // of diff methods,so make them instance vars, and create them only once.
  
  private TicTacToe game; 
  private JButton quitButton;
  private JButton [][] buttons;
  private JLabel label; 
  private JButton playAgain;
  
  
  // TicTacToePanel constructor. Notice how it takes an instance of the game as input!
  public TicTacToePanel(TicTacToe g) {
    setLayout(new BorderLayout(10, 10)); // hgap, vgap
    this.game = g;
    
    //top panel 
    JPanel top = new JPanel(); 
    top.setBackground(Color.yellow); // to match the background color of center grid panel
    label = new JLabel ("Hello, new player! It's X's turn.");
    top.add(label);
    add(top, BorderLayout.NORTH);
    
    //center panel
    JPanel center = new JPanel(); 
        center.setBackground(Color.yellow); // to match the background color of center grid panel
    setLayout (new GridLayout(3,3));


   //remember that components are added in the order that they are created
    //let's make a two dimensional array of buttons, since the ticTacToe game uses a 2d array in takeAStep
    
    buttons = new JButton[3][3];
    for (int row = 0; row < 3; row++){
      for (int col = 0; col < 3; col++){
        buttons[row][col] = new JButton(" "); //blank button
        buttons[row][col].addActionListener(new ButtonListener());
        center.add(buttons[row][col]); //add button to GUI
      }
    }
    add(center, BorderLayout.CENTER);
    
    //bottom panel 
    JPanel bottom = new JPanel();    
        bottom.setBackground(Color.yellow); // to match the background color of center grid panel
    this.quitButton = new JButton("Quit");
    quitButton.addActionListener(new ButtonListener());
    bottom.add(quitButton); //makes the button show up.
    
    playAgain = new JButton("Play Again");
    playAgain.addActionListener(new ButtonListener());
    bottom.add(playAgain);
    
    add(bottom, BorderLayout.SOUTH);
    
    //TO ADD A MEANINGFUL COMPONENT:
    //create the component, add an actionListener, and add the component to the gui
    
     ImageIcon xImg = createImageIcon("images/X.jpg","an X image");
     ImageIcon oImg = createImageIcon("images/O.jpg","a Y image");
     ImageIcon tieImg = createImageIcon("images/Tie.jpg","a tie image");
     

     
  }
  
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      
      if (event.getSource() == quitButton) {
        System.exit(0);
      }
      
      if (event.getSource() == playAgain){
        for (int row = 0; row < 3; row++){
        for (int col = 0; col < 3; col++){
          buttons[row][col].setText(" ");
        }}
        label.setText("New game, it's X's turn!");
        game = new TicTacToe ();
        for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                  buttons[r][c].setEnabled(true);}}
      }
      
      for (int row = 0; row < 3; row++){
        for (int col = 0; col < 3; col++){
          if(event.getSource() == buttons[row][col]){
            if (game.getIsXTurn()){ //was it x's turn?
              //then make the button show an X
              buttons[row][col].setText("X");
              label.setText("It's O's turn!");
            }
            else{
              buttons[row][col].setText("O");
              label.setText("It's X's turn!");
            }
            //user takeAStep to keep game board up to date
            game.takeAStep(row,col);
            //did anyone win? is the game over? update label.
            if (game.isGameOver() >= 0){
              if (game.isGameOver() == 0){
                label.setText("Game over, tie game!");
              }
              if (game.isGameOver() == 1){
                label.setText("Game over, X won!");
              } 
              if (game.isGameOver() == 2){
                label.setText("Game over, 0 won!");
              }
              for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                  buttons[r][c].setEnabled(false);
                }
              }
            }}
          
          
          
        }
        
      }}}
  
  /** 
   * Creates and returns an ImageIcon out of an image file.
   * @param path The path to the imagefile relevant to the current file.
   * @param description A short description to the image.
   * @return ImageIcon An ImageIcon, or null if the path was invalid. 
   */
  private static ImageIcon createImageIcon(String path, String description) {
    java.net.URL imgURL = TicTacToe.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL, description);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
  
  
} //end TicTacToePanel public class
