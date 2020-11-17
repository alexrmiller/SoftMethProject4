/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

import java.util.ArrayList;

public class Beef extends Sandwich{
	
	/*
	 * instance variables for Beef Sandwich
	 */
	private String Bmeat;
	private String Btopping1;
	private String Btopping2;
	
	/*
	 * constructor for sandwich of type Beef, this has the given meats and
	 * toppings and calls Sandwiches super constructor to add the array list of
	 * extras
	 */
	public Beef(ArrayList<Extra> extras) {
		super(extras);
		this.Bmeat="Roast Beef";
		this.Btopping1="Provolone Cheese";
		this.Btopping2="Mustard";
	}
	
	/*
	 * given an extra it adds it to the extras for the sandwich if there isn't more
	 * than 6 extras already and it isn't a duplicate
	 */
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (Beef.super.extras.size() < Sandwich.MAX_EXTRAS && !Beef.super.extras.contains((Extra)obj)) {
				return Beef.super.extras.add((Extra) obj);
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
			if (Beef.super.extras.size() > 0) {
				return Beef.super.extras.remove((Extra) obj);
			}
		}
		return false;
	}

	/*
	 * returns the price of the sandwich based on the price of Beef plus the
	 * price of all added extras
	 */
	@Override
	public double price() {
		return 10.99 + extras.size()*1.99;
	}
	
	/*
	 * returns the sandwich object to a string type to be able to print it out in a
	 * text file, adds the included and extra ingredients if there are any
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.Bmeat + ", " + this.Btopping1 + ", " + this.Btopping2 + ", ");
		for(Extra e : extras) {
			sb.append(e.toString() + ", ");
		}
		return sb.toString();
	}

}
