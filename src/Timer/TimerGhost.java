package Timer;

import CharacterElements.Ghost;
import GameLogic.Game;

public class TimerGhost extends Timer{

	/**
	 * Creates and initializes a TimerGhost.
	 * @param del Delay for the movement of the Ghosts.
	 * @param game Game that the timer calls.
	 */
	public TimerGhost(long del, Game game) {
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
				
				for(Ghost g : myGame.getGhostList()) {
					myGame.doMove(g);
				}
			}
			
		}
	}

}
