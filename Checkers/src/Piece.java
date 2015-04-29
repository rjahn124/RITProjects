/**
 * Piece.java
 *
 * Version:
 *   $Id: Piece.java,v 1.1 2002/10/22 21:12:53 se362 Exp $
 *
 * Revisions:
 *   $Log: Piece.java,v $
 *   Revision 1.1  2002/10/22 21:12:53  se362
 *   Initial creation of case study
 *
 */

/**
 * This is an abstract class representing any piece that
 * know about it's color and possible moves and captures
 *
 * @author
 *
 */

import java.util.*;
import java.awt.*;

public class Piece {
	
   private Color color; // the color of the piece
   private int type; //type of piece that it is
   private static int SINGLE = 0; // this is a single type

      
   /**
    * The constructor for this piece
    * 
    * @param c - the color for this piece
    */
   public Piece( Color c ) {

	   // set the color
	   color = c;
	   type = SINGLE;
   }

   /**
    * 
    * 
    * @return the type of the piece
    */
   public int getType(){
	return type;
	   
   }
   /**
    * This method returns the color of this piece
    * 
    * @return the color for this piece
    */
   public Color getColor() {
  
	   return color;
   }

}// Piece
