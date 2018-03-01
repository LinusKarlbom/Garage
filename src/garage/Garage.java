package garage;
import java.io.Serializable;

import utilities.GarageFullException;
import utilities.NoVehicleWithThatIndexException;
import vehicles.Vehicle;

public class Garage implements Serializable{

	private static final long serialVersionUID = 1L;
	private int maximumNumberOfVehicles;
	private int numberOfVehicles;
	private Vehicle[] vehicleArray;
	
	
	public Garage(int maximumNumberOfVehicles) {
		this.maximumNumberOfVehicles = maximumNumberOfVehicles;
		vehicleArray = new Vehicle[maximumNumberOfVehicles];
		numberOfVehicles = 0;
	}

	public int getMaximumNumberOfVehicles() {
		return maximumNumberOfVehicles;
	}
	
	public void setMaximumNumberOfVehicles(int maximumNumberOfVehicles) {
		this.maximumNumberOfVehicles = maximumNumberOfVehicles;
	}

	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}
	
	public Vehicle[] getVehicles() {
		return vehicleArray;
	}
	
	/* This method adds vehicles into the Vehicle Array
	 * Also checks if the garage is already full then throws a garage full exception
	 * */
	
	public void addVehicle (Vehicle vehicle) throws GarageFullException {
		if (numberOfVehicles < maximumNumberOfVehicles) {
			vehicleArray[numberOfVehicles] = vehicle;
			numberOfVehicles++;
		}
		else {
			throw new GarageFullException();
		}
	}
	
	/* This method removes a vehicle from the array at a given index
	 * This throws an exception if there is no vehicle available for that index
	 * 
	 * */
	
	public void removeVehicle (int index) throws NoVehicleWithThatIndexException {
		if (index < numberOfVehicles && index >= 0) {
			Vehicle[] newVehicleArray = new Vehicle[maximumNumberOfVehicles];
			int counter = 0;
			for (int i = 0; i < numberOfVehicles; i++) {
				if (i != index) {
					newVehicleArray[counter] = vehicleArray[i];
					counter++;
				}
			}
			vehicleArray = newVehicleArray;
			numberOfVehicles--;
		}
		else {
			throw new NoVehicleWithThatIndexException();
		}
	}
	
}
