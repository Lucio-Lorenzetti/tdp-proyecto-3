package PickeableElements;

import GUI.GraphicEntity;
import Images.ResourceManager;

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

	public PowerPellet(int posYPX, int posXPX, int width, int height) {
		super(posYPX, posXPX, width, height, 100);
		
		myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[1] );
	}
	
	
	@Override
	public int consume() {
		return points;
	}

	@Override
	public Pickeable clone(){
		return new PowerPellet(posYPX, posXPX, widthPX, heightPX);
	}

}
