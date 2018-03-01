package ui;
import utilities.GarageFullException;
import utilities.GarageHandler;
import utilities.GarageNotFoundException;
import utilities.MaximumNumberOfGaragesReachedException;
import utilities.NoVehicleWithThatIndexException;
import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

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
		
		Vehicle vehicle1 = new Motorcycle("1A", "red", 2, 1);
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
		
		try {
			System.out.println(garageHandler.listAllParkedVehicles(0));
			System.out.println(garageHandler.listAllParkedVehicles(1));
			System.out.println(garageHandler.listAllParkedVehicleTypes(0));
			System.out.println(garageHandler.listAllParkedVehicleTypes(1));
		} catch (GarageNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			garageHandler.unparkVehicle(1, 1);
		} catch (NoVehicleWithThatIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			System.out.println(garageHandler.listAllParkedVehicles(0));
			System.out.println(garageHandler.listAllParkedVehicles(1));
			System.out.println(garageHandler.listAllParkedVehicleTypes(0));
			System.out.println(garageHandler.listAllParkedVehicleTypes(1));
		} catch (GarageNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}