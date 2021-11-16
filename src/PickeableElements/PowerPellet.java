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

	public PowerPellet(int posYPX, int posXPX, int width, int height, PickeableManager g) {
		super(posYPX, posXPX, width, height, 100, g);
		
		myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[1] );
	}
	
	public PowerPellet(PickeableManager g) {
		super(0,0,0,0,100,g);
		myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[1] );
	}

	
	@Override
	public int consume() {
		manager.powerPelletEffect();
		return points;
	}

	@Override
	public Pickeable clone(){
		return new PowerPellet(posYPX, posXPX, widthPX, heightPX, manager);
	}

}
