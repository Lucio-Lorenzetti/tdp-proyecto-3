package GameLogic;

public class TimerPacMan extends Timer{

	/**
	 * Creates and initializes a TimerPacMan.
	 * @param del Delay for the movement of the PacMan.
	 * @param game Game that the timer calls.
	 */
	public TimerPacMan(long del, Game game) {
		super(del, game);
	}

	@Override
	public void run() {

		while(true) {
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
					
			if(!paused) {
				myGame.doMove(Game.getPacMan());
			}
			
		}
		
	}

}
