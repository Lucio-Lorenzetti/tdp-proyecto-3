package CharacterElements;
import Visitor.*;
/**
*
* Class Inky.
* 
* Defines the applicable operations of a Inky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Inky extends Ghost{
    /**
    * Creates and initialize a Inky;
    * @param row where the Inky is created.
    * @param col where the Inky is created.
    */
    public Inky(int col, int row, boolean d, boolean m){
        super(col, row, d, m);
        myVisitor = new VisitorInky(this);
    }

    
    public  void accept(Visitor v){
        myVisitor.visitInky(this);
    }
     
}