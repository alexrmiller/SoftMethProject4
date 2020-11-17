/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

public class OrderLine {

	/*
	 * instance variables for order line, sandwich can be of different types
	 */
	private int lineNumber;
	private Sandwich sandwich;
	private double price;
	
	/*
	 * constructor for and Orderline given a line number, sandwich, and price
	 */
	public OrderLine(int lineNum, Sandwich sand, double price) {
		this.lineNumber=lineNum;
		this.sandwich=sand;
		this.price=price;
	}
	
	/*
	 * getter method to retrieve the sandwich of the oder line
	 */
	public Sandwich getSand() {
		return this.sandwich;
	}
	
	/*
	 * getter method to retrieve the line number of the oder line
	 */
	public int getlineNum() {
		return this.lineNumber;
	}
	
	/*
	 * getter method to retrieve the price of the oder line
	 */
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(this.lineNumber + ", " + this.sandwich.toString() + this.price);

        return sb.toString();
		
	}
}
