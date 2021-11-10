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
	
    protected int posXPX;
    protected int posYPX;
    protected int widthPX;
    protected int heightPX;
	
	protected GraphicEntity myGraphicEntity;	

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
     public  int getRow(){
         return posYPX;
     }

    /**
     * The column where the character is.
     * @return column.
     */
     public int getColumn(){
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

	 public boolean collidesWith(Element E) {
		boolean sameArea = false;
		 
		int limitThisHigher = posYPX;
		int limitThisLower  = posYPX + this.heightPX;
		int limitThisLeft = posXPX;
		int limitThisRight = posXPX + this.widthPX;
		
	    int limitEHigher = E.getRow();
		int limitELower  = E.getRow() + E.getHeight();
		int limitELeft = E.getColumn();
		int limitERight = E.getColumn() + E.getWidth();

		boolean EHigherInThis = (limitThisHigher <= limitEHigher) && (limitThisLower >= limitEHigher);
		boolean ELowerInThis = (limitThisHigher <= limitELower) && (limitThisLower >= limitELower);
		boolean ELeftInThis = (limitThisLeft <= limitELeft) && (limitThisRight >= limitELeft);
		boolean ERightInThis = (limitThisLeft <= limitERight) && (limitThisRight >= limitERight);

		
		
		sameArea = (EHigherInThis && ELeftInThis) || (EHigherInThis && ERightInThis)
                   || (ELowerInThis && ELeftInThis) || (ELowerInThis && ERightInThis);
		
		return sameArea;
	 }
	
}
