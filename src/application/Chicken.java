/*Authors: Maudiel Romero and Alex Miller
 * 
 */
package application;

import java.util.ArrayList;

public class Chicken extends Sandwich {

	/*
	 * instance variables for Chicken Sandwich
	 */
	private String Cmeat;
	private String Ctopping1;
	private String Ctopping2;

	/*
	 * constructor for sandwich of type Chicken, this has the given meats and
	 * toppings and calls Sandwiches super constructor to add the array list of
	 * extras
	 */
	public Chicken(ArrayList<Extra> extras) {
		super(extras);
		this.Cmeat = "Fried Chicken";
		this.Ctopping1 = "Spicy Sauce";
		this.Ctopping2 = "Pickles";
	}

	/*
	 * given an extra it adds it to the extras for the sandwich if there isn't more
	 * than 6 extras already and it isn't a duplicate
	 */
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (Chicken.super.extras.size() < Sandwich.MAX_EXTRAS && !Chicken.super.extras.contains((Extra) obj)) {
				return Chicken.super.extras.add((Extra) obj);
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
			if (Chicken.super.extras.size() > 0) {
				return Chicken.super.extras.remove((Extra) obj);
			}
		}
		return false;
	}

	/*
	 * returns the price of the sandwich based on the price of chicken plus the
	 * price of all added extras
	 */
	@Override
	public double price() {
		return 8.99 + extras.size() * 1.99;
	}

	/*
	 * returns the sandwich object to a string type to be able to print it out in a
	 * text file, adds the included and extra ingredients if there are any
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.Cmeat + ", " + this.Ctopping1 + ", " + this.Ctopping2 + ", ");
		for (Extra e : extras) {
			sb.append(e.toString() + ", ");
		}
		return sb.toString();
	}

}
