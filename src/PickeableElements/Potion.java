package PickeableElements;

import GUI.GraphicEntity;

/**
*
* Potion Class.
* 
* Defines the applicable operations of a Potion element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Potion extends Pickeable{

	public Potion(int posYPX, int posXPX, int width, int height,PickeableManager g, GraphicEntity graphicEntity) {
		super(posYPX, posXPX, width, height, 150, g, graphicEntity);
	}
	
}
