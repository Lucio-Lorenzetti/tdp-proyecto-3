package Visitor;

import CharacterElements.Ghost;
import CharacterElements.PacMan;

/**
*
* Class VisitorPacMan.
* 
* Defines the applicable operations of a VisitorPcMan.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class VisitorPacMan extends Visitor{

    protected PacMan pacman;

    /**
    * Creates and initialize a VisitorPacMan.
    * @param p PacMan.
    */
    public VisitorPacMan(PacMan p){
        this.pacman = p;
    }

	@Override
	public void visitPacMan(PacMan p) {
		
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
		if(pacman.collidesWith(g) && g.returnIndexState() == 1){
            //blinky muere
            
        }
	}

}
