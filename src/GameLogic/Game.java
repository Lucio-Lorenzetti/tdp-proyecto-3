package GameLogic;

import GUI.*;
import Maps.Map;
import PickeableElements.Pickeable;
import CharacterElements.*;
import java.util.LinkedList;

/**
 *
 * Class Game.
 * 
 * Defines the applicable operations of a Game.
 * 
 * @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class Game {

	protected LinkedList<Ghost> livingGhost;
	protected LinkedList<Ghost> vulnerableGhost;
	protected LinkedList<Ghost> deadGhost;
	
	
    protected ScoreBoard<Player> myScoreboard;
    
    protected Timer myTimerPacMan;
    protected Thread myTimerPacManThread;
    protected Timer myTimerGhosts;
    protected Thread myTimerGhostsThread;
    protected Timer myTimerVulnerable;
    protected Thread myTimerVulnerableThread;
    protected Timer myTimerSpeed;
    protected Thread myTimerSpeedThread;
    
    protected Map myMap;
    protected MainWindow myGUI;
    protected Level myLevel;
    
    
    protected static Role PacMan;
    protected static Role myBlinky;
    protected static Role myPinky;
    protected static Role myInky;
    protected static Role myClyde;
    
    
    
    
    private String playerName;
    protected int actualScore;
    
    
    
    /**
     * Creates and initializes Game.
     * @param g
     */
    public Game(MainWindow g){

    	playerName = "";

    	actualScore = 0;
    	
    	myTimerPacMan = new TimerPacMan(40, this);
    	
    	myTimerPacManThread = new Thread(myTimerPacMan);
    	
    	myTimerGhosts = new TimerGhost(50, this);
    	
    	myTimerGhostsThread = new Thread(myTimerGhosts);
    	
    	myTimerPacManThread.start();
    	myTimerGhostsThread.start();	
    	
    	
    	myScoreboard = new ScoreBoard<Player>(20, new scoreComparator<Player>());
    	
    	
    	livingGhost = new LinkedList<Ghost>();
    	vulnerableGhost = new LinkedList<Ghost>();
    	deadGhost = new LinkedList<Ghost>();
    	
    	
    	myGUI = g;
    	
    	myLevel = new Level(this);
    	
    	////////////////////////////////////////////////////////////////////////
    	
    	myLevel.passLevel(myGUI.getCellHeight(), myGUI.getCellWidth());
    	
    	
    	
    	
    }
    
  	//---------------------------Setters-------------------------------
    
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

    			//System.out.println("Fila " + i +  " Columna " + k + " is null: " + (aux == null));
    			
    			
    			updateCellGraphic(aux);
    			
        	}
    		
    	}
    	
    	
    	myTimerGhosts.setDelay( myLevel.getGhostDelay() );
    	
    	
    	
    	PacMan = new PacMan(myGUI.getCellHeight() * 12,  myGUI.getCellWidth() * 10 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1);
    	myGUI.createCharacterGraphic(PacMan);
    	
    	livingGhost.clear();
    	deadGhost.clear();
    	vulnerableGhost.clear();
    	
    	myBlinky = new Blinky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, false, true, myMap );
    	myPinky = new Pinky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, false, true, myMap );
    	myInky = new Inky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, false, true, myMap );
    	myClyde = new Clyde(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, false, true, myMap );
    	

    	livingGhost.add((Ghost) myBlinky);
    	livingGhost.add((Ghost) myPinky);
    	livingGhost.add((Ghost) myInky);
    	livingGhost.add((Ghost) myClyde);

    	
    	for(Role R : livingGhost) {
    		myGUI.createCharacterGraphic(R);
    	}
    	
    	for(Ghost g : livingGhost) {
    		g.onMapUpdate(myMap);
    	}
    	
    	
    }
    
    /**
     * Sets the GUI to use.
     * @param newMainWindow new GUI to be setted.
     */
    public void setGUI(MainWindow newMainWindow) {
    	myGUI = newMainWindow;
    }
    
    /**
     * Set the atributte playerName.
     * @param p the name of the player.
     */
    public void setPlayerName(String p){
    	playerName = p;
    }
    
    //---------------------------Getters-------------------------------
    
    public static Role getPacMan() {
    	if(PacMan == null) {
    		PacMan = new CharacterElements.PacMan(10, 10, 10, 10);
    	}
    	return PacMan;
    }
    
    public static Role getBlinky() {
    	return myBlinky;
    }
    
    public static Role getPinky() {
    	return myPinky;
    }
    
    public static Role getInky() {
    	return myInky;
    }
    
    public static Role getClyde() {
    	return myClyde;
    }
    
    
    /**
    * Return the level of the game.
    * @return level of the game.
    */
    public Level getLevel() {
    	return myLevel;
    }

	public LinkedList<Ghost> getLivingGhost(){
    	return (LinkedList<Ghost>) livingGhost.clone();
    }
	
	public LinkedList<Ghost> getVulnerableGhost(){
    	return (LinkedList<Ghost>) vulnerableGhost.clone();
    }

	public Map getMap() {
		return myMap;
	}
    
    //---------------------------Operaciones-------------------------------
    
    //M�TODO DE PRUEBA DE SCOREBOARD
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
     * Finish the game, add the player who was playing with his score to the scoreBoard.
     * Set actualScore to 0.
     * @return if the game is over or not.
     */
    public boolean gameOver(){
    	    	
    	myScoreboard.add(new Player(playerName, actualScore));
      
    	actualScore = 0;
    	playerName = "";


		return true;
    
    }
    
   
    
	/**
	* Change the direction of the character.
	* @param dir the next direction.
	* @param C the charactar whose direction is to be changed
	*/
    public void changeDirection(Object dir, CharacterElements.Role C) {
    	C.setNextDirection(dir);
    }
    
    /**
    * Move the character to his next direction.
    * @param c the character who will be move
    */
    public void doMove(CharacterElements.Role c) {
    
    	Object characterDirection = null;
    	Object characterNextDirection = c.getNextDirection();

    	int check1col = 0;
    	int check1row = 0;
    	int check2col = 0;
    	int check2row = 0;
    
    	if(characterNextDirection != c.getActualDirection()) {

	    	if(characterNextDirection == Directions.getLeft()) {
				check1col = c.getPosX();
				check1row = c.getPosY();
				check2col = c.getPosX();
				check2row = c.getPosY() + c.getHeight();
	    	} else
	    	if(characterNextDirection == Directions.getDown()) {
				check1col = c.getPosX();
		    	check1row = c.getPosY() + c.getWidth();
		    	check2col = c.getPosX() + c.getWidth();
		    	check2row = c.getPosY() + c.getHeight();
	    	} else
	    	if(characterNextDirection == Directions.getUp()) {
	    		check1col = c.getPosX();
	        	check1row = c.getPosY();
	        	check2col = c.getPosX() + c.getWidth();
	        	check2row = c.getPosY();
	    	} else
	    	if(characterNextDirection == Directions.getRight()) {
	    		check1col = c.getPosX() + c.getWidth();
	        	check1row = c.getPosY();
	        	check2col = c.getPosX() + c.getWidth();
	        	check2row = c.getPosY() + c.getHeight();
	    	}
	    	
	    	if( myMap.canMove(check1row, check1col, characterNextDirection)  && myMap.canMove(check2row, check2col, characterNextDirection)) {
	    		//!myMap.checkIfInIntersection(C.getPosX(), C.getPosY()) || 
	    		if(myMap.checkIfInPath(c.getPosX(), c.getPosY())) {
					//myMap.updateOnTopCellElements(c, characterNextDirection);
	    			c.updateDirection();  
		    		myGUI.paintCharacter(c);
	    		}	
	    		
	    	}
	    	 
	    	
    	}
    	
    	
    	characterDirection = c.getActualDirection();
    	
    	if(characterDirection == Directions.getLeft()) {	
    		doMoveLeft(c);
    	} else
    	if(characterDirection == Directions.getDown()) {
    		doMoveDown(c);
    	} else
    	if(characterDirection == Directions.getUp()) {
    		doMoveUp(c);
    	} else
    	if(characterDirection == Directions.getRight()) {
    		doMoveRight(c);
    	}
    

    	if(c == PacMan) {
    		
    		Pickeable detectedPickeable = myMap.checkPickeableCollision(c);

    		if(detectedPickeable != null) {
    			
				myMap.consumePickeable(detectedPickeable);
    			
    		}
    		
    	} else { 
				Ghost ghostCharacter = (Ghost) c;
				/*
				LinkedList<Role> collidesWithGhost = myMap.checkCellColitions(ghostCharacter); 

				if(!collidesWithGhost.isEmpty() && collidesWithGhost != null)
					for(Role rle : collidesWithGhost){
						if(rle.equals(PacMan)){
							ghostCharacter.accept(PacMan.getVisitor());
							//checkPacManHearts();
						}
					}
				*/


				if(myMap.checkIfInIntersection(c.getPosX(), c.getPosY())) {

					ghostCharacter.getGhostGPS().buildRoute();

				}
    	}
    	
    }

    /*
	public void checkPacManHearts(){
		if(PacMan.gethearts == 0)
			gameOver();
	}*/
    
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
    	myGUI.displaceCharacter(C);
    }
       

    /**
    * Add points to the actual player of the.
    * @param p points to be added.
    */
    public void addPoints(int p){
    	actualScore = actualScore + p;
    	myGUI.updateScore(actualScore);
    }
    
    public void startGame() {
    	myTimerPacMan.setPaused(false);
    	myTimerGhosts.setPaused(false);
    }
    
    public void endGame() {
    	myTimerPacMan.setPaused(true);
    	myTimerGhosts.setPaused(true);
    }

	public void addLivingList(Ghost g){
		if(deadGhost.contains(g))
			deadGhost.remove(g);
		if(vulnerableGhost.contains(g))
			vulnerableGhost.remove(g);
		
		livingGhost.add(g);
	}

	public void addVulnerableList(Ghost g){
		livingGhost.remove(g);
		vulnerableGhost.add(g);
	}

	public void addDeadList(Ghost g){
		vulnerableGhost.remove(g);
		deadGhost.add(g);
	}

	
	public void returnGhostToNormal(Ghost g) {
		g.ChangeState(2);
		addLivingList(g);
		updateCharacterGraphic(g);
	}

    public void returnVulnerableGhostToNormal(){
		for(Ghost g : vulnerableGhost){
			g.ChangeState(2);
			updateCharacterGraphic(g);
			livingGhost.add(g);
		}
		
		vulnerableGhost.clear();
		
	}

	public void killGhost(Ghost g){
		g.ChangeState(0);
		addDeadList(g);
		updateCharacterGraphic(g);
	}
	
	public void scareGhost(Ghost g){
		g.ChangeState(1);
		addVulnerableList(g);
		updateCharacterGraphic(g);
	}

    public void scareAllGhosts(){
    	
    	System.out.println(livingGhost.size());
    	System.out.println(vulnerableGhost.size());
    	System.out.println(deadGhost.size());
    	
    	
		for(Ghost g : livingGhost) {
			System.out.println("Asustado");
			g.ChangeState(1);
    		vulnerableGhost.add(g);
    		updateCharacterGraphic(g);
    	}
		
		livingGhost.clear();
		
		System.out.println(livingGhost.size());
    	System.out.println(vulnerableGhost.size());
    	System.out.println(deadGhost.size());
    	
		
    	myTimerVulnerable = new TimerVulnerable(8000, this);
    	
    	myTimerVulnerableThread = new Thread(myTimerVulnerable);
		
    	myTimerVulnerableThread.start();
    	
	}

	
    public void changeIA() {
    	
    	for(Ghost g : livingGhost) {
    		g.ChangeState(0);;
    	}
    	
    	LinkedList<Ghost> aux;
    	
    	aux = livingGhost;
    	livingGhost = vulnerableGhost;
    	vulnerableGhost = aux;

    	for(Ghost g : livingGhost) {
    		updateCharacterGraphic(g);
    	}
    	for(Ghost g : vulnerableGhost) {
    		updateCharacterGraphic(g);
    	}
    	
    }
    
    public void changeSpdPacMan(long time, long speed) {
    	this.myTimerPacMan.setDelay(speed);
		
    	myTimerSpeed = new TimerSpeedPotion(8000, this);
    	
    	myTimerSpeedThread = new Thread(myTimerSpeed);
		
    	myTimerSpeedThread.start();
		
    	
    }
    
    public void changeSpdPacMan(long speed) {
    	this.myTimerPacMan.setDelay(speed);
    }
    
    public void changeSpdGhost(long delay) {
    	this.myTimerPacMan.setDelay(delay);
    }
    
    public void explodeArea(int centerX, int centerY) {
    	
    	myMap.explode(centerX, centerY, 2, 2);
    	
    }
    
    
   
    

    /*
     * Updates the graphic of the cell on the GUI.
     * @param c cell to be updated.
     */
	public void updateCellGraphic(Cell c){ 
		
		GraphicEntity auxGraph;
		
		updatePickupGraphic(c);
		
		auxGraph = c.getGraphicEntity();

		myGUI.paintCell(c);
		
	}
	
	/*
     * Updates the graphic of the pickup contained on the cell on the GUI.
     * @param c cell which contains the pickup to be updated.
     */
	public void updatePickupGraphic(Cell c) {
		if(c.getPickup() != null) {
			myGUI.paintPickup(c.getPickup(), c.getRow(), c.getColumn());
		} else {
			myGUI.paintPickup(null, c.getRow(), c.getColumn());	
		}
	}
	
	public void updateCharacterGraphic(Role c) {
		myGUI.paintCharacter(c);
	}

	
	
	
	
}
