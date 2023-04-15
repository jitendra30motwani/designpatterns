package designpattern.structural.composite.calculator;

public class CalculatorUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Expression e1 =  new Number(3);
		
		Expression e2 =  new Number(4);
		
		Expression e3 = new ArithmeticExpression(e1, e2, Operator.MUL);
		
		Expression e4 =  new Number(7);
		
		Expression e5 =  new ArithmeticExpression(e4,e3,Operator.ADD);
		
		System.out.println("Evaluate e5: "+e5.evaluate());
		
	}

}
