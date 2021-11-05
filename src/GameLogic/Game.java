package GameLogic;

import Elements.*;
import GUI.*;
import CharacterElements.*;

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
    private ScoreBoard myScoreboard;
    private Timer myTimer;
    private Map myMap;
    private MainWindow myGUI;
    private Level myLevel;
    private CharacterElements.Character PacMan;
    
    /**
     * Creates and initializes Game.
     * @param g
     */
    public Game(MainWindow g){
        
    	myGUI = g;
    	
    	myLevel = new Level(this);
    	
    	System.out.println("Cell height: " + myGUI.getCellHeight() + " Cell width: " + myGUI.getCellWidth());
    	
    	myLevel.passLevel(myGUI.getCellHeight(), myGUI.getCellWidth());
    	
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
    	
    	int check1col = PacMan.getColumn();
    	int check1row = PacMan.getRow();
    	int check2col = PacMan.getColumn() + PacMan.getWidth() - 1;
    	int check2row = PacMan.getRow();
        
       	if( myMap.canMoveUp(check1row, check1col)  &&  myMap.canMoveUp(check2row, check2col) ){
          PacMan.moveUp();
          onMove();
        }
       	
    }

    /**
     * Moves the PacMan down.
     */
    public void doMoveDown(){
    	
    	int check1col = PacMan.getColumn();
    	int check1row = PacMan.getRow() + PacMan.getWidth()  - 1;
    	int check2col = PacMan.getColumn() + PacMan.getWidth() - 1;
    	int check2row = PacMan.getRow() + PacMan.getHeight()  - 1;
    	
        if(myMap.canMoveDown(check1row, check1col)  &&  myMap.canMoveDown(check2row, check2col)){
          PacMan.moveDown();
          onMove();
        }
    }
    
    /**
    * Moves the PacMan to the left.
    *
    */
    public void doMoveLeft(){
        int check1col = PacMan.getColumn();
        int check1row = PacMan.getRow();
        int check2col = PacMan.getColumn();
        int check2row = PacMan.getRow() + PacMan.getHeight() - 1;
        if(myMap.canMoveLeft(check1row, check1col)  &&  myMap.canMoveLeft(check2row, check2col)){
          PacMan.moveLeft();
          onMove();
        }
    }
    
    /**
    * Moves the PacMan to the right.
    *
    */
    public void doMoveRight(){
    	
    	
    	int check1col = PacMan.getColumn() + PacMan.getWidth() - 1;
    	int check1row = PacMan.getRow();
    	int check2col = PacMan.getColumn() + PacMan.getWidth() - 1;
    	int check2row = PacMan.getRow() + PacMan.getHeight() - 1;
    	
        if(myMap.canMoveRight(check1row, check1col)  &&  myMap.canMoveRight(check2row, check2col)){
          PacMan.moveRight();
          onMove();
        }
    }
    
    
    private void onMove() {
    	myGUI.displaceCharacter(PacMan.getColumn(), PacMan.getRow(), PacMan.getWidth(), PacMan.getHeight());
    	//myGUI.paintCharacter(PacMan.getGraphicEntity());
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
    	
    	
    	myGUI.clearGameScreen();
    	
    	
    	for(int i = 0; i < myMap.getHeight(); i++) {
    		
    		for(int k = 0; k < myMap.getWidth(); k++) {
    			
    			aux = myMap.getCell(i, k);

    			if(aux.getPickup() != null) {
    				
    				myGUI.paintPickup(aux.getPickup().getGraphicEntity(), i, k, 17, 17);
    			
    			}
    			
    			auxGraph = aux.getGraphicEntity();
    			
    			myGUI.paintCell(auxGraph, i, k);
    			
        	}
    		
    	}
    	
    	
    	PacMan = new PacMan(myGUI.getCellWidth() * 11, myGUI.getCellHeight() * 11, myGUI.getCellWidth(), myGUI.getCellHeight());
    	
    	myGUI.createMainCharacterGraphic(PacMan);
    	
    	
    }
    
    /**
    * Return the level of te game.
    * @return level of the game.
    */
    public Level getLevel() {
    	return myLevel;
    }
    
}
