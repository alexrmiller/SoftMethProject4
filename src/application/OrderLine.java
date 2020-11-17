package application;

public class OrderLine {

	private int lineNumber; 
	private Sandwich sandwich; // will be added via sandwich type dd selection and list view extras
	private double price; //get this from Sandwich.price() 
	
	public OrderLine(int lineNum, Sandwich sand, double price) {
		this.lineNumber=lineNum;
		this.sandwich=sand;
		this.price=price;
	}
	
	public Sandwich getSand() {
		return this.sandwich;
	}
	
	public int getlineNum() {
		return this.lineNumber;
	}
	
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
