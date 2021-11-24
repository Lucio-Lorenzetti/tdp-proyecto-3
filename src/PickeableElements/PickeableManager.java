package PickeableElements;

import GameLogic.Game;

public class PickeableManager {
	
	Game myGame;
	
	public PickeableManager(Game g) {
		myGame = g;
	}
	
	public void speedEffect() {
		myGame.changeSpdPacMan(8000, 20);
	}
	
	public void bombEffect(int posX, int posY) {
	
		myGame.bombAfterTime(8000);
		
	}
	
	public void powerPelletEffect() {
		myGame.scareAllGhosts();
	}
	
}
