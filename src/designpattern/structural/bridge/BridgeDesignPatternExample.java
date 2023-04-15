/**
 * 
 * https://refactoring.guru/design-patterns/bridge
 * 
 * Bridge is a structural design pattern that decouples abstraction from its implementation so that the two can very independently. 
 * 
 * 
 */
package designpattern.structural.bridge;

/**
 * @author 91978
 *
 */
public class BridgeDesignPatternExample {

	/**
	 * 
	 */
	public BridgeDesignPatternExample() {
		// TODO Auto-generated constructor stub
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BreatheAbtractor abtractor = new FishBreatheConcrete(new WaterBreatheImplement());
		abtractor.breathe();
	}

}

interface BreatheImplemetor{
	
	void breathe();
	
}

class LandBreatheImplement implements BreatheImplemetor{

	@Override
	public void breathe() {
		
		System.out.print("Breathe From Nose");
		
	}
	
}

class WaterBreatheImplement implements BreatheImplemetor{

	@Override
	public void breathe() {
		
		System.out.print("Breathe From Wings");
		
	}
	
}

abstract class BreatheAbtractor{
	
	BreatheImplemetor breatheImplemetor;
	
	public BreatheAbtractor(BreatheImplemetor breatheImplemetor) {
		this.breatheImplemetor = breatheImplemetor;
	}
	
	abstract void breathe();
	
}

class FishBreatheConcrete extends BreatheAbtractor{

	public FishBreatheConcrete(BreatheImplemetor breatheImplemetor) {
		super(breatheImplemetor);
		// TODO Auto-generated constructor stub
	}

	@Override
	void breathe() {
		// TODO Auto-generated method stub
		breatheImplemetor.breathe();
	}
	
	
	
}

class DogBreatheConcrete extends BreatheAbtractor{

	public DogBreatheConcrete(BreatheImplemetor breatheImplemetor) {
		super(breatheImplemetor);
		// TODO Auto-generated constructor stub
	}

	@Override
	void breathe() {
		// TODO Auto-generated method stub
		breatheImplemetor.breathe();
	}
	
	
	
}
