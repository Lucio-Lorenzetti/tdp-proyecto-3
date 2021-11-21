package PickeableElements;

import GUI.GraphicEntity;
import Images.ResourceManager;

/**
*
* BombPotion Class.
* 
* Defines the applicable operations of a BombPotion element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class BombPotion extends Potion {

	
	public BombPotion(int posYPX, int posXPX, int width, int height,  PickeableManager g) {
		
		super(posYPX, posXPX, width, height, g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[4]));
		
		
		
	}
	
	public BombPotion(PickeableManager g) {
		
		super(0,0,0,0,g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[4]));
		
	}
	
	@Override
	public int consume() {
		manager.bombEffect(posXPX, posYPX);
		return points;
	}

	@Override
	public Pickeable clone(){
		return new BombPotion(posYPX, posXPX, widthPX, heightPX, manager);
	}

}
