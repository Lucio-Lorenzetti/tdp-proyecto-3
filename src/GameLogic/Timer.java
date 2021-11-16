package GameLogic;

/**
 * Timer Class.
 * 
 * 
 * @author Lucio Lorenzetti, Guillermo Rodriguez, Agustin Cuello
 *
 */
public abstract class Timer implements Runnable{
	
	protected long delay;
	protected long speedIncrement;
	protected int timeCounter;
	protected boolean paused;
	protected Game myGame;
	
	/**
	 * Creates and initializes a generic Timer.
	 * @param del Initial delay of the Timer.
	 * @param game Game to which apply the run() operation.
	 */
	public Timer(long del, Game game) {
		super();
		delay = del;
		paused = true;
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
	public boolean getPaused() {
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
	public void setPaused(boolean newPause) {
		paused = newPause;
	}


	
	

}
