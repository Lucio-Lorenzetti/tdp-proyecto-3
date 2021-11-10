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
	
	public GraphicEntity(ImageIcon icon) {
	
		this.icon = icon;
		
	}
	
	/**
	 * Retorna el atributo grï¿½fico.
	 * @return ImageIcon de la entidad grï¿½fica.
	 */
	public ImageIcon getIcon(){
		return icon;
	}
	
	/**
	 * Setea el atributo grafico de la entidad grafica.
	 * @param nuevoGrafico nuevo grafico a establecer
	 */
	public void setIcon(ImageIcon nuevoGrafico){
		icon = nuevoGrafico;
	}
	
	
}
