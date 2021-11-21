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
	
	public Fruit(int posYPX, int posXPX, int width, int height, int score,  PickeableManager g) {
		super(posYPX, posXPX, width, height, score, g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[2] ));
		
	}
	
	public Fruit(int score, PickeableManager g) {
		super(0,0,0,0, score,g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[2] ));
		
	}
	
	
	@Override
	public int consume() {
		return points;
	}
	
	@Override
	public Pickeable clone() {
		return new Fruit(posYPX, posXPX, widthPX, heightPX, points,manager);
	}

}
