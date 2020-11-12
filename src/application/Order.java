package application;

import java.util.ArrayList;

public class Order implements Customizable {

	public static int lineNumber; //create an int and increment it?
	private ArrayList<OrderLine> orderlines; //all sandwiches within an order, will be used on second GUI page
	
	public Order(ArrayList<OrderLine> orderline) {
		this.orderlines=orderline;
	}
	
	@Override
	public boolean add(Object obj) { //called everytime that you press add to order
		if(obj instanceof OrderLine) {
		  	return orderlines.add((OrderLine)obj);
		}
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		if(obj instanceof OrderLine) {
			return orderlines.remove((OrderLine)obj);
		}
		return false;
	}
	
	
}
