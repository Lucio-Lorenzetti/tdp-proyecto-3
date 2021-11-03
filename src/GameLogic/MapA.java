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
public class MapA extends Map{
    

    /**
     * Creates and initializes Map.
     */
    public MapA(Game g){
    	
    	super(g);
    	
    	Cell RoadPacdot = new Cell(0, 0, new PacDot(), true, 0);
    	Cell RoadPowerPellet = new Cell(0, 0, new PowerPellet(), true, 0);
    	Cell RoadFruit = new Cell(0, 0, new Fruit(), true, 0);
    	Cell RoadBombPotion = new Cell(0, 0, new BombPotion(), true, 0);
    	Cell RoadSpeedPotion = new Cell(0, 0, new SpeedPotion(), true, 0);
    	
    	Cell RoadTeleport = new Cell(0, 0, null, true, 0);
    	
    	Cell RoadEmpty = new Cell(0, 0, null, true, 0);
    	
    	Cell GhostHome = new Cell(0, 0, null, true, 7);
    	
    	Cell Wall = new Cell(0, 0, null, false, 1);
    	
    	
    	
		/*Column 1*/
		cells[0][0] = RoadPacdot.cloneInPosition(0, 0);
    	cells[1][0] = RoadPacdot.cloneInPosition(1, 0);
		cells[2][0] = RoadPacdot.cloneInPosition(2, 0);
		cells[3][0] = RoadPacdot.cloneInPosition(3, 0);
		cells[4][0] = RoadPacdot.cloneInPosition(4, 0);
		cells[5][0] = RoadPacdot.cloneInPosition(5, 0);
		cells[6][0] = RoadPacdot.cloneInPosition(6, 0);
		cells[7][0] = RoadPacdot.cloneInPosition(7, 0);
		cells[8][0] = RoadPacdot.cloneInPosition(8, 0);
		cells[9][0] = RoadPacdot.cloneInPosition(9, 0);
		cells[10][0] = RoadPacdot.cloneInPosition(10, 0);
		cells[11][0] = RoadPacdot.cloneInPosition(11, 0);
		cells[12][0] = RoadPacdot.cloneInPosition(12, 0);
		cells[13][0] = RoadPacdot.cloneInPosition(13, 0);
		cells[14][0] = RoadPacdot.cloneInPosition(14, 0);
		cells[15][0] = RoadPacdot.cloneInPosition(15, 0);
		cells[16][0] = RoadPacdot.cloneInPosition(16, 0);
		cells[17][0] = RoadPacdot.cloneInPosition(17, 0);
		cells[18][0] = RoadPacdot.cloneInPosition(18, 0);
		cells[19][0] = RoadPacdot.cloneInPosition(19, 0);

		/*Column 2*/
		cells[0][1] = RoadPacdot.cloneInPosition(0, 1);
		cells[1][1] = Wall.cloneInPosition(1, 1);
		cells[2][1] = Wall.cloneInPosition(2, 1);
		cells[3][1] = Wall.cloneInPosition(3, 1);
		cells[4][1] = Wall.cloneInPosition(4, 1);
		cells[5][1] = Wall.cloneInPosition(5, 1);
		cells[6][1] = Wall.cloneInPosition(6, 1);
		cells[7][1] = Wall.cloneInPosition(7, 1);
		cells[8][1] = RoadPowerPellet.cloneInPosition(8,1);
		cells[9][1] = Wall.cloneInPosition(9, 1);
		cells[10][1] = RoadPowerPellet.cloneInPosition(10,1);
		cells[11][1] = Wall.cloneInPosition(11, 1);
		cells[12][1] = Wall.cloneInPosition(12, 1);
		cells[13][1] = Wall.cloneInPosition(13, 1);
		cells[14][1] = Wall.cloneInPosition(14, 1);
		cells[15][1] = Wall.cloneInPosition(15, 1);
		cells[16][1] = Wall.cloneInPosition(16, 1);
		cells[17][1] = Wall.cloneInPosition(17, 1);
		cells[18][1] = Wall.cloneInPosition(18, 1);
		cells[19][1] = RoadPacdot.cloneInPosition(19, 1);

		/*Column 3*/
		cells[0][2] = RoadPacdot.cloneInPosition(0, 2);
		cells[1][2] = RoadPacdot.cloneInPosition(1, 2);
		cells[2][2] = RoadPacdot.cloneInPosition(2, 2);
		cells[3][2] = RoadPacdot.cloneInPosition(3, 2);
		cells[4][2] = RoadPacdot.cloneInPosition(4, 2);
		cells[5][2] = RoadPacdot.cloneInPosition(5, 2);
		cells[6][2] = RoadPacdot.cloneInPosition(6, 2);
		cells[7][2] = RoadPacdot.cloneInPosition(7, 2);
		cells[8][2] = RoadPacdot.cloneInPosition(8, 2);
		cells[9][2] = RoadPacdot.cloneInPosition(9, 2);
		cells[10][2] = RoadPacdot.cloneInPosition(10, 2);
		cells[11][2] = RoadPacdot.cloneInPosition(11, 2);
		cells[12][2] = RoadPacdot.cloneInPosition(12, 2);
		cells[13][2] = RoadPacdot.cloneInPosition(13, 2);
		cells[14][2] = RoadPacdot.cloneInPosition(14, 2);
		cells[15][2] = RoadPacdot.cloneInPosition(15, 2);
		cells[16][2] = RoadPacdot.cloneInPosition(16, 2);
		cells[17][2] = RoadPacdot.cloneInPosition(17, 2);
		cells[18][2] = RoadPacdot.cloneInPosition(18, 2);
		cells[19][2] = RoadPacdot.cloneInPosition(19, 2);
		
		/*Column 4*/
		cells[0][3] = Wall.cloneInPosition(0, 3);
		cells[1][3] = RoadPacdot.cloneInPosition(1, 3);
		cells[2][3] = Wall.cloneInPosition(2, 3);
		cells[3][3] = RoadPacdot.cloneInPosition(3, 3);
		cells[4][3] = Wall.cloneInPosition(4, 3);
		cells[5][3] = RoadPacdot.cloneInPosition(5, 3);
		cells[6][3] = Wall.cloneInPosition(6, 3);
		cells[7][3] = RoadPacdot.cloneInPosition(7, 3);
		cells[8][3] = Wall.cloneInPosition(8, 3);
		cells[9][3] = RoadPacdot.cloneInPosition(9, 3);
		cells[10][3] = Wall.cloneInPosition(10, 3);
		cells[11][3] = RoadPacdot.cloneInPosition(11, 3);
		cells[12][3] = Wall.cloneInPosition(12, 3);
		cells[13][3] = Wall.cloneInPosition(13, 3);
		cells[14][3] = Wall.cloneInPosition(14, 3);
		cells[15][3] = RoadPacdot.cloneInPosition(15, 3);
		cells[16][3] = Wall.cloneInPosition(16, 3);
		cells[17][3] = Wall.cloneInPosition(17, 3);
		cells[18][3] = Wall.cloneInPosition(18, 3);
		cells[19][3] = RoadPacdot.cloneInPosition(19, 3);

		/*Column 5*/
		cells[0][4] = Wall.cloneInPosition(0, 4);
		cells[1][4] = RoadPacdot.cloneInPosition(1, 4);
		cells[2][4] = Wall.cloneInPosition(2, 4);
		cells[3][4] = RoadPacdot.cloneInPosition(3, 4);
		cells[4][4] = Wall.cloneInPosition(4, 4);
		cells[5][4] = RoadPacdot.cloneInPosition(5, 4);
		cells[6][4] = Wall.cloneInPosition(6, 4);
		cells[7][4] = RoadPacdot.cloneInPosition(7, 4);
		cells[8][4] = Wall.cloneInPosition(8, 4);
		cells[9][4] = RoadPacdot.cloneInPosition(9, 4);
		cells[10][4] = Wall.cloneInPosition(10, 4);
		cells[11][4] = RoadPacdot.cloneInPosition(11, 4);
		cells[12][4] = RoadPacdot.cloneInPosition(12, 4);
		cells[13][4] = RoadPacdot.cloneInPosition(13, 4);
		cells[14][4] = RoadPacdot.cloneInPosition(14, 4);
		cells[15][4] = RoadPacdot.cloneInPosition(15, 4);
		cells[16][4] = RoadPacdot.cloneInPosition(16, 4);
		cells[17][4] = RoadPacdot.cloneInPosition(17, 4);
		cells[18][4] = RoadPacdot.cloneInPosition(18, 4);
		cells[19][4] = RoadPacdot.cloneInPosition(19, 4);

		/*Column 6*/
		cells[0][5] = Wall.cloneInPosition(0, 5);
		cells[1][5] = RoadPacdot.cloneInPosition(1, 5);
		cells[2][5] = Wall.cloneInPosition(2, 5);
		cells[3][5] = Wall.cloneInPosition(3, 5);
		cells[4][5] = Wall.cloneInPosition(4, 5);
		cells[5][5] = Wall.cloneInPosition(5, 5);
		cells[6][5] = Wall.cloneInPosition(6, 5);
		cells[7][5] = RoadPacdot.cloneInPosition(7, 5);
		cells[8][5] = Wall.cloneInPosition(8, 5);
		cells[9][5] = RoadPacdot.cloneInPosition(9, 5);
		cells[10][5] = Wall.cloneInPosition(10, 5);
		cells[11][5] = RoadPacdot.cloneInPosition(11, 5);
		cells[12][5] = Wall.cloneInPosition(12, 5);
		cells[13][5] = Wall.cloneInPosition(13, 5);
		cells[14][5] = Wall.cloneInPosition(14, 5);
		cells[15][5] = RoadPacdot.cloneInPosition(15, 5);
		cells[16][5] = Wall.cloneInPosition(16, 5);
		cells[17][5] = Wall.cloneInPosition(17, 5);
		cells[18][5] = Wall.cloneInPosition(18, 5);
		cells[19][5] = RoadPacdot.cloneInPosition(19, 5);
		
		/*Column 7*/
		cells[0][6] = Wall.cloneInPosition(0, 6);
		cells[1][6] = RoadPacdot.cloneInPosition(1, 6);
		cells[2][6] = Wall.cloneInPosition(2, 6);
		cells[3][6] = RoadPacdot.cloneInPosition(3, 6);
		cells[4][6] = Wall.cloneInPosition(4, 6);
		cells[5][6] = RoadPacdot.cloneInPosition(5, 6);
		cells[6][6] = Wall.cloneInPosition(6, 6);
		cells[7][6] = RoadPacdot.cloneInPosition(7, 6);
		cells[8][6] = Wall.cloneInPosition(8, 6);
		cells[9][6] = RoadPacdot.cloneInPosition(9, 6);
		cells[10][6] = Wall.cloneInPosition(10, 6);
		cells[11][6] = RoadPacdot.cloneInPosition(11, 6);
		cells[12][6] = RoadPacdot.cloneInPosition(12, 6);
		cells[13][6] = RoadPacdot.cloneInPosition(13, 6);
		cells[14][6] = Wall.cloneInPosition(14, 6);
		cells[15][6] = RoadPacdot.cloneInPosition(15, 6);
		cells[16][6] = Wall.cloneInPosition(16, 6);
		cells[17][6] = RoadPacdot.cloneInPosition(17, 6);
		cells[18][6] = RoadPacdot.cloneInPosition(18, 6);
		cells[19][6] = RoadPacdot.cloneInPosition(19, 6);
		
		/*Column 8*/
		cells[0][7] = Wall.cloneInPosition(0, 7);
		cells[1][7] = RoadPacdot.cloneInPosition(1, 7);
		cells[2][7] = Wall.cloneInPosition(2, 7);
		cells[3][7] = RoadPacdot.cloneInPosition(3, 7);
		cells[4][7] = Wall.cloneInPosition(4, 7);
		cells[5][7] = RoadPacdot.cloneInPosition(5, 7);
		cells[6][7] = Wall.cloneInPosition(6, 7);
		cells[7][7] = RoadPacdot.cloneInPosition(7, 7);
		cells[8][7] = RoadPacdot.cloneInPosition(8, 7);
		cells[9][7] = RoadPacdot.cloneInPosition(9, 7);
		cells[10][7] = RoadPacdot.cloneInPosition(10, 7);
		cells[11][7] = RoadPacdot.cloneInPosition(11, 7);
		cells[12][7] = Wall.cloneInPosition(12, 7);
		cells[13][7] = RoadPacdot.cloneInPosition(13, 7);
		cells[14][7] = Wall.cloneInPosition(14, 7);
		cells[15][7] = RoadPacdot.cloneInPosition(15, 7);
		cells[16][7] = Wall.cloneInPosition(16, 7);
		cells[17][7] = RoadPacdot.cloneInPosition(17, 7);
		cells[18][7] = Wall.cloneInPosition(18, 7);
		cells[19][7] = Wall.cloneInPosition(19, 7);
		
		/*Column 9*/
		cells[0][8] = RoadPacdot.cloneInPosition(1, 8);
		cells[1][8] = RoadPacdot.cloneInPosition(1, 8);
		cells[2][8] = RoadPacdot.cloneInPosition(2, 8);
		cells[3][8] = RoadPacdot.cloneInPosition(3, 8);
		cells[4][8] = RoadPacdot.cloneInPosition(4, 8);
		cells[5][8] = RoadPacdot.cloneInPosition(5, 8);
		cells[6][8] = RoadPacdot.cloneInPosition(6, 8);
		cells[7][8] = RoadPacdot.cloneInPosition(7, 8);
		cells[8][8] = RoadFruit.cloneInPosition(8, 8);
		cells[9][8] = GhostHome.cloneInPosition(9, 8);
		cells[10][8] = GhostHome.cloneInPosition(10, 8);
		cells[11][8] = RoadSpeedPotion.cloneInPosition(11, 8);
		cells[12][8] = Wall.cloneInPosition(12, 8);
		cells[13][8] = RoadPacdot.cloneInPosition(13, 8);
		cells[14][8] = Wall.cloneInPosition(14, 8);
		cells[15][8] = RoadPacdot.cloneInPosition(15, 8);
		cells[16][8] = Wall.cloneInPosition(16, 8);
		cells[17][8] = RoadPacdot.cloneInPosition(17, 8);
		cells[18][8] = RoadPacdot.cloneInPosition(18, 8);
		cells[19][8] = RoadPacdot.cloneInPosition(19, 8);

		/*Column 10*/
		cells[0][9] = RoadPacdot.cloneInPosition(0, 9);
		cells[1][9] = RoadPacdot.cloneInPosition(1, 9);
		cells[2][9] = RoadPacdot.cloneInPosition(2, 9);
		cells[3][9] = Wall.cloneInPosition(3, 9);
		cells[4][9] = RoadPacdot.cloneInPosition(4, 9);
		cells[5][9] = RoadPacdot.cloneInPosition(5, 9);
		cells[6][9] = RoadPacdot.cloneInPosition(6, 9);
		cells[7][9] = Wall.cloneInPosition(7, 9);
		cells[8][9] = RoadPacdot.cloneInPosition(8, 9);
		cells[9][9] = GhostHome.cloneInPosition(9, 9);
		cells[10][9] = GhostHome.cloneInPosition(10, 9);
		cells[11][9] = RoadPacdot.cloneInPosition(11, 9);
		cells[12][9] = RoadPacdot.cloneInPosition(12, 9);
		cells[13][9] = RoadPacdot.cloneInPosition(13, 9);
		cells[14][9] = Wall.cloneInPosition(14, 9);
		cells[15][9] = RoadPacdot.cloneInPosition(15, 9);
		cells[16][9] = RoadPacdot.cloneInPosition(16, 9);
		cells[17][9] = RoadPacdot.cloneInPosition(17, 9);
		cells[18][9] = Wall.cloneInPosition(18, 9);
		cells[19][9] = RoadPacdot.cloneInPosition(19, 9);
		
		/*Column 11*/
		cells[0][10] = RoadPacdot.cloneInPosition(0, 10);
		cells[1][10] = Wall.cloneInPosition(1, 10);
		cells[2][10] = RoadPacdot.cloneInPosition(2, 10);
		cells[3][10] = RoadPacdot.cloneInPosition(3, 10);
		cells[4][10] = RoadPacdot.cloneInPosition(4, 10);
		cells[5][10] = Wall.cloneInPosition(5, 10);
		cells[6][10] = RoadPacdot.cloneInPosition(6, 10);
		cells[7][10] = RoadPacdot.cloneInPosition(7, 10);
		cells[8][10] = RoadPacdot.cloneInPosition(8, 10);
		cells[9][10] = GhostHome.cloneInPosition(9, 10);
		cells[10][10] = GhostHome.cloneInPosition(10, 10);
		cells[11][10] = RoadPacdot.cloneInPosition(11, 10);
		cells[12][10] = Wall.cloneInPosition(12, 10);
		cells[13][10] = RoadPacdot.cloneInPosition(13, 10);
		cells[14][10] = RoadPacdot.cloneInPosition(14, 10);
		cells[15][10] = RoadPacdot.cloneInPosition(15, 10);
		cells[16][10] = Wall.cloneInPosition(16, 10);
		cells[17][10] = RoadPacdot.cloneInPosition(17, 10);
		cells[18][10] = RoadPacdot.cloneInPosition(18, 10);
		cells[19][10] = RoadPacdot.cloneInPosition(19, 10);
		
		/*Column 12*/
		cells[0][11] = RoadPacdot.cloneInPosition(0, 11);
		cells[1][11] = RoadPacdot.cloneInPosition(1, 11);
		cells[2][11] = RoadPacdot.cloneInPosition(2, 11);
		cells[3][11] = Wall.cloneInPosition(3, 11);
		cells[4][11] = RoadPacdot.cloneInPosition(4, 11);
		cells[5][11] = Wall.cloneInPosition(5, 11);
		cells[6][11] = RoadPacdot.cloneInPosition(6, 11);
		cells[7][11] = Wall.cloneInPosition(7, 11);
		cells[8][11] = RoadBombPotion.cloneInPosition(8, 11);
		cells[9][11] = GhostHome.cloneInPosition(9, 11);
		cells[10][11] = GhostHome.cloneInPosition(10, 11);
		cells[11][11] = RoadFruit.cloneInPosition(11, 11);
		cells[12][11] = RoadPacdot.cloneInPosition(12, 11);
		cells[13][11] = RoadPacdot.cloneInPosition(13, 11);
		cells[14][11] = RoadPacdot.cloneInPosition(14, 11);
		cells[15][11] = RoadPacdot.cloneInPosition(15, 11);
		cells[16][11] = RoadPacdot.cloneInPosition(16, 11);
		cells[17][11] = RoadPacdot.cloneInPosition(17, 11);
		cells[18][11] = RoadPacdot.cloneInPosition(18, 11);
		cells[19][11] = RoadPacdot.cloneInPosition(19, 11);
		
		/*Column 13*/
		cells[0][12] = Wall.cloneInPosition(0, 12);
		cells[1][12] = Wall.cloneInPosition(1, 12);
		cells[2][12] = RoadPacdot.cloneInPosition(2, 12);
		cells[3][12] = Wall.cloneInPosition(3, 12);
		cells[4][12] = RoadPacdot.cloneInPosition(4, 12);
		cells[5][12] = Wall.cloneInPosition(5, 12);
		cells[6][12] = RoadPacdot.cloneInPosition(6, 12);
		cells[7][12] = Wall.cloneInPosition(7, 12);
		cells[8][12] = RoadPacdot.cloneInPosition(8, 12);
		cells[9][12] = RoadPacdot.cloneInPosition(9, 12);
		cells[10][12] = RoadPacdot.cloneInPosition(10, 12);
		cells[11][12] = RoadPacdot.cloneInPosition(11, 12);
		cells[12][12] = RoadPacdot.cloneInPosition(12, 12);
		cells[13][12] = Wall.cloneInPosition(13, 12);
		cells[14][12] = RoadPacdot.cloneInPosition(14, 12);
		cells[15][12] = Wall.cloneInPosition(15, 12);
		cells[16][12] = RoadPacdot.cloneInPosition(16, 12);
		cells[17][12] = Wall.cloneInPosition(17, 12);
		cells[18][12] = RoadPacdot.cloneInPosition(18, 12);
		cells[19][12] = Wall.cloneInPosition(19, 12);
		
		/*Column 14*/
		cells[0][13] = RoadPacdot.cloneInPosition(0, 13);
		cells[1][13] = RoadPacdot.cloneInPosition(1, 13);
		cells[2][13] = RoadPacdot.cloneInPosition(2, 13);
		cells[3][13] = Wall.cloneInPosition(3, 13);
		cells[4][13] = RoadPacdot.cloneInPosition(4, 13);
		cells[5][13] = Wall.cloneInPosition(5, 13);
		cells[6][13] = RoadPacdot.cloneInPosition(6, 13);
		cells[7][13] = RoadPacdot.cloneInPosition(7, 13);
		cells[8][13] = RoadPacdot.cloneInPosition(8, 13);
		cells[9][13] = Wall.cloneInPosition(9, 13);
		cells[10][13] = RoadPacdot.cloneInPosition(10, 13);
		cells[11][13] = Wall.cloneInPosition(11, 13);
		cells[12][13] = RoadPacdot.cloneInPosition(12, 13);
		cells[13][13] = Wall.cloneInPosition(13, 13);
		cells[14][13] = RoadPacdot.cloneInPosition(14, 13);
		cells[15][13] = Wall.cloneInPosition(15, 13);
		cells[16][13] = RoadPacdot.cloneInPosition(16, 13);
		cells[17][13] = Wall.cloneInPosition(17, 13);
		cells[18][13] = RoadPacdot.cloneInPosition(18, 13);
		cells[19][13] = Wall.cloneInPosition(19, 13);
		
		/*Column 15*/
		cells[0][14] = RoadPacdot.cloneInPosition(0, 14);
		cells[1][14] = Wall.cloneInPosition(1, 14);
		cells[2][14] = Wall.cloneInPosition(2, 14);
		cells[3][14] = Wall.cloneInPosition(3, 14);
		cells[4][14] = RoadPacdot.cloneInPosition(4, 14);
		cells[5][14] = Wall.cloneInPosition(5, 14);
		cells[6][14] = Wall.cloneInPosition(6, 14);
		cells[7][14] = Wall.cloneInPosition(7, 14);
		cells[8][14] = RoadPacdot.cloneInPosition(8, 14);
		cells[9][14] = Wall.cloneInPosition(9, 14);
		cells[10][14] = RoadPacdot.cloneInPosition(10, 14);
		cells[11][14] = Wall.cloneInPosition(11, 14);
		cells[12][14] = RoadPacdot.cloneInPosition(12, 14);
		cells[13][14] = Wall.cloneInPosition(13, 14);
		cells[14][14] = Wall.cloneInPosition(14, 14);
		cells[15][14] = Wall.cloneInPosition(15, 14);
		cells[16][14] = Wall.cloneInPosition(16, 14);
		cells[17][14] = Wall.cloneInPosition(17, 14);
		cells[18][14] = RoadPacdot.cloneInPosition(18, 14);
		cells[19][14] = Wall.cloneInPosition(19, 14);

		/*Column 16*/
		cells[0][15] = RoadPacdot.cloneInPosition(0, 15);
		cells[1][15] = RoadPacdot.cloneInPosition(1, 15);
		cells[2][15] = RoadPacdot.cloneInPosition(2, 15);
		cells[3][15] = RoadPacdot.cloneInPosition(3, 15);
		cells[4][15] = RoadPacdot.cloneInPosition(4, 15);
		cells[5][15] = RoadPacdot.cloneInPosition(5, 15);
		cells[6][15] = RoadPacdot.cloneInPosition(6, 15);
		cells[7][15] = RoadPacdot.cloneInPosition(7, 15);
		cells[8][15] = RoadPacdot.cloneInPosition(8, 15);
		cells[9][15] = Wall.cloneInPosition(9, 15);
		cells[10][15] = RoadPacdot.cloneInPosition(10, 15);
		cells[11][15] = Wall.cloneInPosition(11, 15);
		cells[12][15] = RoadPacdot.cloneInPosition(12, 15);
		cells[13][15] = Wall.cloneInPosition(13, 15);
		cells[14][15] = RoadPacdot.cloneInPosition(14, 15);
		cells[15][15] = Wall.cloneInPosition(15, 15);
		cells[16][15] = RoadPacdot.cloneInPosition(16, 15);
		cells[17][15] = Wall.cloneInPosition(17, 15);
		cells[18][15] = RoadPacdot.cloneInPosition(18, 15);
		cells[19][15] = Wall.cloneInPosition(19, 15);
		
		/*Column 17*/
		cells[0][16] = RoadPacdot.cloneInPosition(0, 16);
		cells[1][16] = Wall.cloneInPosition(1, 16);
		cells[2][16] = Wall.cloneInPosition(2, 16);
		cells[3][16] = Wall.cloneInPosition(3, 16);
		cells[4][16] = RoadPacdot.cloneInPosition(4, 16);
		cells[5][16] = Wall.cloneInPosition(5, 16);
		cells[6][16] = Wall.cloneInPosition(6, 16);
		cells[7][16] = Wall.cloneInPosition(7, 16);
		cells[8][16] = RoadPacdot.cloneInPosition(8, 16);
		cells[9][16] = Wall.cloneInPosition(9, 16);
		cells[10][16] = RoadPacdot.cloneInPosition(10, 16);
		cells[11][16] = Wall.cloneInPosition(11, 16);
		cells[12][16] = RoadPacdot.cloneInPosition(12, 16);
		cells[13][16] = Wall.cloneInPosition(13, 16);
		cells[14][16] = RoadPacdot.cloneInPosition(14, 16);
		cells[15][16] = Wall.cloneInPosition(15, 16);
		cells[16][16] = RoadPacdot.cloneInPosition(16, 16);
		cells[17][16] = Wall.cloneInPosition(17, 16);
		cells[18][16] = RoadPacdot.cloneInPosition(18, 16);
		cells[19][16] = Wall.cloneInPosition(19, 16);

		/*Column 18*/
		cells[0][17] = RoadPacdot.cloneInPosition(0, 17);
		cells[1][17] = RoadPacdot.cloneInPosition(1, 17);
		cells[2][17] = RoadPacdot.cloneInPosition(2, 17);
		cells[3][17] = RoadPacdot.cloneInPosition(3, 17);
		cells[4][17] = RoadPacdot.cloneInPosition(4, 17);
		cells[5][17] = RoadPacdot.cloneInPosition(5, 17);
		cells[6][17] = RoadPacdot.cloneInPosition(6, 17);
		cells[7][17] = RoadPacdot.cloneInPosition(7, 17);
		cells[8][17] = RoadPacdot.cloneInPosition(8, 17);
		cells[9][17] = RoadPacdot.cloneInPosition(9, 17);
		cells[10][17] = RoadPacdot.cloneInPosition(10, 17);
		cells[11][17] = RoadPacdot.cloneInPosition(11, 17);
		cells[12][17] = RoadPacdot.cloneInPosition(12, 17);
		cells[13][17] = RoadPacdot.cloneInPosition(13, 17);
		cells[14][17] = RoadPacdot.cloneInPosition(14, 17);
		cells[15][17] = RoadPacdot.cloneInPosition(15, 17);
		cells[16][17] = RoadPacdot.cloneInPosition(16, 17);
		cells[17][17] = RoadPacdot.cloneInPosition(17, 17);
		cells[18][17] = RoadPacdot.cloneInPosition(18, 17);
		cells[19][17] = RoadPacdot.cloneInPosition(19, 17);
		
		/*Column 19*/
		cells[0][18] = RoadPacdot.cloneInPosition(0, 18);
		cells[1][18] = Wall.cloneInPosition(1, 18);
		cells[2][18] = Wall.cloneInPosition(2, 18);
		cells[3][18] = Wall.cloneInPosition(3, 18);
		cells[4][18] = Wall.cloneInPosition(4, 18);
		cells[5][18] = Wall.cloneInPosition(5, 18);
		cells[6][18] = Wall.cloneInPosition(6, 18);
		cells[7][18] = Wall.cloneInPosition(7, 18);
		cells[8][18] = Wall.cloneInPosition(8, 18);
		cells[9][18] = RoadPowerPellet.cloneInPosition(9,18);
		cells[10][18] = Wall.cloneInPosition(10, 18);
		cells[11][18] = RoadPowerPellet.cloneInPosition(11,18);
		cells[12][18] = Wall.cloneInPosition(12, 18);
		cells[13][18] = Wall.cloneInPosition(13, 18);
		cells[14][18] = Wall.cloneInPosition(14, 18);
		cells[15][18] = Wall.cloneInPosition(15, 18);
		cells[16][18] = Wall.cloneInPosition(16, 18);
		cells[17][18] = Wall.cloneInPosition(17, 18);
		cells[18][18] = Wall.cloneInPosition(18, 18);
		cells[19][18] = RoadPacdot.cloneInPosition(19, 18);
		
		/*Column 20*/
		cells[0][19] = RoadPacdot.cloneInPosition(0, 19);
		cells[1][19] = RoadPacdot.cloneInPosition(1, 19);
		cells[2][19] = RoadPacdot.cloneInPosition(2, 19);
		cells[3][19] = RoadPacdot.cloneInPosition(3, 19);
		cells[4][19] = RoadPacdot.cloneInPosition(4, 19);
		cells[5][19] = RoadPacdot.cloneInPosition(5, 19);
		cells[6][19] = RoadPacdot.cloneInPosition(6, 19);
		cells[7][19] = RoadPacdot.cloneInPosition(7, 19);
		cells[8][19] = RoadPacdot.cloneInPosition(8, 19);
		cells[9][19] = RoadPacdot.cloneInPosition(9, 19);
		cells[10][19] = RoadPacdot.cloneInPosition(10, 19);
		cells[11][19] = RoadPacdot.cloneInPosition(11, 19);
		cells[12][19] = RoadPacdot.cloneInPosition(12, 19);
		cells[13][19] = RoadPacdot.cloneInPosition(13, 19);
		cells[14][19] = RoadPacdot.cloneInPosition(14, 19);
		cells[15][19] = RoadPacdot.cloneInPosition(15, 19);
		cells[16][19] = RoadPacdot.cloneInPosition(16, 19);
		cells[17][19] = RoadPacdot.cloneInPosition(17, 19);
		cells[18][19] = RoadPacdot.cloneInPosition(18, 19);
		cells[19][19] = RoadPacdot.cloneInPosition(19, 19);
		
    }
    
    
}
