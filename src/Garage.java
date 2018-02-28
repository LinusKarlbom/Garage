
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
	
	/* This method adds vehicles into the Vehicle Array
	 * Also checks if the garage is already full then throws a garage full exception
	 * */
	
	public void addVehicle (Vehicle vehicle) throws GarageFullException {
		if (numberOfVehicles <= maximumNumberOfVehicles) {
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
			for (int i = 0; i <= index; i++) {
				if (i != index) {
					newVehicleArray[counter] = vehicleArray[i];
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
