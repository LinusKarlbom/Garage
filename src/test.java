
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		GarageHandler garageHandler = new GarageHandler(10);
		try {
			garageHandler.addGarage(10);
			garageHandler.addGarage(20);
		} catch (MaximumNumberOfGaragesReachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vehicle vehicle1 = new MotorCycle("1A", "red", 2, 1);
		Vehicle vehicle2 = new Car("2A", "blue", 4, "gasoline");
		Vehicle vehicle3 = new Car("3A", "green", 4, "gasoline");
		
		try {
			garageHandler.parkVehicle(vehicle1, 1);
			garageHandler.parkVehicle(vehicle2, 1);
			garageHandler.parkVehicle(vehicle3, 1);
			garageHandler.parkVehicle(vehicle2, 0);
		} catch (GarageFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(garageHandler.listAllParkedVehicles(0));
		System.out.println(garageHandler.listAllParkedVehicles(1));
		System.out.println(garageHandler.listAllParkedVehicleTypes(0));
		System.out.println(garageHandler.listAllParkedVehicleTypes(1));
		
		try {
			garageHandler.unparkVehicle(1, 1);
		} catch (NoVehicleWithThatIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println(garageHandler.listAllParkedVehicles(0));
		System.out.println(garageHandler.listAllParkedVehicles(1));
		System.out.println(garageHandler.listAllParkedVehicleTypes(0));
		System.out.println(garageHandler.listAllParkedVehicleTypes(1));
	}

}