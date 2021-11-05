package Images;

import java.util.LinkedList;

import javax.swing.ImageIcon;
 
public abstract class ResourceProvider {
	
	protected String[] inkyRoutes;
	protected String[] binkyRoutes;
	protected String[] clydeRoutes;
	protected String[] pinkyRoutes;
	
	protected LinkedList<String> pacmanRoutes;
	protected LinkedList<String> tileRoutes;
	protected LinkedList<String> pickeableRoutes;
	protected LinkedList<String> backgroundRoutes;
	
	protected String themeRoute;
	
	/**
	 * Creates a new resource provider object.
	 * @param route route in which the theme is located.
	 */
	public ResourceProvider(String route) {
		
		themeRoute = "/Images" + route;
		
		inkyRoutes = new String[5];
		pinkyRoutes = new String[5];
		binkyRoutes = new String[5];
		clydeRoutes = new String[5];
		
		pacmanRoutes = new LinkedList<String>();
		tileRoutes = new LinkedList<String>();
		backgroundRoutes = new LinkedList<String>();
		pickeableRoutes = new LinkedList<String>();
		
		int index;
	
		//PACMAN IMAGES
		pacmanRoutes.add(themeRoute + "/characters/pacmanNeutral.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacmanLeft.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacmanUp.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacmanRight.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacmanDown.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacmanDeath.gif");
		
		//TILE IMAGES
		tileRoutes.add(themeRoute + "/tiles/wall.png");
		tileRoutes.add(themeRoute + "/tiles/road.png");
		tileRoutes.add(themeRoute + "/tiles/ghostHome.png");
		tileRoutes.add(themeRoute + "/tiles/borderWall.png");
		
		//BACKGROUND IMAGES
		backgroundRoutes.add( themeRoute + "/backgrounds/background1.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background2.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background3.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background4.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background5.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background6.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background7.gif");
		
		//PICKEABLE IMAGES
		pickeableRoutes.add(themeRoute +  "/pickeable/pacDot.png");
		pickeableRoutes.add(themeRoute +  "/pickeable/powerPellet.png");
		pickeableRoutes.add(themeRoute +  "/pickeable/fruit.png");
		pickeableRoutes.add(themeRoute +  "/pickeable/speedPotion.png");
		pickeableRoutes.add(themeRoute +  "/pickeable/bombPotion.png");
		
	}
	
	/**
	 * Generates an ImageIcon array containing PacMan graphics.
	 * @return ImageIcon array with PacMan graphics.
	 */
	public ImageIcon[] getPacManImages() {
	
		ImageIcon[] images = new ImageIcon[pacmanRoutes.size()];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon(this.getClass().getResource( pacmanRoutes.get(i) ));
		}
		
		return images;
		
	}
	
	/**
	 * Generates an ImageIcon array containing PacMan graphics.
	 * @return ImageIcon array with PacMan graphics.
	 */
	public ImageIcon[] getBackgroundImages() {
		
		ImageIcon[] images = new ImageIcon[backgroundRoutes.size()];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon( this.getClass().getResource( backgroundRoutes.get(i) ) );
		}
		
		return images;
		
	}
	
	/**
	 * Generates an ImageIcon array containing Tile graphics.
	 * @return ImageIcon array with Tile graphics.
	 */
	public ImageIcon[] getTileImages() {
		
		ImageIcon[] images = new ImageIcon[tileRoutes.size()];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon( this.getClass().getResource( tileRoutes.get(i) ));
		}
		
		return images;
		
	}
	
	/**
	 * Generates an ImageIcon array containing Pickeable graphics.
	 * @return ImageIcon array with Pickeable graphics.
	 */
	public ImageIcon[] getPickeableImages() {
		
		ImageIcon[] images = new ImageIcon[pickeableRoutes.size()];
		
		for(int i = 0; i<images.length; i++) {
			images[i] = new ImageIcon( this.getClass().getResource( pickeableRoutes.get(i) ));
		}
		
		return images;
		
	}
	
}
