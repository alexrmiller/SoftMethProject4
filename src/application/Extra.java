/*Author: Maudiel Romero and Alex Miller
 * 
 */
package application;

public class Extra {
	
	/*
	 * instance variable used to create extra
	 */
	private String extra;
	
	/*
	 * constructor that creates an extra object based on a given string
	 */
	public Extra(String extra) {
		this.extra=extra;
	}
	
	/*
	 * prints out the Extra in string format
	 */
	@Override
	public String toString() {
		return this.extra;
	}
	
}
