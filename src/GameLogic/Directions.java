package GameLogic;

import java.util.LinkedList;

/**
 *
 * Class Directions.
 * 
 * Defines the Directions class.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */

public class Directions {

	protected static Object right = null;
	protected static Object left = null;
	protected static Object up = null;
	protected static Object down = null;
	protected static Object neutral = null;
	
	/**
	* @returns the right object
	*/
	public static Object getRight() {
		
		if(right == null) {
			right = new Object();
		}
	
		return right;
	
	}
	/**
	* @returns the left object
	*/
	public static Object getLeft() {
		
		if(left == null) {
			left = new Object();
			
		}
			return left;
	
	}
	/**
	* @returns the up object
	*/
	public static Object getUp() {
	
		if(up == null) {
			up = new Object();
			
		}
	
		return up;

	}
	/**
	* @returns the down object
	*/
	public static Object getDown() {
		
		if(down == null) {
			down = new Object();
			
		}
	
		return down;

	}
	/**
	* @returns the neutral object
	*/
	public static Object getNeutral() {
		
		if(neutral == null) {
			neutral = new Object();
			
		}
	
		return neutral;

	}
	
	public static Object getRandomDirection() {
		
		LinkedList<Object> directionList = new LinkedList<Object>();
		
		directionList.add(right);
		directionList.add(left);
		directionList.add(up);
		directionList.add(down);
		
		int directionSelection = (int) ((Math.random() * (directionList.size() - 0)) + 0);
		
		//int directionSelection = (int) (java.lang.System.currentTimeMillis() % directionList.size());
		

		return directionList.get(directionSelection);
		
	}
	
	public static Object getOpposite(Object o) {
		
		Object opposite = left;
		
		if(o == left) {
			opposite = left;
		} else if(o == up) {
			opposite = down;
		} else if (o == down) {
			opposite = up;
		}
		
		
		return opposite;
		
	}
	
}
