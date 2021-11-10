package GameLogic;

public class TimerPacMan extends Timer{

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
				myGame.doMove(myGame.getPacMan());
			}
			
		}
		
	}

}
