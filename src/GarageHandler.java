public class GarageHandler {

	Garage[] garages;
	int numberOfGarages;
	int maximumNumberOfGarages;

	public GarageHandler(int maximumNumberOfGarages) {
		this.maximumNumberOfGarages = maximumNumberOfGarages;
		garages = new Garage[maximumNumberOfGarages];
		numberOfGarages = 0;
	}

	/*
	 * Adds a Garage which can hold maximumNumberOfVehicles to the list of Garages
	 * unless the maximum number of garages is reached. Throws a
	 * MaximumNumberOfGaragesReachedException if the maximum number of garages is
	 * reached
	 */
	public void addGarage(int maximumNumberOfVehicles) throws MaximumNumberOfGaragesReachedException {
		if (numberOfGarages < maximumNumberOfGarages) {
			garages[numberOfGarages] = new Garage(maximumNumberOfVehicles);
			numberOfGarages++;
		} else {
			throw new MaximumNumberOfGaragesReachedException();
		}
	}

	/*
	 * Returns a String with a list of all Vehicles among the Vehicles in the Garage
	 * corresponding to the garageIndex parameter if it exists and throws a
	 * GarageNotFoundException if it doesn't exist.
	 */
	public String listAllParkedVehicles(int garageIndex) throws GarageNotFoundException {
		if (garageIndex >= numberOfGarages) {
			throw new GarageNotFoundException();
		}
		StringBuilder vehicleList = new StringBuilder();
		int numberOfVehicles = garages[garageIndex].getNumberOfVehicles();
		Vehicle[] vehicles = garages[garageIndex].getVehicles();
		//// loops through all the vehicles in the relevant garage
		for (int i = 0; i < numberOfVehicles; i++) {
			vehicleList.append(vehicles[i].getName() + ", ");
		}
		// Deletes the unwanted comma and whitespace characters at the end of
		// vehicleTypeList.
		if (numberOfVehicles > 0) {
			vehicleList.deleteCharAt(vehicleList.length() - 1);
			vehicleList.deleteCharAt(vehicleList.length() - 1);
		}

		return vehicleList.toString();
	}

	/*
	 * Returns a String with a list of all VehicleTypes among the Vehicles in the
	 * Garage corresponding to the garageIndex parameter if it exists and throws a
	 * GarageNotFoundException if it doesn't exist.
	 */
	public String listAllParkedVehicleTypes(int garageIndex) throws GarageNotFoundException {
		if (garageIndex >= numberOfGarages) {
			throw new GarageNotFoundException();
		}
		StringBuilder vehicleTypeList = new StringBuilder();
		int numberOfVehicles = garages[garageIndex].getNumberOfVehicles();
		Vehicle[] vehicles = garages[garageIndex].getVehicles();
		//// loops through all the vehicles in the relevant garage
		for (int i = 0; i < numberOfVehicles; i++) {
			// Checks if the VehicleType exists in the vehicleTypeList.
			if (vehicleTypeList.toString().indexOf(vehicles[i].getVehicleType()) == -1) {
				vehicleTypeList.append(vehicles[i].getVehicleType() + ", ");
			}
		}
		// Deletes the unwanted comma and whitespace characters at the end of
		// vehicleTypeList.
		if (numberOfVehicles > 0) {
			vehicleTypeList.deleteCharAt(vehicleTypeList.length() - 1);
			vehicleTypeList.deleteCharAt(vehicleTypeList.length() - 1);
		}

		return vehicleTypeList.toString();
	}

	/*
	 * Returns one of the Vehicles in a Garage with matching registration number if
	 * one exists. Returns null if no matching Vehicle is found.
	 */
	public Vehicle findVehicle(String registrationNumber, int garageIndex) {
		int numberOfVehicles = garages[garageIndex].getNumberOfVehicles();
		Vehicle foundVehicle = null;
		Vehicle[] vehicles = garages[garageIndex].getVehicles();
		// loops through all the vehicles in the relevant garage and searches for the
		// ones with the right registrationNumber.
		for (int i = 0; i < numberOfVehicles; i++) {
			if (vehicles[i].getRegistrationNumber().equals(registrationNumber)) {
				foundVehicle = vehicles[i];
			}
		}
		return foundVehicle;
	}

	/*
	 * Adds a Vehicle to the Garage corresponding to the garageIndex parameter.
	 * 
	 */
	public void parkVehicle(Vehicle vehicle, int garageIndex) throws GarageFullException {
		garages[garageIndex].addVehicle(vehicle);
	}

	/*
	 * Removes the Vehicle corresponding to the vehicleIndex parameter from the
	 * Garage corresponding to the garageIndex parameter.
	 */
	public void unparkVehicle(int vehicleIndex, int garageIndex) throws NoVehicleWithThatIndexException {
		garages[garageIndex].removeVehicle(vehicleIndex);
	}

	/*
	 * Changes the maximum number of Vehicles for the Garage corresponding to the
	 * garageIndex parameter.
	 */
	public void changeMaximumNumberOfVehiclesForAGarage(int maximumNumberOfVehicles, int garageIndex) {
		garages[garageIndex].setMaximumNumberOfVehicles(maximumNumberOfVehicles);
	}

	public int getNumberOfGarages() {
		return numberOfGarages;
	}

	public int getMaximumNumberOfGarages() {
		return maximumNumberOfGarages;
	}

}
