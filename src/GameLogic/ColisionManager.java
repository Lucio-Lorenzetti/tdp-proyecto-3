package GameLogic;

import Elements.Element;

public class ColisionManager {

	public static synchronized boolean checkIntersection(Element E1, Element E2) {
	
		int limitE1Top = E1.getPosY();
		int limitE1Bottom  = E1.getPosY() + E1.getHeight();
		int limitE1Left = E1.getPosX();
		int limitE1Right = E1.getPosX() + E1.getWidth();
		
	    int limitE2Top = E2.getPosY();
		int limitE2Bottom  = E2.getPosY() + E2.getHeight();
		int limitE2Left = E2.getPosX();
		int limitE2Right = E2.getPosX() + E2.getWidth();
		
		return limitE1Left <= limitE2Right && limitE1Right >= limitE2Left 
				&& limitE1Top <= limitE2Bottom && limitE1Bottom >= limitE2Top;
	}
	
	
}
