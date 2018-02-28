
public class MotorCycle extends Vehicle {
	
	private int cylinderVolume;

	public MotorCycle(String registrationNumber, String color, int numberOfWheels, int cylinderVolume) {
		super(registrationNumber, color, numberOfWheels);
		this.cylinderVolume = cylinderVolume;
	}

	public boolean vehicleStatus () {
		System.out.println("The motorcycle has been started");
		return true;
	}
	
	public  String getVehicleType() {
		return "Motorcycle";
	}

}
