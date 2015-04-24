
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
  
  
  // TicTacToePanel constructor. Notice how it takes an instance of the game as input!
  public TicTacToePanel(TicTacToe g) {
    this.game = g;
      
      /*
    xImg = createImageIcon("images/X.jpg",
                           "an X image");
    oImg = createImageIcon("images/O.jpg",
                           "a Y image");
    tieImg = createImageIcon("images/Tie.jpg",
                             "a tie image");
       */
      
    /*setLayout(new BorderLayout(10, 10)); // hgap, vgap
    setBackground(Color.blue); // to match the background color of center grid panel
    */

  }
  
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
