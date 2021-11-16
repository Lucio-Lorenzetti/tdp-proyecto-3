package CharacterElements;

import GameLogic.Game;
import IA.GhostGPS;
import IA.VulnerableGhostGPS;
import Visitor.*;

/**
*
* Ghost Class.
* 
* Defines the applicable operations of a Ghost element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Ghost extends Role {
    protected boolean dead;
    protected boolean moving;
    protected GhostGPS myIA;
    
    /**
    * Creates and initialize a Ghost;
    * @param row where the Ghost is created.
    * @param col where the Ghost is created.
    */
    public Ghost(int posY, int posX, int width, int height, boolean d, boolean m){
        
    	super(posY, posX, width, height);
        this.dead = d;
        this.moving = m;

        //myVisitor = new visitorGhost(this);
    }
    
    @Override
    public void doOnMovement() {
    	//System.out.println("MOVIO FANTASMA");
    }
    
    public GhostGPS getGhostGPS() {
    	return myIA;
    }
    
    public void scare(Game g) {
    	myIA = new VulnerableGhostGPS(g, this);
    }
    
    public abstract void calm(Game g);
    
    /**
    * Accept the visitorPacMan.
    * @param c Visitor of PacMan
    */
    public abstract void accept(VisitorPacMan c);

}
