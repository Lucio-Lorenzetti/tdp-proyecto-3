package Visitor;

import CharacterElements.Ghost;
import CharacterElements.PacMan;

/**
*
* Class VisitorPinky.
* 
* Defines the applicable operations of a VisitorPinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class VisitorPinky extends Visitor{

    protected Ghost pinky;

    /**
    * Creates and initialize a VisitorPinky.
    * @param p Pinky.
    */
    public VisitorPinky(Ghost p){
        this.pinky = p;
    }

	@Override
	public void visitPacMan(PacMan p) {
        if(intersect(p,pinky)){
            p.die();
        }
		
	}

	@Override
	public void visitInky(Ghost g){
		
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
