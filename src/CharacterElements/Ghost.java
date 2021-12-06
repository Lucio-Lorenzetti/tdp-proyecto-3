package CharacterElements;

import java.util.LinkedList;

import Elements.Element;
import GUI.GraphicEntity;
import GameLogic.ColisionManager;
import GameLogic.Game;
import IA.AliveGhostGPS;
import IA.DeadGhostGPS;
import IA.GhostGPS;
import IA.NeutralGhostGPS;
import IA.VulnerableGhostGPS;
import Maps.Map;
import Visitor.*;
import java.lang.Math;


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
    
	protected GhostGPS myIA;
    protected LinkedList<GhostGPS> ghostState; 
    protected int indexState;
    protected static int deathState = 0;
    protected static int vulnerableState = 1;
    protected static int neutralState = 2;
    protected static int aliveState = 3;
    
    
    /**
    * Creates and initialize a Ghost;
    * @param row where the Ghost is created.
    * @param col where the Ghost is created.
    */
    public Ghost(int posY, int posX, int width, int height, Map map, GraphicEntity graphicEntity, int characterSpeed){
        
    	super(posY, posX, width, height, graphicEntity, characterSpeed, map);

		myVisitor = new VisitorGhost(this);
        
        ghostState = new LinkedList<GhostGPS>();
        ghostState.addLast(new DeadGhostGPS(myMap, this));
        ghostState.addLast(new VulnerableGhostGPS(myMap, this));
        ghostState.addLast(new NeutralGhostGPS(myMap, this));
        
        indexState = 3;
    }
    

    public int getIndexState(){
		return indexState;
	}
    
    public static int getDeathState(){
        return deathState;
    }
    
    public static int getVulnerableState(){
        return vulnerableState;
    }
    
    public static int getNeutralState(){
        return neutralState;
    }
    
    public static int getAliveState(){
        return aliveState;
    }

    @Override
    public void doOnMovement() {

		if(myMap.checkIfInIntersection(posXPX, posYPX)) {

            myIA.buildRoute();

		}

    }
    
    public GhostGPS getGhostGPS() {
    	return myIA;
    }

    public void ChangeState(int index) {
    	myIA = ghostState.get(index);
    	indexState = index;
    	updateGraphics(actualDirection);
    }
    
    
    public void reviveCheck(Element C) {
    	
    	if(ColisionManager.checkIntersection(this, C)) {
    		ChangeState(aliveState);
    	}

    }
    
    public void accept(Visitor v) {
    	v.visitGhost(this);
	}
    
    /**
     * Alternates between the neutral and chase IA of the Ghost.
     */
    public void alternateNeutralChase() {
    	if(indexState == aliveState) {
    		ChangeState(neutralState);
    	} else if (indexState == neutralState) {
    		ChangeState(aliveState);
    	}
    }
    
    
    public void onMapUpdate() {

    	for(GhostGPS g : ghostState) {
    		g.setMap(myMap);
    	}
    	
    	
    	Element myStartingHome = myMap.getRandomGhostHome();
    	
    	posXPX = myStartingHome.getPosX();
    	posYPX = myStartingHome.getPosY();
    	widthPX = myStartingHome.getWidth()-1;
    	heightPX = myStartingHome.getHeight()-1;

    	
    }
    

}
