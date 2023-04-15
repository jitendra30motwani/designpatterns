/**
 * 
 */
package designpattern.structural.composite.calculator;

/**
 * @author 91978
 *
 */
public class ArithmeticExpression implements Expression {

	private Expression left;
	private Expression right;
	
	private Operator opertion;
	
	public ArithmeticExpression(Expression left , Expression right, Operator operation) {
		
		this.left = left;
		this.right = right;
		this.opertion = operation;
				
	}
	
	public int evaluate() {
		int ans = 0;
		switch (this.opertion) {
		case ADD:
			ans = this.left.evaluate() + this.right.evaluate();
			break;
		
		case SUB:
			ans = this.left.evaluate() - this.right.evaluate();
			break;
			
		case MUL:
			ans = this.left.evaluate() * this.right.evaluate();
			break;
			
		default:
			ans = this.left.evaluate() / this.right.evaluate();
			break;
		}
		
		return ans;
		
	}
	
}
