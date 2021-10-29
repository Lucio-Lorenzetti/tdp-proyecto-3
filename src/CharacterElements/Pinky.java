package CharacterElements;
import Visitor.*;

/**
*
* Class Pinky.
* 
* Defines the applicable operations of a Pinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Pinky extends Ghost{
    /**
    * Creates and initialize a Pinky;
    * @param row where the Pinky is created.
    * @param col where the Pinky is created.
    */
    public Pinky(int col, int row, boolean d, boolean m){
        super(col, row, d, m);
        myVisitor = new VisitorPinky(this);
    }

    /**
    * Accept the visitor of another Character passed by parameter
    */
    public  void accept(Visitor v){
        myVisitor.visitPinky(this);
    }
}
