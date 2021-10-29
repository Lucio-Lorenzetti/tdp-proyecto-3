package GameLogic;

/**
 * Timer Class.
 * 
 * 
 * @author Lucio Lorenzetti, Guillermo Rodriguez, Agustin Cuello
 *
 */
public abstract class Timer implements Runnable{
	
	private long delay;
	private long speedIncrement;
	private int timeCounter;
	private boolean paused;
	private Game myGame;
	
	/**
	 * Creates and initializes a generic Timer.
	 * @param del Initial delay of the Timer.
	 * @param game Game to which apply the run() operation.
	 */
	public Timer(long del, Game game) {
		super();
		delay = del;
		paused = false;
		myGame = game;
	}
	
	/**
	 * Reduces time between run() calls.
	 */
	public void speedUp() {
		delay = delay - speedIncrement;
	}
	
	/**
	 * Returns the actual temp delay.
	 * @return temp delay.
	 */
	public long getDelay(){
		return delay;
	}
	
	/**
	 * Returns the state of pause.
	 * @return paused.
	 */
	public boolean getPausado() {
		return paused;
	}
	
	/**
	 * Sets the timer delay to newDelay.
	 * @param newDelay Timer delay to set.
	 */
	public void setDelay(long newDelay) {
		delay = newDelay;
	}
	
	/**
	 * Sets the Game pause.
	 * @param newPause Paused value to set.
	 */
	public void setPausado(boolean newPause) {
		paused = newPause;
	}


	
	

}
