/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {

	/*
	 * variables to keep track of and instance variable array list to keep track of
	 * extras on the sandwich
	 */
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;

	public abstract double price();

	/*
	 * constructor for the sandwich given an array list of extras
	 */
	public Sandwich(ArrayList<Extra> extra) {
		this.extras = extra;
	}

	/*
	 * method to return a string for a given sandwich
	 */
	@Override
	public String toString() {
		return null;
	}

}
