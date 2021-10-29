package Elements;
import GUI.GraphicEntity;


/**
*
* Element Class.
* 
* Defines the applicable operations of an Element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Element {
	
	private GraphicEntity myGraphicEntity;	

	/**
     * Returns the GraphicEntity of the Element.
     * @return GraphicEntity of the Element.
     */
	public GraphicEntity getGraphicEntity() {
		return myGraphicEntity;
	}
	
	 /**
     * Set the GraphicEntity of the Element.
     * @param GraphicEntity to be setted.
     */
	public void setGraphicEntity(GraphicEntity GraphicEnt) {
		myGraphicEntity = GraphicEnt;
	}
	
}
