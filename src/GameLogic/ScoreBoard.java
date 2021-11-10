package GameLogic;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
*
* Class ScoreBoard.
* 
* Defines the applicable operations of a ScoreBoard.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class ScoreBoard<Player> extends PriorityQueue<Player> {

	private static final long serialVersionUID = 1L;

    /**
    * Creates and initialize a scoreBoard
    */
    public ScoreBoard(int cantPlayers, Comparator<Player> c){
    	super(cantPlayers, c);
    }

}
