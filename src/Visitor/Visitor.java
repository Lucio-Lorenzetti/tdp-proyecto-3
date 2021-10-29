package Visitor;

import CharacterElements.*;
import CharacterElements.Character;

/**
*
* Class Visitor.
* 
* Defines the applicable operations of a Visitor.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Visitor {

    /**
    * Visit the Pacman.
    * @param p pacman.
    */
	public abstract void visitPacMan(PacMan p);

    /**
    * Visit the ghost Inky.
    * @param g.
    */
	public abstract void visitInky(Ghost g);
	     
    /**
    * Visit the ghost Pinky.
    * @param g Pinky.
    */
	public abstract void visitPinky(Ghost g);
	
    /**
    * Visit the ghost Clyde.
    * @param g Clyde.
    */
	public abstract void visitClyde(Ghost g);
	
    /**
    * Visit the ghost Blinky.
    * @param g Blinky.
    */
	public abstract void visitBlinky(Ghost g);
	
    /**
    * Return if the character a and b are in the same position.
    * @param a character.
    * @param b character.
    * @return true if both are in the same position, false otherwise.
    */
	public  boolean intersect(Character a, Character b){
        boolean retorno;
        retorno = (a.getColumn() == b.getColumn() && a.getRow() == b.getRow()) ? true : false;
        return retorno;
    }
}
