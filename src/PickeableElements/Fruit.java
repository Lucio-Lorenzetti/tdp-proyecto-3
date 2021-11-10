package PickeableElements;

import GUI.GraphicEntity;
import Images.ResourceManager;

/**
*
* Fruit Class.
* 
* Defines the applicable operations of a Fruit element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Fruit extends Pickeable{

	public Fruit(int posYPX, int posXPX, int width, int height) {
		super(posYPX, posXPX, width, height);
		
		myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[2] );
	}
	
	
	@Override
	public int consume() {
		return 0;
	}
	
	@Override
	public Pickeable clone() {
		return new Fruit(posYPX, posXPX, widthPX, heightPX);
	}

}
