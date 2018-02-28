
public class Buss extends Vehicle{
	
	private int numberOfSeats;

	public Buss(String registrationNumber, String color, int numberOfWheels, int numberOfSeats) {
		super(registrationNumber, color, numberOfWheels);
		this.numberOfSeats = numberOfSeats;
	}

	public boolean vehicleStatus () {
		System.out.println("The Buss has been started");
		return true;
	}
	
	public  String getVehicleType() {
		return "Buss";
	}

}
