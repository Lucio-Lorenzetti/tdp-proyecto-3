package PickeableElements;

import Elements.Element;

/**
*
* Pickeable Class.
* 
* Defines the applicable operations of a Pickeable element.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Pickeable extends Element{

	
	public abstract void consume();

	public abstract Pickeable clone();

	
}
