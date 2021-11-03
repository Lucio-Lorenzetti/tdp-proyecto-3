package PickeableElements;

import GUI.GraphicEntity;

/**
*
* PowerPellet Class.
* 
* Defines the applicable operations of a PowerPellet element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class PowerPellet extends Pickeable {

	public PowerPellet() {
		super();
		
		myGraphicEntity = new GraphicEntity(3);
	}
	
	
	@Override
	public void consume() {
		
	}

	@Override
	public Pickeable clone(){
		return new PowerPellet();
	}

}
