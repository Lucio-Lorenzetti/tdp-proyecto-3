package GameLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
*
* Class ScoreBoard.
* 
* Defines the applicable operations of a ScoreBoard.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class ScoreBoard extends PriorityQueue<Player> implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String filename;

    /**
    * Creates and initialize a scoreBoard
    */
    public ScoreBoard(int cantPlayers, Comparator<Player> c){
    	super(cantPlayers, c);
    	filename = "src/scoreboardInformation.txt";
    }
    

    public void saveScores() {
        try {
        	
        	
            FileWriter myWriter = new FileWriter(filename);
            
            Player aux;
            
            while(!isEmpty()) {
            
            	aux = this.remove();
            	
            	//aux.setName(aux.getName().replace("\n", ""));
            	
	            myWriter.write(aux.getName() + "\n");
	            myWriter.write(aux.getPoints() + "\n");

            }
            
            
            myWriter.close();
            
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    public void loadScores() {
    	try {
    	      File myObj = new File(filename);
    	      Scanner myReader = new Scanner(myObj);
    	      
    	      String name;
    	      int score;
    	      
    	      while (myReader.hasNextLine()) {
    	        
    	    	 name = myReader.nextLine();
    	    	 score = Integer.parseInt(myReader.nextLine()) ;
    	    	 this.add(new Player(name, score));
    	    	 
    	      }
    	      
    	      myReader.close();
    	      
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }
    
}
