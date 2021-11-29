package Elements;
import GUI.GraphicEntity;


/**
*
* Element Class.
* 
* Defines the applicable operations of an Element.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Element {
	
    protected int posXPX;
    protected int posYPX;
    protected int widthPX;
    protected int heightPX;
	
	protected GraphicEntity myGraphicEntity;	

	
	public Element(int posYPX, int posXPX, int width, int height, GraphicEntity graphicEntity) {
		
		this.posYPX = posYPX;
		this.posXPX = posXPX;
		widthPX = width;
		heightPX= height;
		
		myGraphicEntity = graphicEntity;
		
	}
	
	/**
   	* Check if the element called by message collides with the element on param.
   	* @param E element to check the colision.
    * @return true if both elements collides, false otherwise.
    */
	 public boolean collidesWith(Element E) {
		boolean sameArea = false;
		 
		int limitThisHigher = posYPX;
		int limitThisLower  = posYPX + this.heightPX;
		int limitThisLeft = posXPX;
		int limitThisRight = posXPX + this.widthPX;
		
	    int limitEHigher = E.getPosY();
		int limitELower  = E.getPosY() + E.getHeight();
		int limitELeft = E.getPosX();
		int limitERight = E.getPosX() + E.getWidth();

		
		return limitThisLeft <= limitERight && limitThisRight >= limitELeft 
				&& limitThisHigher <= limitELower && limitThisLower >= limitEHigher;
	 }
	
	
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
		
		
      /**
     * The row where the Character is.
     * @return row.
     */
     public  int getPosY(){
         return posYPX;
     }

    /**
     * The column where the character is.
     * @return column.
     */
     public int getPosX(){
         return posXPX;
     }
     
     /**
     * Return the width of the character.
     * @return width of character.
     */
     public int getWidth() {
    	 return widthPX;
     }
     
     /**
     * Return the height of the character.
     * @return height of character.
     */
	 public int getHeight() {
		 return heightPX;
	 }

      /**
     * Set the row where the Character is.
     * @param r where the element will be setted.
     */
     public void setPosY(int r){
         posYPX = r;
     }

    /**
     * Set the column where the character is.
     * @param c where the element will be setted.
     */
     public void setPosX(int c){
        posXPX = c;
     }
     
     /**
     * Set the width of the character.
     * @param w width of the element.
     */
     public void setWidth(int w) {
    	 widthPX = w;
     }
     
     /**
     * Set the height of the character.
     * @param h height of the element.
     */
	 public void setHeight(int h) {
		 heightPX = h;
	 }
	 
	 public int[][] calculateCorners() {
	 
		 int[][] corners = new int[2][2];
		 
		 corners[0] = getTopLeftCorner();
		 corners[1] = getBottomRightCorner();
		 
		 return corners;
	 }
	 
	 protected int[] getTopLeftCorner() {
		 int[] corner = new int[2];
		 
		 corner[0] = posXPX;
		 corner[1] = posYPX;

		 return corner;
		 
	 }
	 
	 protected int[] getBottomRightCorner() {
		 int[] corner = new int[2];
		 
		 corner[0] = posXPX + widthPX;
		 corner[1] = posYPX + heightPX;

		 return corner;
	 }
    
	
}
