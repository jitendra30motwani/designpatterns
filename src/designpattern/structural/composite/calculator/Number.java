/**
 * 
 */
package designpattern.structural.composite.calculator;

/**
 * @author 91978
 *
 */
public class Number implements Expression{
	
	private int value;
	
	public Number(int value) {
		
		this.value = value;
		
	}
	
	public int evaluate() {
		
		return this.value;
	}
	
}
