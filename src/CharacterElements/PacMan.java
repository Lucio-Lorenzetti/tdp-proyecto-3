package CharacterElements;
import Visitor.*;

/**
*
* Class PacMan.
* 
* Defines the applicable operations of a PacMan.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class PacMan extends Character{

    /**
    * Creates and initialize a PacMan;
    * @param row where the PacMan is created.
    * @param col where the PacMan is created.
    */
    public PacMan(int col, int row){
        super(col, row);
        myVisitor = new VisitorPacMan(this);
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
    * Makes the character die..
    */
    public  void die(){

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
    /**
    * Accept the visitor of another Character passed by parameter
    */
    public  void accept(Visitor v){
        myVisitor.visitPacMan(this);
    }

}
