package Launcher;


import java.awt.EventQueue;

import GameLogic.*;

import GUI.*;

public class Launcher {
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainWindow window = new MainWindow();
				
					Game juego = new Game(window);
					
					window.setGame(juego);
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
