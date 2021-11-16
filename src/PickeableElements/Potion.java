package PickeableElements;

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

	public Potion(int posYPX, int posXPX, int width, int height,PickeableManager g) {
		super(posYPX, posXPX, width, height, 150, g);
	}
	
}
