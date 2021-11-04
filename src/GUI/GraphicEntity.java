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

	protected String[] imageRoute;
	protected ImageIcon grafico;
	int index;
	
	public GraphicEntity(int index) {
		
		imageRoute = new String[9];
		
		imageRoute[0] = "/Images/road.png";
		imageRoute[1] = "/Images/wall.png";
		imageRoute[2] = "/Images/pacDot.png";
		imageRoute[3] = "/Images/powerPellet.png";
		imageRoute[4] = "/Images/fruit.png";
		imageRoute[5] = "/Images/speedPotion.png";
		imageRoute[6] = "/Images/bombPotion.png";
		imageRoute[7] = "/Images/ghostHome.png";
		imageRoute[8] = "/Images/sprites1.png";
		
		grafico = new ImageIcon( this.getClass().getResource(imageRoute[this.index]) );
		
		this.index = index;
		
		this.update(index);
		
	}
	
	/**
	 * 
	 * Updates the graphic entity.
	 * 
	 * @param indice indica el indice de la nueva imagen a utilizar
	 * @return
	 */
	public void update(int indice){
		
		if(indice < imageRoute.length) {
			
			ImageIcon imagen = new ImageIcon(this.getClass().getResource(imageRoute[indice]));
			
			this.grafico.setImage(imagen.getImage());
			
		}

	}
	
	/**
	 * Retorna el atributo grï¿½fico.
	 * @return ImageIcon de la entidad grï¿½fica.
	 */
	public String[] getRutasImagenes(){
		return imageRoute;
	}
	
	/**
	 * Retorna el atributo grï¿½fico.
	 * @return ImageIcon de la entidad grï¿½fica.
	 */
	public ImageIcon getGrafico(){
		return grafico;
	}
	
	/**
	 * Retorna el atributo color.
	 * @return int que representa el color de la entidad grï¿½fica.
	 */
	public int getIndex() {
		return index;
	}
	
	
	/**
	 * Setea las rutas de imï¿½genes posibles.
	 * @param nuevasRutas Arreglo de strings que contenga las nuevas rutas.
	 */
	public void setRutasImagenes(String[] nuevasRutas){
		imageRoute = nuevasRutas;
	}
	
	/**
	 * Setea el atributo grafico de la entidad grafica.
	 * @param nuevoGrafico nuevo grafico a establecer
	 */
	public void setGrafico(ImageIcon nuevoGrafico){
		grafico = nuevoGrafico;
	}
	
	/**
	 * Setea el atributo color de la entidad grafica.
	 * @param nuevoColor
	 */
	public void setIndex(int newIndex) {
		index = newIndex;
	}
	
}
