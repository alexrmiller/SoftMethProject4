package application;

import java.util.ArrayList;

public class Chicken extends Sandwich {

	private String Cmeat;
	private String Ctopping1;
	private String Ctopping2;
	private ArrayList<Extra> extras; //refers to the list view of added extras
	
	public Chicken(ArrayList<Extra> extras) {
		super(extras);
		this.Cmeat="Fried Chicken";
		this.Ctopping1="Spicy Sauce";
		this.Ctopping2="Pickles";
	}
	
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (Chicken.super.extras.size() < Sandwich.MAX_EXTRAS && !Chicken.super.extras.contains((Extra)obj)) {
				return Chicken.super.extras.add((Extra) obj);
			}
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			if (Chicken.super.extras.size() > 0) {
				return Chicken.super.extras.remove((Extra) obj);
			}
		}
		return false;
	}

	@Override
	public double price() {
		double initialPrice = 8.99;
		for (Extra e : extras) {
			initialPrice += Sandwich.PER_EXTRA;
		}
		return initialPrice;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.Cmeat + ", " + this.Ctopping1 + ", " + this.Ctopping2 + ", ");
		for(Extra e : extras) {
			sb.append(e.toString() + ", ");
		}
		return sb.toString();
	}

}
