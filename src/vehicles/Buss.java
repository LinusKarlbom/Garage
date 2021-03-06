package vehicles;
import java.io.Serializable;

public class Buss extends Vehicle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int numberOfSeats;
	private boolean turnedOn;

	public Buss(String registrationNumber, String color, int numberOfWheels, int numberOfSeats) {
		super(registrationNumber, color, numberOfWheels);
		this.numberOfSeats = numberOfSeats;
		turnedOn = false;
	}

	public void toggleVehicle () {
		if(turnedOn) {
			System.out.println("The Bus has been turned off");
		}
		else {
			System.out.println("The Bus has been started");
		}
		turnedOn = !turnedOn;
	}
	
	public  String getVehicleType() {
		return "Buss";
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

}
