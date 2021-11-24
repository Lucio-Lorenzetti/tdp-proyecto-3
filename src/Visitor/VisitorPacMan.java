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

    protected PacMan myPacMan;

    /**
    * Creates and initialize a VisitorPacMan.
    * @param p PacMan.
    */
    public VisitorPacMan(PacMan p){
        this.myPacMan = p;
    }

	@Override
	public void visitPacMan(PacMan p) {
		
	}

	@Override
	public void visitGhost(Ghost g) {
		int ghostState = g.getIndexState();
		
		if( ghostState == 2 ) {
			myPacMan.death();
		} else if( ghostState == 1 ) {
			g.ChangeState(0);
		}
		
		
	}


}
