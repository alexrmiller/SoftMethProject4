package application;

public class Beef extends Sandwich{

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double price() {
		double initialPrice = 10.99;
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
