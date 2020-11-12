package application;

public class OrderLine {

	private int lineNumber; //unsure where we get this
	private Sandwich sandwich; // will be added via sandwichtype dd selection and list view extras
	private double price; //get this from price box which will call Sandwich.price() 
	
	public OrderLine(int lineNum, Sandwich sand, double price) {
		this.lineNumber=lineNum;
		this.sandwich=sand;
		this.price=price;
	}
}
