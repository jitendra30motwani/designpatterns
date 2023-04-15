/**
 * 
 */
package designpattern.creational.factory;

/**
 * @author 91978
 *
 *Factory pattern is a creation design pattern that allows to create an object based on some condition to avoid duplicate code
 *
 *
 */
public class FactoryMethodDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape shape = ShapeFactory.getShape("Square");
		
		shape.draw();
		
	}

}

interface Shape{
	
	void draw();
	
}

class Circle implements Shape{

	@Override
	public void draw() {
		
		System.out.println("Circle");
		
	}
	
	
	
}

class Square implements Shape{

	@Override
	public void draw() {
		
		System.out.println("Square");
		
	}
	
	
	
}

class ShapeFactory{
	
	private static Shape shape;
	
	public static Shape getShape(String shapeType) {
		
		switch (shapeType) {
		case "Circle":
			shape = new Circle();
			break;

		default:
			shape = new Square();
			break;
		}
		
		return shape;
		
	}
	
}