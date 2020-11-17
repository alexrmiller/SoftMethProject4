/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

import java.util.ArrayList;

public class Order implements Customizable {

	/*
	 * instance variables and static variable lineNumber
	 */
	public static int lineNumber=1;
	private ArrayList<OrderLine> orderlines;
	
	
	/*
	 * constructor method for an order given an arraylist for the orderline
	 */
	public Order(ArrayList<OrderLine> orderline) {
		this.orderlines=orderline;
	}
	
	
	/*
	 * getter method that retrieves the Orderline of the given order
	 */
	public ArrayList<OrderLine> getOl() {
		return this.orderlines;
	}
	
	/*
	 * getter method that returns the price of the entire order based on all the sandwiches in the orderline
	 * uses orderline\s getPrice() method
	 */
	public double getPrice() {
		double price=0;
		for(OrderLine ol: this.orderlines) {
			price += ol.getPrice();
		}
		return price;
	}
	
	/*
	 * method that adds an orderline to the order's orderline
	 */
	@Override
	public boolean add(Object obj) { 
		if(obj instanceof OrderLine) {
		  	return orderlines.add((OrderLine)obj);
		}
		return true;
	}

	/*
	 * method that removes an orderline to the order's orderline
	 */
	@Override
	public boolean remove(Object obj) {
		if(obj instanceof OrderLine) {
			return orderlines.remove((OrderLine)obj);
		}
		return false;
	}
	
	
}
