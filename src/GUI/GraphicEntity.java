package GUI;
import javax.swing.ImageIcon;

/**
*
* GraphicEntity Class.
* 
* Defines the applicable operations of a GraphicEntity element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class GraphicEntity {

	protected ImageIcon icon;
	int index;
	
	/**
	 * Creates and initializes a GraphicEntity.
	 * @param icon ImageIcon to be set as the GraphicEntity's icon.
	 */
	public GraphicEntity(ImageIcon icon) {
	
		this.icon = icon;
		
	}
	
	/**
	 * Returns the icon atribute.
	 * @return ImageIcon of the GraphicEntity.
	 */
	public ImageIcon getIcon(){
		return icon;
	}
	
	/**
	 * Sets the icon atribute of the GraphicEntity.
	 * @param newIcon new icon to set.
	 */
	public void setIcon(ImageIcon newIcon){
		icon = newIcon;
	}
	
	
}
