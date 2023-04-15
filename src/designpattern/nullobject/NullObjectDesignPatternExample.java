/**
 * 
 */
package designpattern.nullobject;

/**
 * @author 91978
 *
 *
 *Null Object design pattern helps to remove the if check for NULL by replacing the NULL return type by
 *Null Object that either performs nothing or default behavior 
 *
 */
public class NullObjectDesignPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle vehicle = VehicleFactory.getVehicle("TRUCK");
		
		printVehicleDetails(vehicle);
		
	}
	
	private static void printVehicleDetails(Vehicle vehicle) {
		//if(vehicle!=null) {
			System.out.println("Seat Capacity:"+vehicle.getSeatCapacity());
			System.out.println("Fuel Capacity:"+vehicle.getFuelCapacity());
		//}
		
	}

}

interface Vehicle{
	
	
	int getSeatCapacity();
	int getFuelCapacity();
	
}

class Bike implements Vehicle{

	@Override
	public int getSeatCapacity() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getFuelCapacity() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	
	
}

class Car implements Vehicle{

	@Override
	public int getSeatCapacity() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getFuelCapacity() {
		// TODO Auto-generated method stub
		return 30;
	}
	
	
	
}


class NullObject implements Vehicle{

	@Override
	public int getSeatCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFuelCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}

class VehicleFactory{
	
	public static Vehicle getVehicle(String vehicleType) {
		
		if("CAR".equals(vehicleType)) {
			return new Car();
		}else if("BIKE".equals(vehicleType)) {
			return new Bike();
		}else {
			return new NullObject();
		}
	}
	
}
