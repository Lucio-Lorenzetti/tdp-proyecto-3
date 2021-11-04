package Images;

import java.net.URL;

import javax.swing.ImageIcon;

public class ResourceManager {
	
	public String[] inkyRoutes;
	public String[] binkyRoutes;
	public String[] clydeRoutes;
	public String[] pinkyRoutes;
	
	public String[] pacmanRoutes;
	public String[] tileRoutes;
	public String[] pickeableRoutes;
	public String[] backgroundRoutes;
	
	
	public ResourceManager() {
		
		inkyRoutes = new String[5];
		pinkyRoutes = new String[5];
		binkyRoutes = new String[5];
		clydeRoutes = new String[5];
		
		pacmanRoutes = new String[6];
		tileRoutes = new String[3];
		backgroundRoutes = new String[8];
		pickeableRoutes = new String[5];
		
		int index;
		
		index = 0;
		
		pacmanRoutes[index++] = "/characters/pacmanNeutral.gif";
		pacmanRoutes[index++] = "/characters/pacmanLeft.gif";
		pacmanRoutes[index++] = "/characters/pacmanUp.gif";
		pacmanRoutes[index++] = "/characters/pacmanRight.gif";
		pacmanRoutes[index++] = "/characters/pacmanDown.gif";
		pacmanRoutes[index++] = "/characters/pacmanDeath.gif";
		
		index = 0;
	
		tileRoutes[index++] = "/tiles/wall.png";
		tileRoutes[index++] = "/tiles/road.png";
		tileRoutes[index++] = "/tiles/ghostHome.png";
		tileRoutes[index++] = "/tiles/borderWall.png";

		index = 0;
		
		backgroundRoutes[index++] = "/backgrounds/background1.gif";
		backgroundRoutes[index++] = "/backgrounds/background2.gif";
		backgroundRoutes[index++] = "/backgrounds/background3.gif";
		backgroundRoutes[index++] = "/backgrounds/background4.gif";
		backgroundRoutes[index++] = "/backgrounds/background5.gif";
		backgroundRoutes[index++] = "/backgrounds/background6.gif";
		backgroundRoutes[index++] = "/backgrounds/background7.gif";
		
		index = 0;
		
		pickeableRoutes[index++] = "/pickeable/pacDot.png";
		pickeableRoutes[index++] = "/pickeable/powerPellet.png";
		pickeableRoutes[index++] = "/pickeable/fruit.png";
		pickeableRoutes[index++] = "/pickeable/speedPotion.png";
		pickeableRoutes[index++] = "/pickeable/bombPotion.png";
		
	}
	
	
	public ImageIcon[] getPacManImages() {
	
		ImageIcon[] images = new ImageIcon[pacmanRoutes.length];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon(pacmanRoutes[i]);
		}
		
		return images;
		
	}
	
	public ImageIcon[] getBackgroundImages() {
		
		ImageIcon[] images = new ImageIcon[backgroundRoutes.length];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon(backgroundRoutes[i]);
		}
		
		return images;
		
	}
	
	public ImageIcon[] getTileImages() {
		
		ImageIcon[] images = new ImageIcon[tileRoutes.length];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon(tileRoutes[i]);
		}
		
		return images;
		
	}
	
	public ImageIcon[] getPickeableImages() {
		
		ImageIcon[] images = new ImageIcon[tileRoutes.length];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon(tileRoutes[i]);
		}
		
		return images;
		
	}
	
}
