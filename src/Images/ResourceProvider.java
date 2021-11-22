package Images;

import java.util.LinkedList;

import javax.swing.ImageIcon;
 
public abstract class ResourceProvider {
	
	
	
	protected LinkedList<String> pacmanRoutes;
	protected LinkedList<String> pacmanBPRoutes;
	protected LinkedList<String> pacmanSPRoutes;
	protected LinkedList<String> inkyRoutes;
	protected LinkedList<String> blinkyRoutes;
	protected LinkedList<String> clydeRoutes;
	protected LinkedList<String> pinkyRoutes;
	protected LinkedList<String> scaredRoutes;
	protected LinkedList<String> tileRoutes;
	protected LinkedList<String> pickeableRoutes;
	protected LinkedList<String> backgroundRoutes;
	protected LinkedList<String> wallRoutes;
	protected LinkedList<String> roadRoutes;
	protected LinkedList<String> ghostHomeRoutes;

	protected LinkedList<String> backgroundMusicRoutes;	
	
	protected ImageIcon[] pacmanImages;
	protected ImageIcon[] blinkyImages;
	protected ImageIcon[] inkyImages;
	protected ImageIcon[] pinkyImages;
	protected ImageIcon[] clydeImages;
	protected ImageIcon[] scaredImages;
	
	
	protected ImageIcon[] tileImages;
	protected ImageIcon[] pickeableImages;
	protected ImageIcon[] backgroundImages;
	protected ImageIcon[] wallImages;
	protected ImageIcon[] roadImages;
	protected ImageIcon[] ghostHomeImages;

	protected Clip[] backgroundMusic;
	
	protected String themeRoute;
	
