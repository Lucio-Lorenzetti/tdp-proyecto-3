package PickeableElements;

import Elements.Element;

/**
*
* Pickeable Class.
* 
* Defines the applicable operations of a Pickeable element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Pickeable extends Element{

	
	public Pickeable(int posYPX, int posXPX, int width, int height) {
		this.posXPX = posXPX;
        this.posYPX = posYPX;
        this.widthPX = width;
        this.heightPX = height;
	}
	
	
	public abstract int consume();

	public abstract Pickeable clone();

	
}
