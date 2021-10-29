package CharacterElements;
import Visitor.*;
/**
*
* Class Blinky.
* 
* Defines the applicable operations of a Blinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Blinky extends Ghost{
    /**
    * Creates and initialize a Blinky;
    * @param row where the Blinky is created.
    * @param col where the Blinky is created.
    */
    public Blinky(int col, int row, boolean d, boolean m){
        super(col, row, d, m);
        myVisitor = new VisitorBlinky(this);
    }

    /**
    * Accept the visitor of another Character passed by parameter
    */
    public  void accept(Visitor v){
        myVisitor.visitBlinky(this);
    }
}
