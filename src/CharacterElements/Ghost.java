package CharacterElements;

/**
*
* Ghost Class.
* 
* Defines the applicable operations of a Ghost element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Ghost extends Role {
    protected boolean dead;
    protected boolean moving;
    /**
    * Creates and initialize a Ghost;
    * @param row where the Ghost is created.
    * @param col where the Ghost is created.
    */
    public Ghost(int col, int row, boolean d, boolean m){
        
    	super(col, row, 10, 10);
        this.dead = d;
        this.moving = m;

        //myVisitor = new visitorGhost(this);
    }
    
    @Override
    public void doOnMovement() {

    }
    
    /**
    * The row where the Chacarter is.
    * @return row.
    */
    public  int getPosY(){
        return 0;
    }

    /**
    * The column where the Chacarter is.
    * @return column.
    */
    public int getPosX(){
        return 0;
    }
}
