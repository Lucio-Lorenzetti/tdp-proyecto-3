package GameLogic;

/**
*
* Player Class.
* 
* Defines the applicable operations of a Player.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Player implements Comparable<Player> {

    private int points;
    private String name;

    /**
     * Create and initialize a player.
     */
    public Player(String name, int points){
        this.name = name;
        this.points = points;
    }

    /**
     * Add the actual player to the ScoreBoard.
     * @returns the player´s points.
     */
    public int getPoints(){
        return points;
    }
    
    /**
     * Returns the name of the Player.
     * @return name of the player.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set the name of the player.
     * @param name to be setted.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Set the player´s points
     * @param p to be setted. 
     */
    public void setPoints(int p){
        points = p;
    }

	@Override
	public int compareTo(Player o) {
		
		int result = 0;
		
		if(points < o.getPoints()) {
			result = -1;
		} else if(points > o.getPoints()) {
			result = +1;
		}

		return result;
	}

	
}
