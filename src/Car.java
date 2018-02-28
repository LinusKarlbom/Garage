
public class Car extends Vehicle {
	
	private String fuelType;

	public Car(String registrationNumber, String color, int numberOfWheels, String fuelType) {
		super(registrationNumber, color, numberOfWheels);
		this.fuelType = fuelType;
	}

	public boolean vehicleStatus () {
		System.out.println("The Car has been started");
		return true;
	}
	
	public  String getVehicleType() {
		return "Car";
	}
}