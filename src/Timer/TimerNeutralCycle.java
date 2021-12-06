package Timer;

import GameLogic.Game;

public class TimerNeutralCycle extends Timer{

	public TimerNeutralCycle(long del, Game game) {
		super(del, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		while(!paused) {
			
			try {
				
				Thread.sleep(delay);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			myGame.alternateNeutralAndAlive();
		
		}
		
	}

}
