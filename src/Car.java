
public class Car extends Vehicle {
	
	private String fuelType;
	private boolean turnedOn;

	public Car(String registrationNumber, String color, int numberOfWheels, String fuelType) {
		super(registrationNumber, color, numberOfWheels);
		this.fuelType = fuelType;
		turnedOn = false;
	}

	public void toggleVehicle () {
		if(turnedOn) {
			System.out.println("The Car has been turned off");
		}
		else {
			System.out.println("The Car has been started");
		}
		turnedOn = !turnedOn;
	}
	
	public  String getVehicleType() {
		return "Car";
	}

	public String getFuelType() {
		return fuelType;
	}
	
}