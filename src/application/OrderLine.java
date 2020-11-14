package application;

public class OrderLine {

	private int lineNumber; //unsure where we get this
	private Sandwich sandwich; // will be added via sandwich type dd selection and list view extras
	private double price; //get this from Sandwich.price() 
	
	public OrderLine(int lineNum, Sandwich sand, double price) {
		this.lineNumber=lineNum;
		this.sandwich=sand;
		this.price=price;
	}
	
	@Override
	public String toString() {
		return null;
		
	}
}
