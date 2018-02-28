
public class Airplane extends Vehicle {
	
	private int numberOfEngines;

	public Airplane(String registrationNumber, String color, int numberOfWheels, int numberOfEngines) {
		super(registrationNumber, color, numberOfWheels);
		this.numberOfEngines = numberOfEngines;
	}

	public boolean vehicleStatus () {
		System.out.println("The Airplane has been started");
		return true;
	}
	
	public  String getVehicleType() {
		return "Airplane";
	}

}
