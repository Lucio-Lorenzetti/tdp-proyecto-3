package GameLogic;

import Elements.*;
import GUI.*;
import Maps.Map;
import PickeableElements.Pickeable;
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

	protected Element[] livingGhost;
    protected ScoreBoard<Player> myScoreboard;
    protected Timer myTimerPacMan;
    protected Thread myTimerPacManThread;
    protected Map myMap;
    protected MainWindow myGUI;
    protected Level myLevel;
    protected CharacterElements.Role PacMan;
    private String playerName;
    protected int actualScore;
    
    
    
    /**
     * Creates and initializes Game.
     * @param g
     */
    public Game(MainWindow g){

    	playerName = "";

    	actualScore = 0;
    	
    	
    	
    	myScoreboard = new ScoreBoard<Player>(20, new scoreComparator<Player>());
    	
    	myGUI = g;
    	
    	myLevel = new Level(this);
    	
    	////////////////////////////////////////////////////////////////////////
    	
    	myLevel.passLevel(myGUI.getCellHeight(), myGUI.getCellWidth());
    	
    	myTimerPacManThread.start();
    	
    }
    
    //MÉTODO DE PRUEBA DE SCOREBOARD
    public void printScores() {
    	Player p;
    	
    	for(int i = 1; i<=10; i++) {
    		
    		if(!myScoreboard.isEmpty()) {
	    		p = myScoreboard.remove();
	    		
	    		System.out.println("Posicion " + i + ", Nombre:" + p.getName() + " Puntos: " + p.getPoints() );
    		}
    	}
    }
    
    
    /**
     * Ends the game.
     * 
     * @return
     */
    public boolean gameOver(){
    	    	
    	myScoreboard.add(new Player(playerName, actualScore));
      
    	actualScore = 0;
    	playerName = "";


		return true;
    
    }
    
    public void setPlayerName(String p){
    	playerName = p;
    }

    public void changeDirection(Object dir, CharacterElements.Role C) {
    	C.setNextDirection(dir);
    }
    
    
    public void doMove(CharacterElements.Role C) {
    
    	Object characterDirection = null;
    	Object characterNextDirection = C.getNextDirection();

    	int check1col = 0;
    	int check1row = 0;
    	int check2col = 0;
    	int check2row = 0;
    
    	if(characterNextDirection != C.getActualDirection()) {
    	
	    	if(characterNextDirection == Directions.getLeft()) {
				check1col = C.getPosX();
				check1row = C.getPosY();
				check2col = C.getPosX();
				check2row = C.getPosY() + C.getHeight();
	    	}
	    	if(characterNextDirection == Directions.getDown()) {
				check1col = C.getPosX();
		    	check1row = C.getPosY() + C.getWidth();
		    	check2col = C.getPosX() + C.getWidth();
		    	check2row = C.getPosY() + C.getHeight();
	    	} 
	    	if(characterNextDirection == Directions.getUp()) {
	    		check1col = C.getPosX();
	        	check1row = C.getPosY();
	        	check2col = C.getPosX() + C.getWidth();
	        	check2row = C.getPosY();
	    	} 
	    	if(characterNextDirection == Directions.getRight()) {
	    		check1col = C.getPosX() + C.getWidth();
	        	check1row = C.getPosY();
	        	check2col = C.getPosX() + C.getWidth();
	        	check2row = C.getPosY() + C.getHeight();
	    	}
	    	
	    	if(myMap.checkIfInPath(C.getPosX(), C.getPosY()) && myMap.canMove(check1row, check1col, characterNextDirection)  && myMap.canMove(check2row, check2col, characterNextDirection)) {
	    		C.updateDirection();  
	    		myGUI.paintCharacter(C.getGraphicEntity());
	    	}
	    	
    	}
    	
    	
    	

    	characterDirection = C.getActualDirection();
    	
    	if(characterDirection == Directions.getLeft()) {	
    		doMoveLeft(C);
    	}
    	if(characterDirection == Directions.getDown()) {
    		doMoveDown(C);
    	} 
    	if(characterDirection == Directions.getUp()) {
    		doMoveUp(C);
    	} 
    	if(characterDirection == Directions.getRight()) {
    		doMoveRight(C);
    	}
    

    	if(C == PacMan) {
    		
    		Pickeable detectedPickeable = myMap.checkPickeableCollision(C);
    		
    		if(detectedPickeable != null) {
    			
				myMap.consumePickeable(detectedPickeable);
    			
    			//myGUI.paintPickup(null, , );
    			
    			System.out.println("CONSUMIDO PICKEABLE");
    			
    		}
    		
    		//myMap.checkCharacterCollisions(C);
    	
    	} else {
    		//myMap.checkCharacterCollisions(C);
    	}
    	
    }
    
    /**
     * Moves the PacMan up.
     */
    public void doMoveUp(CharacterElements.Role C){
    	
    	int check1col = C.getPosX();
    	int check1row = C.getPosY();
    	int check2col = C.getPosX() + C.getWidth();
    	int check2row = C.getPosY();
        
       	if( myMap.canMoveUp(check1row, check1col)  &&  myMap.canMoveUp(check2row, check2col) ){
          C.move();
          onMove(C);
        }
       	
    }

    /**
     * Moves the PacMan down.
     */
    public void doMoveDown(CharacterElements.Role C){
    	
    	int check1col = C.getPosX();
    	int check1row = C.getPosY() + C.getWidth();
    	int check2col = C.getPosX() + C.getWidth();
    	int check2row = C.getPosY() + C.getHeight();
    	
        if(myMap.canMoveDown(check1row, check1col)  &&  myMap.canMoveDown(check2row, check2col)){
          C.move();
          onMove(C);
        }
    }
    
    /**
    * Moves the PacMan to the left.
    *
    */
    public void doMoveLeft(CharacterElements.Role C){
    	
        int check1col = C.getPosX();
        int check1row = C.getPosY();
        int check2col = C.getPosX();
        int check2row = C.getPosY() + C.getHeight();
        
        if(myMap.canMoveLeft(check1row, check1col)  &&  myMap.canMoveLeft(check2row, check2col)){
          C.move();
          onMove(C);
        }
    }
    
    /**
    * Moves the PacMan to the right.
    *
    */
    public void doMoveRight(CharacterElements.Role C){
    	
    	int check1col = C.getPosX() + C.getWidth();
    	int check1row = C.getPosY();
    	int check2col = C.getPosX() + C.getWidth();
    	int check2row = C.getPosY() + C.getHeight();
    	
        if(myMap.canMoveRight(check1row, check1col)  &&  myMap.canMoveRight(check2row, check2col)){
          C.move();
          onMove(C);
        }
        
    }
    
    
    private void onMove(CharacterElements.Role C) {
    	myGUI.displaceCharacter(C.getPosX(), C.getPosY(), C.getWidth(), C.getHeight());
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
    public void addPoints(int p){
    	actualScore = actualScore + p;
    	myGUI.updateScore(actualScore);
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
    			
    			//System.out.println("Fila " + i +  " Columna " + k);
    			
    			aux = myMap.getCell(i, k);

    			updateCellGraphic(aux);
    			
        	}
    		
    	}
    	
    	
    	PacMan = new PacMan(myGUI.getCellHeight() * 12,  myGUI.getCellWidth() * 10 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1);
    	
    	myGUI.createMainCharacterGraphic(PacMan);
    	
    	
    	
    	myTimerPacMan = new TimerPacMan(15, this);
    	
    	myTimerPacManThread = new Thread(myTimerPacMan);
    	
    	
    }
    
    /**
    * Return the level of the game.
    * @return level of the game.
    */
    public Level getLevel() {
    	return myLevel;
    }
    
    
    /**
     * Return the PacMan.
     * @return PacMan.
     */
    public CharacterElements.Role getPacMan() {
    	return PacMan;
    }
    

	public void updateCellGraphic(Cell c){ 
		
		GraphicEntity auxGraph;
		
		updatePickupGraphic(c);
		
		auxGraph = c.getGraphicEntity();

		myGUI.paintCell(auxGraph, c.getRow(), c.getColumn());
		
	}
	
	public void updatePickupGraphic(Cell c) {
		if(c.getPickup() != null) {
			myGUI.paintPickup(c.getPickup().getGraphicEntity(), c.getRow(), c.getColumn());
		} else {
			myGUI.paintPickup(null, c.getRow(), c.getColumn());	
		}
	}
	
}
