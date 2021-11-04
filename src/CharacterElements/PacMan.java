package CharacterElements;
import GUI.GraphicEntity;
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
    * @param posX where the PacMan is created.
    * @param posY where the PacMan is created.
    * @param width of the PacMan.
    * @param heigth of the PacMan.
    */
    public PacMan(int posY, int posX, int width, int height){
    	
        super(posY, posX, width, height);
        
        
        myVisitor = new VisitorPacMan(this);
        
        
        myGraphicEntity = new GraphicEntity(8);
        
    }

	
    
    @Override
    public void doOnMovement() {

    }
    
    /**
    * Makes the character die..
    */
    public  void die(){

    }
    
    

    
    /**
    * Accept the visitor of another Character passed by parameter
    */
    public  void accept(Visitor v){
        myVisitor.visitPacMan(this);
    }

}
