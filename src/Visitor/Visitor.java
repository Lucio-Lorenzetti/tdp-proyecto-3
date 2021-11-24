package Visitor;

import CharacterElements.*;
import CharacterElements.Role;

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
	public abstract void visitGhost(Ghost g);
	     

}
