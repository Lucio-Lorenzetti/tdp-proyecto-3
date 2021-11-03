package PickeableElements;

import GUI.GraphicEntity;

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

	public SpeedPotion() {
		super();
		
		myGraphicEntity = new GraphicEntity(5);
	}
	
	@Override
	public void consume() {
		
	}

	@Override
	public Pickeable clone(){
		return new SpeedPotion();
	}

}
