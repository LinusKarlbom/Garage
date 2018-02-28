
public abstract class Vehicle {

	private String registrationNumber;
	private String color;
	private int numberOfWheels;
	
	
	public Vehicle(String registrationNumber, String color, int numberOfWheels) {
		
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public String getColor() {
		return color;
	}


	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	// this method gives the current status of the vehicle
	public abstract boolean vehicleStatus ();
	
	//this method will tell the type of the entered vehicle
	public abstract String getVehicleType();
	
}
