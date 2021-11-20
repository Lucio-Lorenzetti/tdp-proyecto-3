package GameLogic;

import CharacterElements.Ghost;

public class TimerSpeedPotion extends Timer{

	/**
	 * Creates and initializes a TimerGhost.
	 * @param del Delay for the movement of the Ghosts.
	 * @param game Game that the timer calls.
	 */
	public TimerSpeedPotion(long del, Game game) {
		super(del, game);
	}

	@Override
	public void run() {
			
			try {
				
				Thread.sleep(delay);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
					
				
			myGame.changeSpdPacMan(15);
			
	}
	
	
}
