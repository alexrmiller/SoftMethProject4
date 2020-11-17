/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

import java.util.ArrayList;

public class Fish extends Sandwich{

	/*
	 * instance variables for Fish Sandwich
	 */
	private String Fmeat;
	private String Ftopping1;
	private String Ftopping2;
	
	/*
	 * constructor for sandwich of type Fish, this has the given meats and
	 * toppings and calls Sandwiches super constructor to add the array list of
	 * extras
	 */
	public Fish(ArrayList<Extra> extras) {
		super(extras);
		this.Fmeat="Grilled Snapper";
		this.Ftopping1="Cilantro";
		this.Ftopping2="Lime";
	}
	
	/*
	 * given an extra it adds it to the extras for the sandwich if there isn't more
	 * than 6 extras already and it isn't a duplicate
	 */
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (Fish.super.extras.size() < Sandwich.MAX_EXTRAS && !Fish.super.extras.contains((Extra)obj)) {
				return Fish.super.extras.add((Extra) obj);
			}
		}
		return false;
	}

	/*
	 * removes a given extra from the sandwiches extra array list
	 */
	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			if (Fish.super.extras.size() > 0) {
				return Fish.super.extras.remove((Extra) obj);
			}
		}
		return false;
	}

	/*
	 * returns the price of the sandwich based on the price of Fish plus the
	 * price of all added extras
	 */
	@Override
	public double price() {
		return 12.99 + extras.size()*1.99;
	}
	
	/*
	 * returns the sandwich object to a string type to be able to print it out in a
	 * text file, adds the included and extra ingredients if there are any
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.Fmeat + ", " + this.Ftopping1 + ", " + this.Ftopping2 + ", ");
		for(Extra e : extras) {
			sb.append(e.toString() + ", ");
		}
		return sb.toString();
	}

}
