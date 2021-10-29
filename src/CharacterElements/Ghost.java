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
public abstract class Ghost extends Character {
    protected boolean dead;
    protected boolean moving;
    /**
    * Creates and initialize a Ghost;
    * @param row where the Ghost is created.
    * @param col where the Ghost is created.
    */
    public Ghost(int col, int row, boolean d, boolean m){
        super(col, row);
        this.dead = d;
        this.moving = m;

        //myVisitor = new visitorGhost(this);
    }
    
    /**
    * Moves the character up.
    */
    public  void moveUp(){

    }
    
    /**
    * Moves the character down.
    */
     public  void moveDown(){

     }
    
    /**
    * Moves the character left.
    */
     public  void moveLeft(){

     }
    
    /**
    * Moves the character right.
    */
    public  void moveRight(){

    } 
    
    /**
    * The row where the Chacarter is.
    * @return row.
    */
    public  int getRow(){
        return 0;
    }

    /**
    * The column where the Chacarter is.
    * @return column.
    */
    public int getColumn(){
        return 0;
    }
}
