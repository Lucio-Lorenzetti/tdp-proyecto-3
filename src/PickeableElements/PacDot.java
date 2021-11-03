package PickeableElements;

import GUI.GraphicEntity;

/**
*
* PacDot Class.
* 
* Defines the applicable operations of a PacDot element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class PacDot extends Pickeable {
	
	public PacDot() {
		super();
		
		myGraphicEntity = new GraphicEntity(2);
	}

	@Override
	public void consume() {
		
	}
	
	@Override
	public Pickeable clone() {
		return new PacDot();
	}

}
