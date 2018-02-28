
public class Boat extends Vehicle{
	
	private int length;

	public Boat(String registrationNumber, String color, int numberOfWheels, int length) {
		super(registrationNumber, color, numberOfWheels);
		this.length = length;
	}

	public boolean vehicleStatus () {
		
		System.out.println("The Boat has been started");
		return true;
	}
	
	public  String getVehicleType() {
		return "Boat";
	}
}
