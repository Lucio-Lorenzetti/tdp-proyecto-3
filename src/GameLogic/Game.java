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

	protected LinkedList<Ghost> ghostList;
	
    protected ScoreBoard<Player> myScoreboard;
    
    protected Timer myTimerPacMan;
    protected Thread myTimerPacManThread;
    protected Timer myTimerGhosts;
    protected Thread myTimerGhostsThread;
    protected Timer myTimerVulnerable;
    protected Thread myTimerVulnerableThread;
    protected Timer myTimerSpeed;
    protected Thread myTimerSpeedThread;
    protected Timer myTimerBomb;
    protected Thread myTimerBombThread;
    
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
    	
    	pauseGame();
    	
    	
    	myScoreboard = new ScoreBoard<Player>(20, new scoreComparator<Player>());
    	
    	
    	ghostList = new LinkedList<Ghost>();
    	
    	myGUI = g;
    	
    	myLevel = new Level(this, myGUI.getCellHeight(), myGUI.getCellWidth());
    	
    	
    	PacMan = new PacMan(myGUI.getCellHeight() * 12,  myGUI.getCellWidth() * 10 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap);
    	
    	myBlinky = new Blinky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	myPinky = new Pinky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	myInky = new Inky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	myClyde = new Clyde(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	
    	ghostList.add((Ghost) myBlinky);
    	ghostList.add((Ghost) myPinky);
    	ghostList.add((Ghost) myInky);
    	ghostList.add((Ghost) myClyde);
    	
    	myLevel.passLevel();
    	
    	
    	
    	startGame();
    }

    
    
    /**
     * Finish the game, add the player who was playing with his score to the scoreBoard.
     * Set actualScore to 0.
     * @return if the game is over or not.
     */
    public void gameOver(){
    	
    }
    
    public void resetGame() {
		myLevel.changeMap();
	}
    
   
    /**
     * Set the atributte playerName.
     * @param p the name of the player.
     */
    public void setPlayerName(String p){
    	playerName = p;
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
    public void doMove(Role c) {
    
    	if(c.checkDirectionChange()) {
    		updateCharacterGraphic(c);
    	}
    	if(c.move()) {
    		myGUI.displaceCharacter(c);
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
    	
    	myGUI.clearGameScreen();
    	
    	
    	for(int i = 0; i < myMap.getHeight(); i++) {
    		
    		for(int k = 0; k < myMap.getWidth(); k++) {
    			
    			aux = myMap.getCell(i, k);
    			
    			updateCellGraphic(aux);
    		
    			updatePickupGraphic(aux);
    			
        	}
    		
    	}
    	
    	
    	myTimerGhosts.setDelay( myLevel.getGhostDelay() );

    	
    	PacMan.setMap(m);
    	
    	
    	myGUI.createCharacterGraphic(PacMan);
    	
    	
    	for(Ghost g : ghostList) {
    		g.setMap(m);
    	}
    	
    	for(Role R : ghostList) {
    		myGUI.createCharacterGraphic(R);
    	}
    	
    	
    	
    	
    }
    
    public void startGame() {
    	myTimerPacMan.setPaused(false);
    	myTimerGhosts.setPaused(false);
    }
    
    public void pauseGame() {
    	myTimerPacMan.setPaused(true);
    	myTimerGhosts.setPaused(true);
    }

    public void scareAllGhosts() {
    	for(Ghost g : ghostList) {
    		if(g.getIndexState() == Ghost.getAliveState()) {
				g.ChangeState(Ghost.getVulnerableState());
	    		updateCharacterGraphic(g);
    		}
    	}
    	
    	myTimerVulnerable = new TimerVulnerable(8000, this);
    	
    	myTimerVulnerableThread = new Thread(myTimerVulnerable);
		
    	myTimerVulnerableThread.start();
    	
    }
    
    public void returnVulnerableGhostToNormal(){
		for(Ghost g : ghostList) {
			if(g.getIndexState() == Ghost.getVulnerableState()) {
				g.ChangeState(Ghost.getAliveState());
	    		updateCharacterGraphic(g);
    		}
		}
	}
    
    
    
    public void changeSpdPacMan(long time, long speed) {
    	
    	this.myTimerPacMan.setDelay(speed);
		
    	myTimerSpeed = new TimerSpeedPotion(time, this);
    	
    	myTimerSpeedThread = new Thread(myTimerSpeed);


		PacMan.ChangeState(1);

		updateCharacterGraphic(PacMan);
	
		
		myTimerSpeedThread.start();
		
    	
    }

    
    public void bombAfterTime(long time) {

    	myTimerBomb = new TimerBombPotion(time, this);
    	
    	myTimerBombThread = new Thread(myTimerBomb);


		PacMan.ChangeState(2);

		updateCharacterGraphic(PacMan);
	
		myTimerBombThread.start();
    	
    }
    
    
    
    public void changeSpdPacMan(long speed) {
    	this.myTimerPacMan.setDelay(speed);
    }
    
    public void changeSpdGhost(long delay) {
    	this.myTimerPacMan.setDelay(delay);
    }
    
    public void explodeArea(int centerX, int centerY) {
    
    	LinkedList<Role> detectedAliveGhostInArea = myMap.explode(centerX, centerY, 2, 2);
    	
    	LinkedList<Ghost> temporaryVulnerability = new LinkedList<Ghost>();
    	
    	
    	for(Ghost r : ghostList) {
    		
    		if(r.getIndexState() == Ghost.getAliveState()) {
    		
    			r.ChangeState(Ghost.getVulnerableState());
    			temporaryVulnerability.add(r);
	
    		}
    		
    	}

    	for(Role g : detectedAliveGhostInArea) {
    		g.accept(PacMan.getVisitor());
    	}
    	
    	for(Ghost r : temporaryVulnerability) {
    		if(r.getIndexState() == Ghost.getVulnerableState()) {
    			r.ChangeState(Ghost.getAliveState());
    		}
    	}
    	
    }

    
    public static Role getPacMan() {
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

	public LinkedList<Ghost> getGhostList(){
    	return (LinkedList<Ghost>) ghostList.clone();
    }
   

    /*
     * Updates the graphic of the cell on the GUI.
     * @param c cell to be updated.
     */
	public void updateCellGraphic(Cell c){ 

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

	public Map getMap() {
		return myMap;
	}


	
	
	
	
}
