package application;

public class Fish extends Sandwich{

	@Override
	public boolean add(Object obj) {
		
		return false;
	}

	//removes an extra?
	@Override
	public boolean remove(Object obj) {
		
		return false;
	}

	@Override
	public double price() {
		double initialPrice = 12.99;
		for(Extra e : extras) {
			initialPrice+=1.99;
		}
		return initialPrice;
	}
	
	@Override
	public String toString() {
		return null;
	}

}
