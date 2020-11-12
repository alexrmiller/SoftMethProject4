package application;

import java.util.ArrayList;

public class Beef extends Sandwich{
	
	private String Bmeat;
	private String Btopping1;
	private String Btopping2;
	private ArrayList<Extra> extras;
	
	public Beef(ArrayList<Extra> extras) {
		super(extras);
		this.Bmeat="Roast Beef";
		this.Btopping1="Provolone Cheese";
		this.Btopping2="Mustard";
	}
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (Beef.super.extras.size() < Sandwich.MAX_EXTRAS && !Beef.super.extras.contains((Extra)obj)) {
				return Beef.super.extras.add((Extra) obj);
			}
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			if (Beef.super.extras.size() > 0) {
				return Beef.super.extras.remove((Extra) obj);
			}
		}
		return false;
	}

	@Override
	public double price() {
		double initialPrice = 10.99;
		for(Extra e : extras) {
			initialPrice+=Sandwich.PER_EXTRA;
		}
		return initialPrice;
	}
	
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
