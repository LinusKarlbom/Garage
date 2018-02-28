
public class Garage {

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
	
	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}
	
	public Vehicle[] getVehicles() {
		return vehicleArray;
	}
	
	public void addVehicle (Vehicle vehicle) throws GarageFullException {
		if (numberOfVehicles <= maximumNumberOfVehicles) {
			vehicleArray[numberOfVehicles] = vehicle;
			numberOfVehicles++;
		}
		else {
			throw new GarageFullException();
		}
	}
	
	public void removeVehicle (int index) throws NoVehicleWithThatIndexException {
		if (index < numberOfVehicles && index >= 0) {
			Vehicle[] newVehicleArray = new Vehicle[maximumNumberOfVehicles];
			int counter = 0;
			for (int i = 0; i <= index; i++) {
				if (i != index) {
					newVehicleArray[counter] = vehicleArray[i];
				}
			}
			vehicleArray = newVehicleArray;
		}
		else {
			throw new NoVehicleWithThatIndexException();
		}
	}
	
}
