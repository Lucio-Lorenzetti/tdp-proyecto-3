package CharacterElements;
import Visitor.*;
/**
*
* Class Clyde.
* 
* Defines the applicable operations of a Clyde.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Clyde extends Ghost{
    /**
    * Creates and initialize a Clyde;
    * @param row where the Clyde is created.
    * @param col where the Clyde is created.
    */
    public Clyde(int col, int row, boolean d, boolean m){
        super(col, row, d, m);
        myVisitor = new VisitorClyde(this);
    }

    
    /**
    * Accept the visitor of another Character passed by parameter
    */
    public  void accept(Visitor v){
        myVisitor.visitClyde(this);
    }
}
