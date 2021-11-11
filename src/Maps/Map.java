package Maps;

import javax.swing.ImageIcon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

import CharacterElements.Role;
import GameLogic.Cell;
import GameLogic.Directions;
import GameLogic.Game;
import Images.ResourceManager;
import PickeableElements.BombPotion;
import PickeableElements.Fruit;
import PickeableElements.PacDot;
import PickeableElements.Pickeable;
import PickeableElements.PowerPellet;
import PickeableElements.SpeedPotion;

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
    
    protected Game myGame;
    protected static final int height = 22;
    protected static final int width = 22;
    protected Cell[][] cells;
    protected String route;

    /**
     * Creates and initializes Map.
     */
    public Map(Game g, int cellHeightPX, int cellWidthPX, String mapRoute){
   
    	myGame = g;
        cells = new Cell[height][width];
    
        int fruitScore = 50;
        
        ImageIcon[] cellImages = ResourceManager.getProvider().getTileImages();
    	
    	
    	Cell Wall = new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, cellImages[0]);
    	
    	Cell RoadEmpty = new Cell(0, 0, null, true, cellHeightPX, cellWidthPX, cellImages[1]);
    	
    	Cell RoadPacdot = new Cell(0, 0, new PacDot( 0, 0,cellWidthPX, cellWidthPX)  , true, cellHeightPX, cellWidthPX, cellImages[1]);
    	Cell RoadPowerPellet = new Cell(0, 0, new PowerPellet( 0, 0,cellWidthPX, cellWidthPX), true, cellHeightPX, cellWidthPX, cellImages[1]);
    	Cell RoadFruit = new Cell(0, 0, new Fruit( 0, 0,cellWidthPX, cellWidthPX, fruitScore), true, cellHeightPX, cellWidthPX, cellImages[1]);
    	Cell RoadBombPotion = new Cell( 0, 0, new BombPotion( 0, 0,cellWidthPX, cellWidthPX), true, cellHeightPX, cellWidthPX, cellImages[1]);
    	Cell RoadSpeedPotion = new Cell(0, 0, new SpeedPotion( 0, 0,cellWidthPX, cellWidthPX), true, cellHeightPX, cellWidthPX, cellImages[1]);
    	
    	
    	Cell GhostHome = new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, cellImages[2]);
    	
    	Cell LimitHorizontal = new Cell(0,0,null,false, cellHeightPX, cellWidthPX, cellImages[3]);
    	Cell LimitVertical = new Cell(0,0,null,false, cellHeightPX, cellWidthPX, cellImages[4]);
    	
    	
    	Cell RoadTeleport = new Cell(0, 0, null, true, cellHeightPX, cellWidthPX, cellImages[5]);
    			
    	try {
    		
    		File f = new File(mapRoute);    		
    		FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader (fr);
			
			String actualLine;
			
			int actualRow = 0;
			
			
			while ( (actualLine = br.readLine()) != null) {
				
				for(int col = 0; col < actualLine.length(); col++){
					

					if( actualLine.charAt(col) == 'L') {
						cells[actualRow][col] = LimitHorizontal.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'I') {
						cells[actualRow][col] = LimitVertical.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'W') {
						cells[actualRow][col] = Wall.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'F') {
						cells[actualRow][col] = RoadFruit.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'S') {
						cells[actualRow][col] = RoadSpeedPotion.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'B') {
						cells[actualRow][col] = RoadBombPotion.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'D') {
						cells[actualRow][col] = RoadPacdot.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'P') {
						cells[actualRow][col] = RoadPowerPellet.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'G') {
						cells[actualRow][col] = GhostHome.cloneInPosition(actualRow, col);
					}
					if( actualLine.charAt(col) == 'T') {
						cells[actualRow][col] = RoadTeleport.cloneInPosition(actualRow, col);
					}
                    if( actualLine.charAt(col) == 'E') {
						cells[actualRow][col] = RoadEmpty.cloneInPosition(actualRow, col);
					}
					
				}
				
				actualRow++;
				
			}			
			
			br.close();
			fr.close(); 
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
          
               
        
    }
    
    /**
    * Returns if the movement, depending on the direction, its possible.
    * @param posY to check.
    * @param posX to check.
    * @param direction to check.
    * @return true if its possible, false otherwise.
    */
    public boolean canMove( int posY, int posX, Object direction ){
    	
    	boolean result = true;

        if(direction == Directions.getLeft()) {
        	result = checkMovablePosition(posX - 1, posY);
        }
        if(direction == Directions.getRight()) {
        	result = checkMovablePosition(posX + 1, posY);
        }
        if(direction == Directions.getUp()) {
        	result = checkMovablePosition(posX, posY - 1);
        }
        if(direction == Directions.getDown()) {
        	result = checkMovablePosition(posX, posY + 1);
        }
        
        return result;
    
    }
    
    
    

    /**
    * Checks if right movement is possible.
    * @param row to check. 
    * @param col to check.
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveRight(int posY, int posX){
        boolean can = true;
       
        can = checkMovablePosition(posX + 1, posY);
        
        return can;
    }
    
    
    
    /**
    * Checks if left movement is possible.
    * @param row to check.
    * @param col to check
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveLeft(int posY, int posX){
        boolean can = true;
        
        can = checkMovablePosition(posX-1, posY);
        
        return can;
    }

    /**
    * Checks if up movement is possible.
    * @param row to check.
    * @param col to check
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveUp(int posY, int posX){
        boolean can = true;
        
        can = checkMovablePosition(posX, posY-1);
        
        return can;
    }
    /**
    * Checks if down movement is possible.
    * @param row to check.
    * @param col to check.
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveDown(int posY, int posX){
    	boolean can = true;
        
    	can = checkMovablePosition(posX, posY+1);
    	
        return can;
    }
    
    /**
     * Checks if the cell that contains the position posX posY is walkable.
     * @param posX position of the verification on the X axis.
     * @param posY position of the verification on the Y axis.
     * @return true if the cell is walkable, false if it is not.
     */
    private boolean checkMovablePosition(int posX, int posY) {
    	
    	boolean canMove = true;
    	
        
        canMove = getCellByPosition(posX, posY).getWalkable();
    	
        
    	return canMove;
    
    }


    private Cell getCellByPosition(int posX, int posY) {
    
    	int cellWidth = cells[0][0].getWidth();
        int cellHeight = cells[0][0].getHeight();
        
        /*
        int posCellX = posX - (posX % cellWidth);
        int posCellY = posY - (posY % cellHeight);
        
        int colCell = posCellX / cellWidth;
        int rowCell = posCellY / cellHeight;
        */
        
        int colCell = posX / cellWidth;
        int rowCell = posY / cellHeight;
        
        
        return cells[rowCell][colCell];    	
    	
    }
    

    public boolean checkIfInPath(int posX, int posY) {
    	
    	Cell obtainedCell = getCellByPosition(posX, posY);
    	
    	return obtainedCell.getPosX() == posX && obtainedCell.getPosY() == posY;
    	
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

    public boolean checkAllCollision(Role c) {
    	
    	
		
		
		return false;
	}
    
	public Pickeable checkPickeableCollision(Role c) {
		
		Pickeable result = null;
		
		LinkedList<Cell> cellList = new LinkedList<Cell>();
		
		Cell aux1 = getCellByPosition(c.getPosX(), c.getPosY());     	
		
        cellList.add(aux1);
		
		Cell aux2 = getCellByPosition(c.getPosX() + c.getWidth(), c.getPosY() + c.getHeight());
		
        if(aux1 != aux2) {
        	cellList.add(aux2);
        }

        for(Cell cellAux : cellList){
        	
        	if(cellAux.getPickup() != null && (c.collidesWith( cellAux.getPickup() ) || cellAux.getPickup().collidesWith( c ))) {
        		result = cellAux.getPickup();
        	}
        	 	
        }
        
		return result;
		
	}
	
	
	public void consumePickeable(Pickeable p) {
		
		Cell aux = getCellByPosition(p.getPosX(), p.getPosY());
		
		aux.setPickup(null);
		
		myGame.addPoints( p.consume() );
		
		myGame.updatePickupGraphic(aux);		//ACTUALIZAR SOLO PICKUP PARA EVITAR EFECTOS VISUALES RAROS EN LA CELDA
		
		
	}
	
	
}
