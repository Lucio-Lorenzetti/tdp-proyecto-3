package GameLogic;

import CharacterElements.Ghost;

public class TimerBombPotion extends Timer{

	/**
	 * Creates and initializes a TimerGhost.
	 * @param del Delay for the movement of the Ghosts.
	 * @param game Game that the timer calls.
	 */
	public TimerBombPotion(long del, Game game) {
		super(del, game);
	}

	@Override
	public void run() {
			
			try {
				
				Thread.sleep(delay);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
					
				
			myGame.explodeArea(Game.getPacMan().getPosX(), Game.getPacMan().getPosY());
						
			Game.getPacMan().ChangeState(0);
			
			myGame.updateCharacterGraphic(Game.PacMan);
			
	}
	
	
}
