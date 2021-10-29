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

    private Element livingGhost;
    private LevelFactory factory;
    private ScoreBoard scoreboard;
    private Timer timer;
    private Map map;
    private GUI gui;
    
    /**
     * Creates and initializes Game.
     * @param g
     */
    public Game(GUI g){
        this.gui = g;
    }
    
    /**
     * Ends the game.
     * 
     * @return
     */
    public boolean gameOver(){

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
        
    }
    
    /**
     * Create all elements that will participate in the game.
     */
    public void createElements(){

    }
}
