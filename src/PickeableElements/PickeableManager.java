package PickeableElements;

import GameLogic.Game;

public class PickeableManager {
	
	Game myGame;
	
	public PickeableManager(Game g) {
		myGame = g;
	}
	
	public void speedEffect() {
		myGame.changeSpdPacMan(5);
	}
	
	public void bombEffect() {
		
	}
	
	public void powerPelletEffect() {
		myGame.changeIA();
	}
	
}
