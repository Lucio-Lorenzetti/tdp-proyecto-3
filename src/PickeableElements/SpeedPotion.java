package PickeableElements;

import GUI.GraphicEntity;
import Images.ResourceManager;

/**
*
* SpeedPotion Class.
* 
* Defines the applicable operations of a SpeedPotion element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class SpeedPotion extends Potion {

	public SpeedPotion(int posYPX, int posXPX, int width, int height, PickeableManager g) {
		super(posYPX, posXPX, width, height, g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[3] ));
		
	}
	
	public SpeedPotion(PickeableManager g) {
		super(0,0,0,0,g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[3] ));
	}
	
	@Override
	public int consume() {
		manager.speedEffect();
		return points;
	}

	@Override
	public Pickeable clone(){
		return new SpeedPotion(posYPX, posXPX, widthPX, heightPX,manager);
	}

}
