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
public class VisitorGhost extends Visitor{

    protected Ghost myGhost;

    /**
    * Creates and initialize a VisitorPinky.
    * @param p Pinky.
    */
    public VisitorGhost(Ghost p){
        myGhost = p;
    }

	@Override
	public void visitPacMan(PacMan p) {

		int ghostState = myGhost.getIndexState();
		
		if( ghostState == Ghost.getAliveState() ) {
			p.death();
		} else if( ghostState == Ghost.getVulnerableState() ) {
			myGhost.ChangeState(0);
		}
		
	}

	@Override
	public void visitGhost(Ghost g) {
	
		
		
	}



}
