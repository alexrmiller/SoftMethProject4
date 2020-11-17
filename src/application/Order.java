/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

import java.util.ArrayList;

public class Order implements Customizable {

	public static int lineNumber=1;
	private ArrayList<OrderLine> orderlines;//all sandwiches within an order, will be used on second GUI page
	
	public Order(ArrayList<OrderLine> orderline) {
		this.orderlines=orderline;
	}
	
	public ArrayList<OrderLine> getOl() {
		return this.orderlines;
	}
	
	public double getPrice() {
		double price=0;
		for(OrderLine ol: this.orderlines) {
			price += ol.getPrice();
		}
		return price;
	}
	
	@Override
	public boolean add(Object obj) { 
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
