package PickeableElements;

import GUI.GraphicEntity;
import Images.ResourceManager;

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
	
	public PacDot(int posYPX, int posXPX, int width, int height, PickeableManager g) {
		
		super(posYPX, posXPX, width, height, 10, g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[0] ));
		
		
	}
	
	public PacDot(PickeableManager g) {
		super(0,0,0,0,10,g, new GraphicEntity( ResourceManager.getProvider().getPickeableImages()[0] ));
	}

	@Override
	public int consume() {
		return points;
	}
	
	@Override
	public Pickeable clone() {
		return new PacDot(posYPX, posXPX, widthPX, heightPX,manager);
	}

}
