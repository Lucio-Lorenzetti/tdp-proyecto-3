package GameLogic;

/**
 *
 * Class Map.
 * 
 * Defines the applicable operations of a Map.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class Map {
    
    protected Game game;
    protected static final int height = 20;
    protected static final int width = 20;
    protected Cell[][] cells;


    /**
     * Creates and initializes Map.
     */
    public Map(Game g){
   
    	game = g;
        cells = new Cell[height][width];
    
    
    }

    /**
    * Checks if right movement is possible.
    * @param row to check. 
    * @param col to check.
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveRight(int row, int col){
        return false;
    }
    
    /**
    * Checks if left movement is possible.
    * @param row to check.
    * @param col to check
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveLeft(int row, int col){
        return true;
    }

    /**
    * Checks if up movement is possible.
    * @param row to check.
    * @param col to check
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveUp(int row, int col){
        return true;
    }
    /**
    * Checks if down movement is possible.
    * @param row to check.
    * @param col to check.
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveDown(int row, int col){
    	
    	
    	
        return true;
    }
    
    /**
    * Return the cell located to the column and row passed by parameter.
    * @param row
    * @param col
    * @return the cell that it's called searched by it's position.
    */
    public Cell getCell(int row, int col){
        return cells[row][col];        
    }
    
    /**
     * Sets the cell located to the column and row passed by parameter.
     * @param row
     * @param col
     * @return the cell that it's called searched by it's position.
     */
    public void setCell(Cell cell) {
    	
    }
    
    
    /**
    * Return the Map height in cells.
    */
    public int getHeight() {
    	return height;
    }
    
    
    /**
     * Return the Map width in cells.
     */
    public int getWidth() {
    	return width;
    }
    
}
