/**
 * 
 */
package designpattern.creational.abstractfactory;

/**
 * @author 91978
 *
 *Abstract Factory is a creational design pattern that allows to define factory of factories to group similar kind of objects 
 *as part of one factory and then let a particular factory to return a particular object based on some condition
 *
 */
public class AbstractFactoryDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VehicleFactory vehicleFactory = VehicleFactoryCreator.getVehicleFactory("Luxury");
		
		Vehicle vehicle=vehicleFactory.getVehicle("BMW");
		
		vehicle.speed();
		
		
		
	}

}

interface Vehicle{
	
	void speed();
	
}

class BMW implements Vehicle{

	@Override
	public void speed() {
		System.out.println("BMW");
		
	}
	
}

class Swift implements Vehicle{

	@Override
	public void speed() {
		System.out.println("Swift");
		
	}
	
	
}

class Hyundai implements Vehicle{

	@Override
	public void speed() {
		System.out.println("Hyundai");
		
	}
	
	
}

class Indigo implements Vehicle{

	@Override
	public void speed() {
		System.out.println("Indigo");
		
	}
	
	
	
}

interface VehicleFactory{
	
	Vehicle getVehicle(String vehicleType);
	
}

class LuxuryVehicleFactory implements VehicleFactory{
	
	private static Vehicle vehicle;
	
	public Vehicle getVehicle(String vehicleType) {
		
		switch (vehicleType) {
		case "BMW":
			vehicle = new BMW();
			break;

		default:
			vehicle = new Swift();
			break;
		}
		
		return vehicle;
		
	}
	
}


class OrdinaryVehicleFactory implements VehicleFactory{
	
	private static Vehicle vehicle;
	
	public Vehicle getVehicle(String vehicleType) {
		
		switch (vehicleType) {
		case "Hyundai":
			vehicle = new Hyundai();
			break;

		default:
			vehicle = new Indigo();
			break;
		}
		
		return vehicle;
		
	}
	
}

class VehicleFactoryCreator{
	
	private static VehicleFactory vehicleFactory; 
	
	public static VehicleFactory getVehicleFactory(String factoryType) {
		
		switch (factoryType) {
		case "Ordinary":
			vehicleFactory = new OrdinaryVehicleFactory();
			break;

		default:
			vehicleFactory = new LuxuryVehicleFactory();
			break;
		}
		
		return vehicleFactory;
		
	}
	
}


