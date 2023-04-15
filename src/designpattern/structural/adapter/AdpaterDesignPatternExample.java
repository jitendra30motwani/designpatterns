/**
 * 
 */
package designpattern.structural.adapter;

/**
 * @author 91978
 *
 *Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate
 *
 */
public class AdpaterDesignPatternExample {

	/**
	 * 
	 */
	public AdpaterDesignPatternExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdapterWeightMachine adapterWeightMachine = new AdapterWeightMachineImpl(new BabyWeightMachine());
		
		System.out.println(adapterWeightMachine.getWeightInKg());
		
		
	}

}

//Existing interface - Adaptee
interface WeightMachine{
	
	double getWeightInPound();
	
}
 
class BabyWeightMachine implements WeightMachine{

	@Override
	public double getWeightInPound() {
		return 28.5;
	}
	
}

interface AdapterWeightMachine{
	
	double getWeightInKg();
	
}

class AdapterWeightMachineImpl implements AdapterWeightMachine{

	
	private WeightMachine weightMachine;
	
	public AdapterWeightMachineImpl(WeightMachine weightMachine) {
		
		this.weightMachine = weightMachine;
	
	}
	
	@Override
	public double getWeightInKg() {
		
		double weightInPound = this.weightMachine.getWeightInPound();
		
		double weightInKg = weightInPound * 0.25;
		
		return weightInKg;
	}
	
	
	
}