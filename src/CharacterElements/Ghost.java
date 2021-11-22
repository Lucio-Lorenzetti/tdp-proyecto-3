package CharacterElements;

import java.util.LinkedList;

import GUI.GraphicEntity;
import GameLogic.Game;
import IA.AliveGhostGPS;
import IA.DeadGhostGPS;
import IA.GhostGPS;
import IA.VulnerableGhostGPS;
import Maps.Map;
import Visitor.*;

/**
*
* Ghost Class.
* 
* Defines the applicable operations of a Ghost element.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Ghost extends Role {
    
	protected boolean dead;
    protected boolean moving;
    protected boolean scared;
    protected GhostGPS myIA;
    protected LinkedList<GhostGPS> ghostState;
    protected Map myMap;
    protected int indexState;
    
    
    /**
    * Creates and initialize a Ghost;
    * @param row where the Ghost is created.
    * @param col where the Ghost is created.
    */
    public Ghost(int posY, int posX, int width, int height, boolean d, boolean m, Map map, GraphicEntity graphicEntity){
        
    	super(posY, posX, width, height, graphicEntity);
        this.dead = d;
        this.moving = m;
        this.scared = false;
        this.myMap = map;
        ghostState = new LinkedList<GhostGPS>();
        ghostState.addLast(new DeadGhostGPS(myMap, this));
        ghostState.addLast(new VulnerableGhostGPS(myMap, this));
        indexState = 2;
        //myVisitor = new visitorGhost(this);
    }

    public int returnIndexState(){
		return indexState;
	}
    
    @Override
    public void doOnMovement() {
    	//System.out.println("MOVIO FANTASMA");
    }
    
    public GhostGPS getGhostGPS() {
    	return myIA;
    }

   /* 
    public void scare(Game g) {
    	myIA = new VulnerableGhostGPS(myMap, this);
    	this.scared = true;
    	updateGraphics(actualDirection);
    }*/

    //public abstract void calm(Game g);

    /*
     * 
     */
    public void ChangeState(int index) {
    	myIA = ghostState.get(index);
    	indexState = index;
    	this.scared = true;
    	updateGraphics(actualDirection);
    }
    
    private void onStateChange() {
    	
    	if(myIA == ghostState.get(0)) {
    		
    		
    		
    	} else if (myIA == ghostState.get(1)){
    		
    	} else {
    		
    	}
    	
    	myIA.resetObjective();
    	
    }
    
    public void onMapUpdate(Map m) {
    	myMap = m;
    	for(GhostGPS g : ghostState) {
    		g.setMap(m);
    	}
    }
    
   
    
    public abstract void updateGraphics(Object d);
    
    /**
    * Accept the visitorPacMan.
    * @param c Visitor of PacMan
    */
    public abstract void accept(VisitorPacMan c);

}
