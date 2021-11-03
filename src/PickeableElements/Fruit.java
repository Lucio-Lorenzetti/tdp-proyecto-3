package PickeableElements;

import GUI.GraphicEntity;

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

	public Fruit() {
		super();
		
		myGraphicEntity = new GraphicEntity(4);
	}
	
	
	@Override
	public void consume() {

	}
	
	@Override
	public Pickeable clone() {
		return new Fruit();
	}

}
