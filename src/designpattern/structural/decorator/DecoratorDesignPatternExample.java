/**
 * 
 */
package designpattern.structural.decorator;

/**
 * @author 91978
 *
 *Decorator is a structural design pattern that lets you new behavior 
 *to be added to the objects and these objects are wrapped within the special objects that contain such special behavior  
 *
 *To avoid class explosion
 *
 */
public class DecoratorDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*BasePizza farmHouse = new Farmhouse();
		
		System.out.println(farmHouse.cost());
		
		BasePizza farmHouseExraCheese = new ExtraCheese(farmHouse);
		
		System.out.println(farmHouseExraCheese.cost());
		
		BasePizza farmHouseExraCheeseMushroom = new Mushroom(farmHouseExraCheese);
		
		System.out.println(farmHouseExraCheeseMushroom.cost());*/
		
		BasePizza basePizza = new Mushroom(new ExtraCheese(new Farmhouse()));
		
		System.out.println(basePizza.cost());

	}

}

abstract class BasePizza{
	
	public abstract int cost();
	
} 

class Farmhouse extends BasePizza{

	@Override
	public int cost() {
		
		return 100;
	}
	
	
	
}

class VegDelight extends BasePizza{

	@Override
	public int cost() {
		
		return 200;
	}
	
	
	
}

abstract class ToppingDecorator extends BasePizza{
	
	
}

class ExtraCheese extends ToppingDecorator{

	BasePizza basePizza;
	
	public ExtraCheese(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	
	@Override
	public int cost() {
		return this.basePizza.cost() + 10;
	}
	
	
	
}


class Mushroom extends ToppingDecorator{

	BasePizza basePizza;
	
	public Mushroom(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	
	@Override
	public int cost() {
		return this.basePizza.cost() + 20;
	}
	
	
	
}
