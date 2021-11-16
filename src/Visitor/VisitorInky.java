package Visitor;

import CharacterElements.Ghost;
import CharacterElements.PacMan;

/**
*
* Class VisitorInky.
* 
* Defines the applicable operations of a VisitorInky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class VisitorInky extends Visitor {

    protected Ghost inky;

   /**
    * Creates and initialize a VisitorInky.
    * @param g Inky.
    */
    public VisitorInky(Ghost g){
        this.inky = g;
    }

	@Override
	public void visitPacMan(PacMan p) {
		if(intersect(p,inky)) {

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
