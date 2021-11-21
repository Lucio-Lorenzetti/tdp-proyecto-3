package PickeableElements;

import GameLogic.Game;

public class PickeableManager {
	
	Game myGame;
	
	public PickeableManager(Game g) {
		myGame = g;
	}
	
	public void speedEffect() {
		myGame.changeSpdPacMan(5, 5);
	}
	
	public void bombEffect(int posX, int posY) {
	
		myGame.explodeArea(posX, posY);
		
	}
	
	public void powerPelletEffect() {
		myGame.scareAllGhosts();
	}
	
}
