package GameLogic;

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
	* returns a right object
	*/
	public static Object getRight() {
		
		if(right == null) {
			right = new Object();
			
		}
	
		return right;
	
	}
	/**
	* returns a left object
	*/
	public static Object getLeft() {
		
		if(left == null) {
			left = new Object();
			
		}
			return left;
	
	}
	/**
	* returns a up object
	*/
	public static Object getUp() {
	
		if(up == null) {
			up = new Object();
			
		}
	
		return up;

	}
	/**
	* returns a down object
	*/
	public static Object getDown() {
		
		if(down == null) {
			down = new Object();
			
		}
	
		return down;

	}
	/**
	* returns a neutral object
	*/
	public static Object getNeutral() {
		
		if(neutral == null) {
			neutral = new Object();
			
		}
	
		return neutral;

	}
	
}
