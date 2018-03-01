import java.util.Scanner;

public class UItest {

	public static void main(String[] args) {

		boolean exit = false;
		GarageHandler garageHandler = new GarageHandler(10);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!");

		printAvailibleOptions(garageHandler);
		int input = haveUserChooseBetweenAvailibleOptions(scanner);
		exit = executeTheCommand(garageHandler, input, scanner);

		try {
			String vehicleList = garageHandler.listAllParkedVehicles(0);
			if (vehicleList.length() > 0) {
				System.out.println(vehicleList);
			} else {
				System.out.println("There are no vehicles in the garage.");
			}
		} catch (GarageNotFoundException e1) {
			System.out.println("There is no such garage.");
		}

		Vehicle newVehicle = haveUserCreateAVehicle(scanner);
		try {
			garageHandler.parkVehicle(newVehicle, 0);
		} catch (GarageFullException e) {
			System.out.println("The garage is full");
		}

		try {
			String vehicleList = garageHandler.listAllParkedVehicles(0);
			if (vehicleList.length() > 0) {
				System.out.println(vehicleList);
			} else {
				System.out.println("There are no vehicles in the garage.");
			}
		} catch (GarageNotFoundException e1) {
			System.out.println("There is no such garage.");
		}

//		try {
//			garageHandler.unparkVehicle(0, 0);
//		} catch (NoVehicleWithThatIndexException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			String vehicleList = garageHandler.listAllParkedVehicles(0);
//			if (vehicleList.length() > 0) {
//				System.out.println(vehicleList);
//			} else {
//				System.out.println("There are no vehicles in the garage.");
//			}
//		} catch (GarageNotFoundException e1) {
//			System.out.println("There is no such garage.");
//		}
		
		newVehicle = haveUserCreateAVehicle(scanner);
		try {
			garageHandler.parkVehicle(newVehicle, 0);
		} catch (GarageFullException e) {
			System.out.println("The garage is full");
		}

		try {
			String vehicleList = garageHandler.listAllParkedVehicles(0);
			if (vehicleList.length() > 0) {
				System.out.println(vehicleList);
			} else {
				System.out.println("There are no vehicles in the garage.");
			}
		} catch (GarageNotFoundException e1) {
			System.out.println("There is no such garage.");
		}
		
		System.out.println(garageHandler.findVehicle("2", 0).getName());
	}

	private static void printAvailibleOptions(GarageHandler garageHandler) {
		System.out.println("Input 1 in order to create a new garage");
		System.out.println("Input 2 in order to exit the application.");
	}

	private static int haveUserChooseBetweenAvailibleOptions(Scanner scanner) {
		return scanner.nextInt();
	}

	private static boolean executeTheCommand(GarageHandler garageHandler, int input, Scanner scanner) {
		switch (input) {
		case 1:
			System.out.println("How many vehicles do you want the garage to be able to hold?");
			int maximumNumberOfVehicles = scanner.nextInt();
			try {
				garageHandler.addGarage(maximumNumberOfVehicles);
			} catch (MaximumNumberOfGaragesReachedException e) {
				System.out.println("Maximum number of garages reached");
			}
			break;
		case 2:
			return true;
		default:
			System.out.println("Not a valid input");
		}
		return false;
	}

	private static Vehicle haveUserCreateAVehicle(Scanner scanner) {

		boolean InvalidInput = true;
		Vehicle createdVehicle = null;
		while (InvalidInput) {
			System.out.println();
			System.out.println("Input 1 in order to create a car");
			System.out.println("Input 2 in order to create a motorcycle");
			System.out.println("Input 3 in order to create a buss");
			System.out.println("Input 4 in order to create a boat");
			System.out.println("Input 5 in order to create a airplane");

			int vehicleTypeInt = scanner.nextInt();
			InvalidInput = false;

			switch (vehicleTypeInt) {
			case 1:
				createdVehicle = new Car("1", "red", 4, "gasoline");
				break;
			case 2:
				createdVehicle = new Motorcycle("2",  "red", 2, 5);
				break;
			case 3:
				createdVehicle = new Buss("3",  "red", 4, 20);
				break;
			case 4:
				createdVehicle = new Boat("4",  "red", 0, 2);
				break;
			case 5:
				createdVehicle = new Airplane("5",  "red", 3, 2);
				break;
			default:
				InvalidInput = true;
				System.out.println("Invalid input.");
			}
		}

		return createdVehicle;
	}

}
