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

	protected String[] rutasImagenes;
	protected ImageIcon grafico;
	int color;
	
	public GraphicEntity(int colour) {
		
		color = colour;
		
		rutasImagenes = new String[9];
		
		rutasImagenes[0] = "/Imagenes/BORDE.png";
		rutasImagenes[1] = "/Imagenes/FONDO.png";
		rutasImagenes[2] = "/Imagenes/cuadradoRojo.png";
		rutasImagenes[3] = "/Imagenes/cuadradoVerde.png";
		rutasImagenes[4] = "/Imagenes/cuadradoAzul.png";
		rutasImagenes[5] = "/Imagenes/cuadradoVioleta.png";
		rutasImagenes[6] = "/Imagenes/cuadradoNaranja.png";
		rutasImagenes[7] = "/Imagenes/cuadradoCeleste.png";
		rutasImagenes[8] = "/Imagenes/cuadradoAmarillo.png";
		
		grafico = new ImageIcon(this.getClass().getResource(rutasImagenes[color]));
		
		this.actualizar(color);
	}
	
	/**
	 * 
	 * Updates the graphic entity.
	 * 
	 * @param indice indica el indice de la nueva imagen a utilizar
	 * @return
	 */
	public void actualizar(int indice){
		
		if(indice < rutasImagenes.length) {
			
			ImageIcon imagen = new ImageIcon(this.getClass().getResource(rutasImagenes[indice]));
			
			this.grafico.setImage(imagen.getImage());
			
			color = indice;
			
		}

	}
	
	/**
	 * Retorna el atributo grï¿½fico.
	 * @return ImageIcon de la entidad grï¿½fica.
	 */
	public String[] getRutasImagenes(){
		return rutasImagenes;
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
	public int getColor() {
		return color;
	}
	
	
	/**
	 * Setea las rutas de imï¿½genes posibles.
	 * @param nuevasRutas Arreglo de strings que contenga las nuevas rutas.
	 */
	public void setRutasImagenes(String[] nuevasRutas){
		rutasImagenes = nuevasRutas;
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
	public void setColor(int nuevoColor) {
		color = nuevoColor;
	}
	
}
