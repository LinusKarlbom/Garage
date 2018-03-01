package vehicles;
import java.io.Serializable;

public abstract class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	private String registrationNumber;
	private String color;
	private int numberOfWheels;

	public Vehicle(String registrationNumber, String color, int numberOfWheels) {

		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
	}

	public String getName() {
		return color + " " + getVehicleType() + " with registrationNumber: " + registrationNumber;
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

	/*
	 * This method changes the current turnedOn status of the vehicle and prints a
	 * description of what is happening.
	 */
	public abstract void toggleVehicle();

	// this method will tell the type of the vehicle
	public abstract String getVehicleType();

}
