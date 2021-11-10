package GUI;
import javax.swing.ImageIcon;

/**
*
* GraphicEntity Class.
* 
* Defines the applicable operations of a GraphicEntity element.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class GraphicEntity {

	protected ImageIcon icon;
	int index;
	
	public GraphicEntity(ImageIcon icon) {
	
		this.icon = icon;
		
	}
	
	/**
	 * Retorna el atributo gr�fico.
	 * @return ImageIcon de la entidad gr�fica.
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
