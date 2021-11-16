package Visitor;

import CharacterElements.Ghost;
import CharacterElements.PacMan;

/**
*
* Class VisitorClyde.
* 
* Defines the applicable operations of a VisitorClyde.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class VisitorClyde extends Visitor {

    protected Ghost clyde;

   /**
    * Creates and initialize a VisitorClyde.
    * @param g clyde.
    */
    public VisitorClyde(Ghost g){
        this.clyde = g;
    }

	@Override
	public void visitPacMan(PacMan p) {
		if(intersect(p,clyde)) {
			
        }
	}

	@Override
	public void visitInky(Ghost g) {
		
	}

	@Override
	public void visitPinky(Ghost g) {
		
	}

	@Override
	public void visitClyde(Ghost g) {
		
	}

	@Override
	public void visitBlinky(Ghost g) {
		
	}

}
