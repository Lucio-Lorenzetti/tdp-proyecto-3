package GameLogic;

import Elements.*;
import GUI.*;

/**
 *
 * Class Game.
 * 
 * Defines the applicable operations of a Game.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class Game {

    private Element[] livingGhost;
    //private LevelFactory factory;
    private ScoreBoard myScoreboard;
    private Timer myTimer;
    private Map myMap;
    private MainWindow myGUI;
    private Level myLevel;
    
    /**
     * Creates and initializes Game.
     * @param g
     */
    public Game(MainWindow g){
        
    	myGUI = g;
    	
    	myLevel = new Level(this);
    	
    	myLevel.passLevel();
    }
    
    public Game() {
    	
    	
    }
    
    /**
     * Ends the game.
     * 
     * @return
     */
    public boolean gameOver(){
		return false;
    }
    
    /**
     * Moves the PacMan up.
     */
    public void doMoveUp(){
        
    }

    /**
     * Moves the PacMan down.
     */
    public void doMoveDown(){
        
    }
    
    /**
    * Moves the PacMan to the left.
    *
    */
    public void doMoveLeft(){
        
    }
    
    /**
    * Moves the PacMan to the right.
    *
    */
    public void doMoveRight(){
        
    }
    
    /**
    * Moves the ghosts.
    *
    */
    public void moveGhost(){
        
    }    
    /**
    * Add points to the actual player of the.
    * @param p points to be added.
    */
    public int addPoints(int p){
		return p;
    }
    
    /**
     * Create all elements that will participate in the game.
     */
    public void createElements(){
        
    }
    
    /**
     * Sets the GUI to use.
     * @param newMainWindow new GUI to be setted.
     */
    public void setGUI(MainWindow newMainWindow) {
    	myGUI = newMainWindow;
    }
    
    /**
     * Sets the GUI to use.
     * @param newMainWindow new GUI to be setted.
     */
    public void setMap(Map m) {
    	
    	myMap = m;
    	
    	Cell aux;
    	
    	GraphicEntity auxGraph;
    	
    	for(int i = 0; i < myMap.getHeight(); i++) {
    		
    		for(int k = 0; k < myMap.getWidth(); k++) {
    			
    			aux = myMap.getCell(i, k);

    			if(aux.getPickup() != null) {
    				
    				myGUI.paintPickup(aux.getPickup().getGraphicEntity(), i, k);
    			
    			}
    			
    			auxGraph = aux.getGraphicEntity();
    			
    			myGUI.paintCell(auxGraph, i, k);
    			
        	}
    		
    	}
    	
    	
    }
    
    
}
