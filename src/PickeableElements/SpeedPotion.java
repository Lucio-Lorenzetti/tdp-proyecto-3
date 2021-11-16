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

	public SpeedPotion(int posYPX, int posXPX, int width, int height) {
		super(posYPX, posXPX, width, height);
		
		myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[3] );
	}
	
	public SpeedPotion() {
		super(0,0,0,0);
		myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[3] );
	}
	
	@Override
	public int consume() {
		return points;
	}

	@Override
	public Pickeable clone(){
		return new SpeedPotion(posYPX, posXPX, widthPX, heightPX);
	}

}
