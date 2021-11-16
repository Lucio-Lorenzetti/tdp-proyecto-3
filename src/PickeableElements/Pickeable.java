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

	
	protected int points;
	
	public Pickeable(int posYPX, int posXPX, int width, int height, int score) {
		this.posXPX = posXPX;
        this.posYPX = posYPX;
        this.widthPX = width;
        this.heightPX = height;
	
        points = score;
	}
	
	
	public abstract int consume();

	public abstract Pickeable clone();

	
	public Pickeable cloneInPosition(int posX, int posY, int width, int height) {
		
		Pickeable result = this.clone();
		
		result.setWidth(width);
		result.setHeight(height);
		result.setPosY(posY);
		result.setPosX(posX); 
		
		
		
		return null;
		
	}
	
	
}
