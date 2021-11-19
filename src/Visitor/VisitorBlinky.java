package Visitor;

import CharacterElements.Ghost;
import CharacterElements.PacMan;

/**
*
* Class VisitorBlinky.
* 
* Defines the applicable operations of a VisitorBlinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class VisitorBlinky extends Visitor {

    protected Ghost blinky;

    /**
    * Creates and initialize a VisitorBlinky.
    * @param g Blinky.
    */
    public VisitorBlinky(Ghost g){
        this.blinky = g;
    }


	@Override
	public void visitPacMan(PacMan p) {
		if(p.collidesWith(blinky) && blinky.returnIndexState() == 1){
            //pacman muere
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