	/**
	 * Creates a new resource provider object.
	 * @param route route in which the theme is located.
	 */
	public ResourceProvider(String route) {
		
		themeRoute = "/Images" + route;
		
		pacmanRoutes = new LinkedList<String>();
		pacmanBPRoutes = new LinkedList<String>();
		pacmanSPRoutes = new LinkedList<String>();
		inkyRoutes = new LinkedList<String>();
		pinkyRoutes = new LinkedList<String>();
		blinkyRoutes = new LinkedList<String>();
		clydeRoutes = new LinkedList<String>();
		scaredRoutes = new LinkedList<String>();
		tileRoutes = new LinkedList<String>();
		backgroundRoutes = new LinkedList<String>();
		pickeableRoutes = new LinkedList<String>();
		roadRoutes = new LinkedList<String>();
		ghostHomeRoutes = new LinkedList<String>();
		wallRoutes = new LinkedList<String>();
		
 		backgroundMusicRoutes = new LinkedList<String>();		

		int index;
	
		//PACMAN IMAGES
		pacmanRoutes.add(themeRoute + "/characters/pacman/Neutral.gif");		
		pacmanRoutes.add(themeRoute + "/characters/pacman/Left.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacman/Up.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacman/Right.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacman/Down.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacman/Death.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacman/pacmanToBP.gif");
		pacmanRoutes.add(themeRoute + "/characters/pacman/pacmanToSP.gif");
		
		//PACMANBP IMAGES
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/Neutral.gif");		
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/Left.gif");
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/Up.gif");
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/Right.gif");
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/Down.gif");
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/Death.gif");
		pacmanBPRoutes.add(themeRoute + "/characters/pacmanBP/BPTopacman.gif");
		
		//PACMANSP IMAGES
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/Neutral.gif");		
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/Left.gif");
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/Up.gif");
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/Right.gif");
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/Down.gif");
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/Death.gif");
		pacmanSPRoutes.add(themeRoute + "/characters/pacmanSP/SPTopacman.gif");
		
		//INKY IMAGES
		inkyRoutes.add(themeRoute + "/characters/inky/Neutral.gif");
		inkyRoutes.add(themeRoute + "/characters/inky/Left.gif");
		inkyRoutes.add(themeRoute + "/characters/inky/Up.gif");
		inkyRoutes.add(themeRoute + "/characters/inky/Right.gif");
		inkyRoutes.add(themeRoute + "/characters/inky/Down.gif");
		inkyRoutes.add(themeRoute + "/characters/inky/Death.gif");
		
		
		//CLYDE IMAGES
		clydeRoutes.add(themeRoute + "/characters/clyde/Neutral.gif");
		clydeRoutes.add(themeRoute + "/characters/clyde/Left.gif");
		clydeRoutes.add(themeRoute + "/characters/clyde/Up.gif");
		clydeRoutes.add(themeRoute + "/characters/clyde/Right.gif");
		clydeRoutes.add(themeRoute + "/characters/clyde/Down.gif");
		clydeRoutes.add(themeRoute + "/characters/clyde/Death.gif");
				
		//PINKY IMAGES
		pinkyRoutes.add(themeRoute + "/characters/pinky/Neutral.gif");
		pinkyRoutes.add(themeRoute + "/characters/pinky/Left.gif");
		pinkyRoutes.add(themeRoute + "/characters/pinky/Up.gif");
		pinkyRoutes.add(themeRoute + "/characters/pinky/Right.gif");
		pinkyRoutes.add(themeRoute + "/characters/pinky/Down.gif");
		pinkyRoutes.add(themeRoute + "/characters/pinky/Death.gif");
		
		//BLINKY IMAGES
		blinkyRoutes.add(themeRoute + "/characters/blinky/Neutral.gif");
		blinkyRoutes.add(themeRoute + "/characters/blinky/Left.gif");
		blinkyRoutes.add(themeRoute + "/characters/blinky/Up.gif");
		blinkyRoutes.add(themeRoute + "/characters/blinky/Right.gif");
		blinkyRoutes.add(themeRoute + "/characters/blinky/Down.gif");
		blinkyRoutes.add(themeRoute + "/characters/blinky/Death.gif");
		
		//SCARED IMAGES
		scaredRoutes.add(themeRoute + "/characters/scared/Neutral.gif");
		scaredRoutes.add(themeRoute + "/characters/scared/Left.gif");
		scaredRoutes.add(themeRoute + "/characters/scared/Up.gif");
		scaredRoutes.add(themeRoute + "/characters/scared/Right.gif");
		scaredRoutes.add(themeRoute + "/characters/scared/Down.gif");
		
		
		
		//ROAD TILE IMAGES
		roadRoutes.add(themeRoute + "/tiles/road/horizontalRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/verticalRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/cornerSIRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/cornerIIRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/cornerSDRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/cornerIDRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/T1Road.png");
		roadRoutes.add(themeRoute + "/tiles/road/T2Road.png");
		roadRoutes.add(themeRoute + "/tiles/road/T3Road.png");
		roadRoutes.add(themeRoute + "/tiles/road/T4Road.png");
		roadRoutes.add(themeRoute + "/tiles/road/intersectionRoad.png");
		roadRoutes.add(themeRoute + "/tiles/road/roadTeleport.png");
		
		//WALL TILE IMAGES
		wallRoutes.add(themeRoute + "/tiles/wall/wall.png");
		wallRoutes.add(themeRoute + "/tiles/wall/verticalBorderWall.png");
		wallRoutes.add(themeRoute + "/tiles/wall/horizontalBorderWall.png");
		wallRoutes.add(themeRoute + "/tiles/wall/limitSI.png");
		wallRoutes.add(themeRoute + "/tiles/wall/limitII.png");
		wallRoutes.add(themeRoute + "/tiles/wall/limitSD.png");
		wallRoutes.add(themeRoute + "/tiles/wall/limitID.png");
		wallRoutes.add(themeRoute + "/tiles/wall/wallOnFire.gif");
		
		
		//GHOST HOME IMAGES
		ghostHomeRoutes.add(themeRoute + "/tiles/GhostHome/ghostHomeDoor.png");
		ghostHomeRoutes.add(themeRoute + "/tiles/GhostHome/ghostHomeSI.png");
		ghostHomeRoutes.add(themeRoute + "/tiles/GhostHome/ghostHomeII.png");
		ghostHomeRoutes.add(themeRoute + "/tiles/GhostHome/ghostHomeSD.png");
		ghostHomeRoutes.add(themeRoute + "/tiles/GhostHome/ghostHomeID.png");
		
		
		
		//BACKGROUND IMAGES
		backgroundRoutes.add( themeRoute + "/backgrounds/background1.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background2.gif");
		//backgroundRoutes.add( themeRoute + "/backgrounds/background3.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background4.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background5.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background6.gif");
		backgroundRoutes.add( themeRoute + "/backgrounds/background7.gif");
		
		//PICKEABLE IMAGES
		pickeableRoutes.add(themeRoute +  "/pickeable/pacDot.gif");
		pickeableRoutes.add(themeRoute +  "/pickeable/powerPellet.gif");
		pickeableRoutes.add(themeRoute +  "/pickeable/fruit.gif");
		pickeableRoutes.add(themeRoute +  "/pickeable/speedPotion.gif");
		pickeableRoutes.add(themeRoute +  "/pickeable/bombPotion.gif");
		
		//MUSIC
		backgroundMusicRoutes.add(themeRoute +  "/music/backgroundMusic/BM1.wav");
		
		pacmanImages = new ImageIcon[pacmanRoutes.size()];
		createImages(pacmanRoutes, pacmanImages);
		
		
		blinkyImages = new ImageIcon[blinkyRoutes.size()];
		createImages(blinkyRoutes, blinkyImages);

		inkyImages = new ImageIcon[inkyRoutes.size()];
		createImages(inkyRoutes, inkyImages);

		clydeImages = new ImageIcon[clydeRoutes.size()];
		createImages(clydeRoutes, clydeImages);

		pinkyImages = new ImageIcon[pinkyRoutes.size()];
		createImages(pinkyRoutes, pinkyImages);
		
		scaredImages = new ImageIcon[scaredRoutes.size()];
		createImages(scaredRoutes, scaredImages);
		
		
		
		backgroundImages = new ImageIcon[backgroundRoutes.size()];
		createImages(backgroundRoutes, backgroundImages);
		
		pickeableImages = new ImageIcon[pickeableRoutes.size()];
		createImages(pickeableRoutes, pickeableImages);
		
		roadImages = new ImageIcon[roadRoutes.size()];
		createImages(roadRoutes, roadImages);
		
		wallImages = new ImageIcon[wallRoutes.size()];
		createImages(wallRoutes, wallImages);
		
		ghostHomeImages = new ImageIcon[ghostHomeRoutes.size()];
		createImages(ghostHomeRoutes, ghostHomeImages);
		
	}
	
