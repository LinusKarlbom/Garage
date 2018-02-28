public class GarageHandler {

	public static String listAllParkedVehicleTypes(Garage garage) {
		
		StringBuilder vehiclesList = new StringBuilder();
		int numberOfVehicles = garage.getNumberOfVehicles();
		Vehicle[] vehicles = garage.getVehicles();
		for(int i = 0; i < numberOfVehicles; i++) {
			if (vehiclesList.toString().indexOf(vehicles[i].getVehicleType()) == -1) {
				vehiclesList.append(vehicles[i].getVehicleType()));
			}
		}
		return "";
	}
	
	//Returns one of the Vehicles in a Garage with matching registration number if one exists. Returns null if no matching Vehicle is found.
	public static Vehicle findVehicle (Garage garage, String registrationNumber) {
		int numberOfVehicles = garage.getNumberOfVehicles();
		Vehicle foundVehicle = null;
		Vehicle[] vehicles = garage.getVehicles();
		for(int i = 0; i < numberOfVehicles; i++) {
			if (vehicles[i].getRegistrationNumber().equals(registrationNumber)) {
				foundVehicle = vehicles[i];
			}
		}
		return foundVehicle;
	}
	
}
