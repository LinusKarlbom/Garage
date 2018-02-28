public class GarageHandler {

	Garage[] garages;
	int numberOfGarages;
	int maximumNumberOfGarages;
	
	public GarageHandler(int maximumNumberOfGarages) {
		this.maximumNumberOfGarages = maximumNumberOfGarages;
		garages = new Garage[maximumNumberOfGarages];
		numberOfGarages = 0;
	}
	
	public void addGarage (int maximumNumberOfVehicles) {
		if (numberOfGarages < maximumNumberOfGarages) {
			garages[numberOfGarages] = new Garage(maximumNumberOfVehicles);
			numberOfGarages++;
		}
		else {
			throw new 
		}
	}

	public String listAllParkedVehicleTypes(int garageIndex) {
		
		StringBuilder vehiclesList = new StringBuilder();
		int numberOfVehicles = garages[garageIndex].getNumberOfVehicles();
		Vehicle[] vehicles = garages[garageIndex].getVehicles();
		for(int i = 0; i < numberOfVehicles; i++) {
			if (vehiclesList.toString().indexOf(vehicles[i].getVehicleType()) == -1) {
				vehiclesList.append(vehicles[i].getVehicleType()+ " ");
			}
		}
		if (numberOfVehicles > 0) {
			vehiclesList.deleteCharAt(vehiclesList.length()-1);
		}
		
		return vehiclesList.toString();
	}
	
	//Returns one of the Vehicles in a Garage with matching registration number if one exists. Returns null if no matching Vehicle is found.
	public Vehicle findVehicle (String registrationNumber, int garageIndex) {
		int numberOfVehicles = garages[garageIndex].getNumberOfVehicles();
		Vehicle foundVehicle = null;
		Vehicle[] vehicles = garages[garageIndex].getVehicles();
		for(int i = 0; i < numberOfVehicles; i++) {
			if (vehicles[i].getRegistrationNumber().equals(registrationNumber)) {
				foundVehicle = vehicles[i];
			}
		}
		return foundVehicle;
	}
	
	public void parkVehicle (Vehicle vehicle, int garageIndex) throws GarageFullException {
		garages[garageIndex].addVehicle(vehicle);
	}
	
	public void unparkVehicle (int vehicleIndex, int garageIndex) throws NoVehicleWithThatIndexException {
		garages[garageIndex].removeVehicle(vehicleIndex);
	}
	
}