	/**
	 * Creates an image array based on the routeList parameter which is stored in the storageLocation parameter.
	 * @param routeList List containing the routes of the images.
	 * @param storageLocation ImageIcon array where the images will be stored.
	 */
	private void createImages(LinkedList<String> routeList, ImageIcon[] storageLocation) {
		
		for(int i = 0; i<storageLocation.length; i++) {
			storageLocation[i] = new ImageIcon(this.getClass().getResource( routeList.get(i) ));
		}
		
	}


	/**
	 * Returns an ImageIcon array containing PacMan graphics.
	 * @return ImageIcon array with PacMan graphics.
	 */
	public ImageIcon[] getPacManImages() {
	
		return pacmanImages;
		
	}
	
	/**
	 * Returns an ImageIcon array containing PacMan graphics.
	 * @return ImageIcon array with PacMan graphics.
	 */
	public ImageIcon[] getBackgroundImages() {
		
		return backgroundImages;
		
	}
	
	/**
	 * Returns an ImageIcon containing a random background.
	 * @return ImageIcon with background graphics.
	 */
	public ImageIcon getRandomBackground() {
		
		int imageSelection = (int) (java.lang.System.currentTimeMillis() % backgroundImages.length);
		
		return backgroundImages[imageSelection];
		
	}
	
	
	/**
	 * Returns an ImageIcon array containing Pickeable graphics.
	 * @return ImageIcon array with Pickeable graphics.
	 */
	public ImageIcon[] getPickeableImages() {
		
		return pickeableImages;
		
	}	
	
	/**
	 * Returns an ImageIcon array containing Road graphics.
	 * @return ImageIcon array with Road graphics.
	 */
	public ImageIcon[] getRoadImages() {
		
		return roadImages;
		
	}
	
	/**
	 * Returns an ImageIcon array containing Wall graphics.
	 * @return ImageIcon array with Wall graphics.
	 */
	public ImageIcon[] getWallImages() {
		
		return wallImages;
		
	}
	
	public ImageIcon[] getBlinkyImages() {
		
		return blinkyImages;
		
	}
	
	public ImageIcon[] getInkyImages() {
			
			return inkyImages;
			
		}
	
	public ImageIcon[] getClydeImages() {
		
		return clydeImages;
		
	}
	
	public ImageIcon[] getPinkyImages() {
		
		return pinkyImages;
		
	}
	
	public ImageIcon[] getScaredImages() {
		
		return scaredImages;
		
	}
	
	public ImageIcon[] getGhostHomeImages() {
		return ghostHomeImages;
	}
	
	
	public void resizeTiles(int height, int width) {
		
	}
	
	public void resizeCharacters(int height, int width) {
		
	}
	
	public void resizePickeables(int height, int width) {
		
	}


	
	
}
