package Maps;

import javax.swing.ImageIcon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.HashMap;

import CharacterElements.Role;
import GameLogic.Cell;
import GameLogic.Directions;
import GameLogic.Game;
import Images.ResourceManager;
import PickeableElements.BombPotion;
import PickeableElements.Fruit;
import PickeableElements.PacDot;
import PickeableElements.Pickeable;
import PickeableElements.PickeableManager;
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
	protected PickeableManager manager;
	protected LinkedList<Cell> ghostHomes;

	

    /**
     * Creates and initializes Map.
     */
    public Map(Game g, int cellHeightPX, int cellWidthPX, String mapRoute, String pickeableRoute, String characterRoute){
   
    	myGame = g;
        cells = new Cell[height][width];
    
        int fruitScore = 50;

		manager = new PickeableManager(myGame);
		
		ghostHomes = new LinkedList<Cell>();
		
		
		HashMap<Character, Cell> cellSelection = new HashMap<Character, Cell>();
		HashMap<Character, Pickeable> pickeableSelection = new HashMap<Character, Pickeable>();
		HashMap<Character, Role> roleSelection = new HashMap<Character, Role>();
		
		
        
        ImageIcon[] cellImages = ResourceManager.getProvider().getRoadImages();
    	
        
        ImageIcon[] roadImages = ResourceManager.getProvider().getRoadImages();

        ImageIcon[] wallImages = ResourceManager.getProvider().getWallImages();
        
        ImageIcon[] ghostHomeImages = ResourceManager.getProvider().getGhostHomeImages();
        
        
		//WALL AND LIMITS
		cellSelection.put('■', new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, wallImages[0]));
        cellSelection.put('▌', new Cell(0, 0,null,false, cellHeightPX, cellWidthPX, wallImages[1]));
		cellSelection.put('▬', new Cell(0, 0,null,false, cellHeightPX, cellWidthPX, wallImages[2]));
		cellSelection.put('╓', new Cell(0, 0,null,false, cellHeightPX, cellWidthPX, wallImages[2]));
		cellSelection.put('╙', new Cell(0, 0,null,false, cellHeightPX, cellWidthPX, wallImages[2]));
		cellSelection.put('╖', new Cell(0, 0,null,false, cellHeightPX, cellWidthPX, wallImages[2]));
		cellSelection.put('╜', new Cell(0, 0,null,false, cellHeightPX, cellWidthPX, wallImages[2]));	
    	
    	//GHOST HOME
		cellSelection.put('┉', new Cell(0, 0, null, true, cellHeightPX, cellWidthPX, ghostHomeImages[0]));
		cellSelection.put('┌', new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, ghostHomeImages[1]));
		cellSelection.put('└', new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, ghostHomeImages[2]));
		cellSelection.put('┐', new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, ghostHomeImages[3]));
		cellSelection.put('┘', new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, ghostHomeImages[4]));
		cellSelection.put('━', new Cell(0, 0, null, false, cellHeightPX, cellWidthPX, ghostHomeImages[0]));

		//ROAD
		
		cellSelection.put('═', new Cell(0, 0, null, true, cellHeightPX, cellWidthPX, roadImages[0]));
		cellSelection.put('║', new Cell(0, 0, null, true, cellHeightPX, cellWidthPX, roadImages[1]));
		
        cellSelection.put('╔', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[2]));
        cellSelection.put('╚', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[3]));        
        cellSelection.put('╗', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[4]));
        cellSelection.put('╝', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[5]));
         
       	cellSelection.put('╦', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[6]));
        cellSelection.put('╩', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[7]));
        cellSelection.put('╠', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[8]));
        cellSelection.put('╣', new Cell(0, 0, null, true, true, cellHeightPX, cellWidthPX, roadImages[9]));
		
		cellSelection.put('╬', new Cell(0,0, null, true, true, cellHeightPX, cellWidthPX, roadImages[10]));
		
		//cellSelection.put('T', new Cell(0,0, null, true, cellHeightPX, cellWidthPX, cellImages[11]));

		//PIKEABLES
        
        pickeableSelection.put('P', new PacDot(manager));
        pickeableSelection.put('B', new BombPotion(manager));
        pickeableSelection.put('E', null);
        pickeableSelection.put('S', new SpeedPotion(manager));
        pickeableSelection.put('F', new Fruit(fruitScore, manager));
        pickeableSelection.put('O', new PowerPellet(manager));
        
        

    	/*
    	PIKEABLES
	    	P --> PACDOTS
	    	B --> BOMBA
	    	E --> EMPTY
	    	S --> SPEED
	    	F --> FRUIT
	    	֎ --> POWERPELLET    	
    	ROLES
    		E --> EMPTY
    		P --> PINKY
    		I --> INKY
    		C --> CLYDE
    		B --> BLINKY
    		M --> PACMAN
    	*/
    			
    	try {
    		
    		File f = new File(mapRoute);    		
    		FileReader fr = new FileReader(f, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader (fr);
			
			String actualLine;
			String actL;
			
			int actualRow = 0;
			
			
			while ( (actL = br.readLine()) != null) {
			
				ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(actL);

				actualLine = new String(byteBuffer.array(), StandardCharsets.UTF_8);
				
				
				for(int col = 0; col < actualLine.length(); col++){
					
					//System.out.println(actualLine.charAt(col));
			
					if(cellSelection.get( actualLine.charAt(col) ) != null) {
						cells[actualRow][col] = cellSelection.get( actualLine.charAt(col) ).cloneInPosition(actualRow, col);
					}
					
					if(actualLine.charAt(col) == '┉'){
                        ghostHomes.add( cells[actualRow][col] );
                    }
					
					
				}
				
				actualRow++;
				
			}			
			
			br.close();
			fr.close(); 
			
			
			f = new File(pickeableRoute);
			fr = new FileReader(f);
			br = new BufferedReader (fr);
			
			actualLine = "";
			actL = "";
			
			actualRow = 0;
			
			
			while ( (actL = br.readLine()) != null) {
			
				ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(actL);

				actualLine = new String(byteBuffer.array(), StandardCharsets.UTF_8);	
				
				for(int col = 0; col < actualLine.length(); col++){
					
					if(pickeableSelection.get( actualLine.charAt(col) ) != null) {
						
						cells[actualRow][col].setPickeable( pickeableSelection.get( actualLine.charAt(col) ).clone() );
						
						
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
    

    /**
     * Returns if the given position is the top left corner of a cell.
     * @param posX X coordinate of the position.
     * @param posY Y coordinate of the position.
     * @return true if the position is the corner of a cell, false if not.
     */
    public boolean checkIfInPath(int posX, int posY) {
    	
    	Cell obtainedCell = getCellByPosition(posX, posY);
    	
    	return obtainedCell.getPosX() == posX && obtainedCell.getPosY() == posY;
    	
    }
    
    /**
     * Returns if the given position is part of an intersection.
     * @param posX X coordinate of the position.
     * @param posY Y coordinate of the position.
     * @return true if the position is in an intersection, false if not.
     */
    public boolean checkIfInIntersection(int posX, int posY) {
    	
    	Cell obtainedCell = getCellByPosition(posX, posY);
    	
    	return obtainedCell.isIntersection();
    	
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

		//System.out.println("CONSUMIDO");
		
	}
	
	
	public HashMap<Object,Cell> getAdjacentCellsByPX(int posX, int posY){
		
		HashMap<Object,Cell> result;
		
		result = getAdjacentCells( getCellByPosition(posX, posY) );
		
		return result;
		
	}
	
	public void explode(int centerX, int centerY, int sizeX, int sizeY) {
		
		int topLeftX = getCellByPosition(centerX, centerY).getColumn() - sizeX;
		int topLeftY = getCellByPosition(centerX, centerY).getRow() - sizeY;

		int bottomRightX = topLeftX + ( (sizeX * 2) + 1);
		int bottomRightY = topLeftY + ( (sizeY * 2) + 1);
		
		
		
		Cell aux = null;
		
		/*
		System.out.println(centerX + " " + centerY);
		System.out.println(sizeX + " " + sizeY);
		System.out.println(topLeftX + " " + topLeftY);
		
		System.out.println(ghostHomes.size());
		*/
		
		for(int i = topLeftX; i < bottomRightX ; i++) {
		
			
			
			for(int k = topLeftY; k < bottomRightY; k++) {

				aux = cells[k][i];
	
				
				if(!isGhostHome(aux) && !isBorder(aux) ) {

					if(aux.getWalkable()) {
						aux.getGraphicEntity().setIcon(ResourceManager.getProvider().getRoadImages()[11]);
					} else {
						aux.getGraphicEntity().setIcon(ResourceManager.getProvider().getWallImages()[7]);
					}
				
					myGame.updateCellGraphic(aux);
					
				}
				
				
				
			}
			
		}
		
	}
	
	
	public boolean isBorder(Cell c) {
		
		boolean result = false;
		
		int posX = c.getColumn();
		int posY = c.getRow();
		
		if(posX == 0 || posX == width-1 || posY == 0 || posY == height-1) {
			result = true;
		}
		
		
		return result;
		
	}
	
	public boolean isGhostHome(Cell c){
		boolean result = false;
		for(Cell gh : ghostHomes){
			/*
			System.out.println("gh: Fila "+gh.getRow()+"Columna "+gh.getColumn());
			System.out.println("c: Fila "+gh.getRow()+"Columna "+gh.getColumn());
			*/
			if(c == gh) {
				result = true;
				return result;		
			}	
		}
		//System.out.println("Es una casa de fantasma: "+result);
		return result;
	}
	/**
	 * Returns a HashMap that contains the adjacent cells with a direction key;
	 * @param c
	 * @return
	 */
	public HashMap<Object,Cell> getAdjacentCells(Cell c){
		
		HashMap<Object,Cell> result = new HashMap<Object,Cell>();
		
		
		if(c.getColumn() < width-1 && c.getWalkable()) 	result.put(Directions.getRight(), cells[c.getRow()][c.getColumn()+1].clone());
		if(c.getColumn() > 0 && c.getWalkable()) 		result.put(Directions.getLeft(), cells[c.getRow()][c.getColumn()-1].clone());
		if(c.getRow() < height-1 && c.getWalkable()) 	result.put(Directions.getUp(), cells[c.getRow()-1][c.getColumn()].clone());
		if(c.getRow() > 0    && c.getWalkable()) 		result.put(Directions.getDown(), cells[c.getRow()+1][c.getColumn()].clone());
		
		
		return result;
	}
	
	public LinkedList<Cell> getGhostHome(){
       LinkedList<Cell> ghList = new LinkedList<Cell>();
       for(Cell c: ghostHomes){
           ghList.add(c.clone());
       }
       return ghList;
    }


	
	
	
}
