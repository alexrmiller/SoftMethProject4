package application;

import java.util.ArrayList;

public class Fish extends Sandwich{

	private String Fmeat;
	private String Ftopping1;
	private String Ftopping2;
	private ArrayList<Extra> extras;
	
	public Fish(ArrayList<Extra> extras) {
		super(extras);
		this.Fmeat="Grilled Snapper";
		this.Ftopping1="Cilantro";
		this.Ftopping2="Lime";
	}
	@Override
	public boolean add(Object obj) {
		if (obj instanceof Extra) {
			if (Fish.super.extras.size() < Sandwich.MAX_EXTRAS) {
				return Fish.super.extras.add((Extra) obj);
			}
		}
		return false;
	}

	//removes an extra?
	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			if (Fish.super.extras.size() > 0) {
				return Fish.super.extras.remove((Extra) obj);
			}
		}
		return false;
	}

	@Override
	public double price() {
		double initialPrice = 12.99;
		for(Extra e : extras) {
			initialPrice+=Sandwich.PER_EXTRA;
		}
		return initialPrice;
	}
	
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
