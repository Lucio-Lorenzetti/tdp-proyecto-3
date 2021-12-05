package GameLogic;

import GUI.*;
import Maps.Map;
import PickeableElements.Pickeable;
import Timer.Timer;
import Timer.TimerBombPotion;
import Timer.TimerGhost;
import Timer.TimerPacMan;
import Timer.TimerSpeedPotion;
import Timer.TimerVulnerable;
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
    
    
    protected static PacMan myPacMan;
    protected static Role myBlinky;
    protected static Role myPinky;
    protected static Role myInky;
    protected static Role myClyde;
    
    protected int actualScore;
    protected boolean paused;
    protected boolean pacmanIsAlive;
    protected int lives;
    
    
    /**
     * Creates and initializes Game.
     * @param g
     */
    public Game(MainWindow g){

    	actualScore = 0;
    	
    	myTimerPacMan = new TimerPacMan(40, this);
    	
    	myTimerPacManThread = new Thread(myTimerPacMan);
    	
    	myTimerGhosts = new TimerGhost(50, this);
    	
    	myTimerGhostsThread = new Thread(myTimerGhosts);
    	
    	myTimerPacManThread.start();
    	myTimerGhostsThread.start();	
    	
    	
    	myScoreboard = new ScoreBoard<Player>(20, new scoreComparator<Player>());
    	
    	
    	ghostList = new LinkedList<Ghost>();
    	
    	myGUI = g;
    	
    	myLevel = new Level(this, myGUI.getCellHeight(), myGUI.getCellWidth());
    	
    	
    	myPacMan = new PacMan(myGUI.getCellHeight() * 12,  myGUI.getCellWidth() * 10 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap, this);
    	
    	
    	myBlinky = new Blinky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	myPinky = new Pinky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	myInky = new Inky(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	myClyde = new Clyde(myGUI.getCellHeight() * 14,  myGUI.getCellWidth() * 12 , myGUI.getCellWidth() - 1, myGUI.getCellHeight() - 1, myMap );
    	
    	ghostList.add((Ghost) myBlinky);
    	ghostList.add((Ghost) myPinky);
    	ghostList.add((Ghost) myInky);
    	ghostList.add((Ghost) myClyde);
    	
    	myLevel.resetMap();
    	
    	lives = 3;
    	
    	pacmanIsAlive = true;
    	
    	pauseGame();

    }
    
    public void resetGame() {
    	lives = 3;
    	myLevel.resetMap();
    	
    }

    
    
	/**
	* Change the direction of the character.
	* @param dir the next direction.
	* @param C the character whose direction is to be changed
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

    	
    	myPacMan.setMap(m);
    	
    	
    	myGUI.createCharacterGraphic(myPacMan);
    	
    	
    	for(Ghost g : ghostList) {
    		g.setMap(m);
    		myGUI.createCharacterGraphic(g);
    		g.ChangeState(Ghost.getAliveState());
    	}
    	
    	
    	
    	
    }
    
    public void pauseOrUnpause() {
    	if(paused) {
    		startGame();
    	} else {
    		pauseGame();
    	}
    	
    }
    
    public void startGame() {
    	paused = false;
    	onPauseChange();
    	pacmanIsAlive = true;
    }
    
    public void pauseGame() {
    	paused = true;
    	onPauseChange();
    	pacmanIsAlive = false;
    }
    
    private void onPauseChange() {
    	myTimerPacMan.setPaused(paused);
    	myTimerGhosts.setPaused(paused);	
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
    
    
    /**
     * Changes the delay of the movements of the pacman to the speed indicated for <time> milliseconds
     * @param time Time amount of time before the speed of pacman returns to normal. 
     * @param speed Speed of pacman during the time indicated.
     */
    public void changeSpdPacMan(long time, long speed) {
    	
    	this.myTimerPacMan.setDelay(speed);
		
    	myTimerSpeed = new TimerSpeedPotion(time, this);
    	
    	myTimerSpeedThread = new Thread(myTimerSpeed);


		myPacMan.ChangeState(1);
		
    	
    }

    /**
     * Creates a bomb effect after the time indicated by its parameters.
     * @param time Amount of time before the bomb effect.
     */
    public void bombAfterTime(long time) {

    	myTimerBomb = new TimerBombPotion(time, this);
    	
    	myTimerBombThread = new Thread(myTimerBomb);


		myPacMan.ChangeState(2);

		updateCharacterGraphic(myPacMan);
	
		myTimerBombThread.start();
    	
    }
    
    
    /**
     * Changes the speed of PacMan.
     * @param speed new pacman speed.
     */
    public void changeSpdPacMan(long speed) {
    	this.myTimerPacMan.setDelay(speed);
    }
    
    public void changeSpdGhost(long delay) {
    	this.myTimerPacMan.setDelay(delay);
    }
    
    public void explodeArea(int centerX, int centerY) {
    
    	LinkedList<Role> detectedAliveGhostInArea = myMap.explode(centerX, centerY, 2, 2);

    	for(Role g : detectedAliveGhostInArea) {
    		g.ChangeState(Ghost.getDeathState());
    	}
    	
    }

    
    public static Role getPacMan() {
    	return myPacMan;
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



	public void pacmanDeath() {
		if(pacmanIsAlive) {
			
			lives--;
			pauseGame();
			pacmanIsAlive = false;
			
			if(lives > 0) {

				myGUI.updateLifeCounter(lives);
				
				myPacMan.onMapUpdate();
				updateCharacterGraphic(myPacMan);
				myGUI.displaceCharacter(myPacMan);
				for(Ghost g : ghostList) {
					g.onMapUpdate();
					updateCharacterGraphic(g);
					myGUI.displaceCharacter(g);
				}
			} else {
				gameOver();
			}
						
		}
	}
	

	/**
     * Finish the game, add the player who was playing with his score to the scoreBoard.
     * Set actualScore to 0.
     * @return if the game is over or not.
     */
    public void gameOver(){
    	
    	pacmanIsAlive = false;
    	
    	myGUI.updateLifeCounter(lives);
    	
    	myGUI.showGameOver(false);
    	
    	pauseGame();
		
    }
	
	
	
}
