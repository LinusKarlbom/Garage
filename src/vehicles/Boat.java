package vehicles;
import java.io.Serializable;

public class Boat extends Vehicle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int length;
	private boolean turnedOn;

	public Boat(String registrationNumber, String color, int numberOfWheels, int length) {
		super(registrationNumber, color, numberOfWheels);
		this.length = length;
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
		return "Boat";
	}

	public int getLength() {
		return length;
	}
	
}
