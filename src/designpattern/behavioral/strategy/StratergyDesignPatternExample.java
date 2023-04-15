/**
 * 
 */
package designpattern.behavioral.strategy;

/**
 * @author 91978
 *
 *Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
 *
 */
public class StratergyDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DriveStrategy driveSpecialStrategy = new SpecialStrategy();
		
		VehicleImpl vehicleImpl = new GoodsVehicle(driveSpecialStrategy);
		
		vehicleImpl.drive();
		
		DriveStrategy driveNormalStrategy = new NormalStrategy();
		
		VehicleImpl vehicleImpl1 = new PassengerVehicle(driveNormalStrategy);
		
		vehicleImpl1.drive();
		

	}

}

/**
 * @author 91978
 *
 *Without Strategy
 *

class Vehicle{

	public void drive() {

		System.out.println("Normal drive");
		
	}
		
	
}

class GoodsVehicle extends Vehicle{
	
	public void drive() {

		System.out.println("Special drive");
		
	}
	
}

class SportsVehicle extends Vehicle{
	
	public void drive() {

		System.out.println("Special drive");
		
	}
}

class PassengerVehicle extends Vehicle{

	
}

class OffRoadVehicle extends Vehicle{
	
	
}
 */

interface DriveStrategy{
	
	void drive();
	
}

class NormalStrategy implements DriveStrategy {

	@Override
	public void drive() {
		System.out.println("Normal drive");
		
	}
	
	
}

class SpecialStrategy implements DriveStrategy{
	
	public void drive() {

		System.out.println("Special drive");
		
	}
}

interface Vehicle{
	
	void drive();
}

class VehicleImpl implements Vehicle{
	
	DriveStrategy driveStrategy;
	
	public VehicleImpl(DriveStrategy driveStrategy) {
		this.driveStrategy = driveStrategy;
	}

	@Override
	public void drive() {
		
		this.driveStrategy.drive();
		
	}
	
	
}

class GoodsVehicle extends VehicleImpl{
	
	public GoodsVehicle(DriveStrategy driveStrategy) {
		super(driveStrategy);
	}
	
}

class SportsVehicle extends VehicleImpl{
	
	public SportsVehicle(DriveStrategy driveStrategy) {
		super(driveStrategy);
	}
	
}

class PassengerVehicle extends VehicleImpl{
	
	public PassengerVehicle(DriveStrategy driveStrategy) {
		super(driveStrategy);
	}
	
}

class OffRoadVehicle extends VehicleImpl{
	
	public OffRoadVehicle(DriveStrategy driveStrategy) {
		super(driveStrategy);
	}
	
}
