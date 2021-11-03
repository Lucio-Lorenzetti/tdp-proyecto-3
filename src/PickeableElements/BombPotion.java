package PickeableElements;

import GUI.GraphicEntity;

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

	
	public BombPotion() {
		super();
		
		myGraphicEntity = new GraphicEntity(6);
	}
	
	@Override
	public void consume() {
		
	}

	@Override
	public Pickeable clone(){
		return new BombPotion();
	}

}
