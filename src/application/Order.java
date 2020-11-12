package application;

import java.util.ArrayList;

public class Order implements Customizable {

	public static int lineNumber;
	private ArrayList<OrderLine> orderlines;
	
	@Override
	public boolean add(Object obj) {
		if(obj instanceof OrderLine) {
			orderlines.add((OrderLine)obj);
		}
		else {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		if(obj instanceof OrderLine) {
			orderlines.remove((OrderLine)obj);
		}
		else {
			return false;
		}
		return true;
	}
	
	
}
