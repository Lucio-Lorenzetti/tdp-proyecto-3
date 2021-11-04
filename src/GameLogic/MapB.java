package GameLogic;

import PickeableElements.*;

/**
 *
 * Class Map.
 * 
 * Defines the applicable operations of a Map.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class MapB extends Map {

	/**
	 * Creates and initializes Map.
	 */
	public MapB(Game g, int cellHeightPX, int cellWidthPX) {

		super(g);

		Cell RoadPacdot = new Cell(0, 0, new PacDot(), true, 0, cellHeightPX, cellWidthPX);
    	Cell RoadPowerPellet = new Cell(0, 0, new PowerPellet(), true, 0, cellHeightPX, cellWidthPX);
    	Cell RoadFruit = new Cell(0, 0, new Fruit(), true, 0, cellHeightPX, cellWidthPX);
    	Cell RoadBombPotion = new Cell(0, 0, new BombPotion(), true, 0, cellHeightPX, cellWidthPX);
    	Cell RoadSpeedPotion = new Cell(0, 0, new SpeedPotion(), true, 0, cellHeightPX, cellWidthPX);
    	
    	Cell RoadTeleport = new Cell(0, 0, null, true, 0, cellHeightPX, cellWidthPX);
    	
    	Cell RoadEmpty = new Cell(0, 0, null, true, 0, cellHeightPX, cellWidthPX);
    	
    	Cell GhostHome = new Cell(0, 0, null, false, 7, cellHeightPX, cellWidthPX);
    	
    	Cell Wall = new Cell(0, 0, null, false, 1, cellHeightPX, cellWidthPX);

    	int counterRow = 0;
    	int counterCol = 0;

		/*Column 	 1*/
		cells[0][0] = Wall.cloneInPosition(counterRow++, counterCol);
    	cells[1][0] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][0] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[3][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][0] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][0] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[12][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][0] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][0] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[18][0] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][0] = Wall.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;

		/*Column 2*/
		cells[0][1] = Wall.cloneInPosition(counterRow++, counterCol);
    	cells[1][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[3][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[10][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[13][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][1] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[18][1] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][1] = Wall.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;

		/*Column 3*/
		cells[0][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[2][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][2] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[6][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][2] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[19][2] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 4*/
		cells[0][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][3] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][3] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][3] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[7][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][3] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][3] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][3] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][3] = RoadPacdot.cloneInPosition(counterRow++, counterCol);

		
		counterRow = 0;
		counterCol++;
		
		/*Column 5*/
		cells[0][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][4] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][4] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][4] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][4] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][4] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][4] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][4] = RoadPacdot.cloneInPosition(counterRow++, counterCol);

		counterRow = 0;
		counterCol++;
		
		/*Column 6*/
		cells[0][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][5] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][5] = Wall.cloneInPosition(counterRow++, counterCol);	
		cells[6][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][5] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[9][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][5] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[12][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][5] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[15][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][5] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][5] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 7*/
		cells[0][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][6] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][6] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][6] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[7][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][6] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][6] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][6] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][6] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 8*/
		cells[0][7] = RoadTeleport.cloneInPosition(counterRow++, counterCol); 
		cells[1][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[2][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[10][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[13][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][7] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][7] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[19][7] = RoadTeleport.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 9*/
		cells[0][8] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[1][8] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[2][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][8] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][8] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[19][8] = GhostHome.cloneInPosition(counterRow++, counterCol);

		counterRow = 0;
		counterCol++;
		
		/*Column 10*/
		cells[0][9] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[1][9] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[2][9] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[6][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[7][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][9] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[10][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][9] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[13][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[15][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][9] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][9] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][9] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[19][9] = GhostHome.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 11*/
		cells[0][10] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[1][10] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[2][10] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[6][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[7][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][10] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[10][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][10] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[13][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[15][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][10] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][10] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][10] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[19][10] = GhostHome.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 12*/
		cells[0][11] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[1][11] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[2][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][11] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][11] = GhostHome.cloneInPosition(counterRow++, counterCol);
		cells[19][11] = GhostHome.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 13*/
		cells[0][counterCol] = RoadTeleport.cloneInPosition(counterRow++, counterCol);
		cells[1][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[2][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[10][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[13][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[19][counterCol] = RoadTeleport.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 14*/
		cells[0][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[4][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[7][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[17][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 15*/
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);	
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;

		/*Column 16*/
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 17*/
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[counterRow][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[14][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);

		counterRow = 0;
		counterCol++;
		
		/*Column 18*/
		cells[0][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[1][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[2][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[3][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[6][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[11][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[18][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[19][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 19*/
		cells[0][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
    	cells[1][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[3][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[5][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[8][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[10][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[12][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[13][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[16][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[18][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;
		
		/*Column 20*/
		cells[0][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
    	cells[1][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[2][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[3][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[4][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[5][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[6][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[7][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[8][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[9][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[10][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[11][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[12][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[13][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[14][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[15][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[16][counterCol] = RoadPacdot.cloneInPosition(counterRow++, counterCol);
		cells[17][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[18][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		cells[19][counterCol] = Wall.cloneInPosition(counterRow++, counterCol);
		
		counterRow = 0;
		counterCol++;

	}

	private void createColumnA(int counterCol) {
		int counterRow = 0;
		
		
	}
	
	private void createColumnB() {
		int counterRow = 0;
	}
	
	private void createColumnC() {
		int counterRow = 0;	
	}

	private void createColumnD() {
		int counterRow = 0;	
	}

	private void createColumnE() {
		int counterRow = 0;	
	}

	private void createColumnF() {
		int counterRow = 0;	
	}

	private void createColumnG() {
		int counterRow = 0;	
	}

	private void createColumnH() {
		int counterRow = 0;	
	}
	
	private void createColumnI() {
		int counterRow = 0;
	}

	private void createColumnJ() {
		int counterRow = 0;	
	}
	
}