import java.util.Scanner;



public class UI {

	public static void main(String[] args) {

		boolean exit = false;
		GarageHandler garageHandler = new GarageHandler(10);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!");

		while (exit == false) {
			printAvailibleOptions(garageHandler);
			int input = haveUserChooseBetweenAvailibleOptions(scanner);
			exit = executeTheCommand(garageHandler, input, scanner);
		}
	}

	private static void printAvailibleOptions(GarageHandler garageHandler) {
		if (garageHandler.getNumberOfGarages() > 0) {
			System.out.println();
			System.out.println("Input 1 in order to park a vehicle..");
			System.out.println("Input 2 in order to unpark a vehicle.");
			System.out.println("Input 3 in order to list all parked vehicles.");
			System.out.println("Input 4 in order to list all types of parked vehicles.");
			System.out.println("Input 5 in order to change the maximum capacity of a garage.");
			System.out.println("Input 6 in order to create a new garage");
			System.out.println("Input 7 in order to exit the application.");
		} else {
			System.out.println("Input 1 in order to create a new garage");
			System.out.println("Input 2 in order to exit the application.");
		}
	}

	private static int haveUserChooseBetweenAvailibleOptions(Scanner scanner) {
		return scanner.nextInt();
	}

	private static boolean executeTheCommand(GarageHandler garageHandler, int input, Scanner scanner) {
		if (garageHandler.getNumberOfGarages() > 0) {
			switch (input) {
			case 1:
				int choosenGarage = chooseAGarage(garageHandler, scanner);
				Vehicle vehicle = haveUserCreateAVehicle(scanner);
				try {
					garageHandler.parkVehicle(vehicle, choosenGarage);
				} catch (GarageFullException e) {
					System.out.println("The garage is full, so the parking could not be done.");
				}
				break;
			case 2:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				int choosenVehicle = chooseAVehicle(garageHandler, choosenGarage, scanner);
				try {
					garageHandler.unparkVehicle(choosenVehicle, choosenGarage);
				} catch (NoVehicleWithThatIndexException e) {
					System.out.println("Write something here");
				}
				break;
			case 3:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				try {
					System.out.println(garageHandler.listAllParkedVehicles(choosenGarage));
				} catch (GarageNotFoundException e1) {
					System.out.println("There is no such garage.");
				}
				break;
			case 4:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				try {
					System.out.println(garageHandler.listAllParkedVehicleTypes(choosenGarage));
				} catch (GarageNotFoundException e1) {
					System.out.println("There is no such garage.");
				}
				break;
			case 5:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				System.out.println("How many vehicles do you want the garage to be able to hold?");
				int maximumNumberOfVehicles = scanner.nextInt();
				garageHandler.changeMaximumNumberOfVehiclesForAGarage(maximumNumberOfVehicles, choosenGarage);
				break;
			case 6:
				System.out.println("How many vehicles do you want the garage to be able to hold?");
				maximumNumberOfVehicles = scanner.nextInt();
				try {
					garageHandler.addGarage(maximumNumberOfVehicles);
				} catch (MaximumNumberOfGaragesReachedException e) {
					System.out.println("Maximum number of garages reached");
				}
				break;
			case 7:
				return true;
			default:
				System.out.println("Not a valid input");
			}
		} else {
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
		}
		return false;
	}

	private static int chooseAVehicle(GarageHandler garageHandler, int garage, Scanner scanner) {
		boolean InvalidInput = true;
		int choosenVehicle = 0;
		while (InvalidInput) {
			System.out.print("There exists garages corresponding to the integers ");
			
			//Get the numbers of commas in garageHandler.listAllParkedVehicles(garage)
			int numberOfCommas;
			try {
				numberOfCommas = garageHandler.listAllParkedVehicles(garage).length() - garageHandler.listAllParkedVehicles(garage).replace(",", "").length();
				
				for (int i = 0; i < numberOfCommas; i++) {
					System.out.println(i + ", ");
				}
				
				choosenVehicle = scanner.nextInt();
				if (choosenVehicle >= 0 && choosenVehicle < garageHandler.getNumberOfGarages()) {
					InvalidInput = false;
				} else {
					System.out.println("Invalid input.");
				}
			} catch (GarageNotFoundException e) {
				e.printStackTrace();
			}

		}
		return choosenVehicle;
	}

	private static int chooseAGarage(GarageHandler garageHandler, Scanner scanner) {
		boolean InvalidInput = true;
		int choosenGarage = 0;
		while (InvalidInput) {
			System.out.print("Choose a garage for which to perform the action. There exists garages corresponding to the integers ");
			for (int i = 0; i < garageHandler.getNumberOfGarages(); i++) {
				System.out.println(i + ", ");
			}

			choosenGarage = scanner.nextInt();
			if (choosenGarage >= 0 && choosenGarage < garageHandler.getNumberOfGarages()) {
				InvalidInput = false;
			} else {
				System.out.println("Invalid input.");
			}

		}
		return choosenGarage;
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
				createdVehicle = new Motorcycle("2", "red", 2, 5);
				break;
			case 3:
				createdVehicle = new Buss("3", "red", 4, 20);
				break;
			case 4:
				createdVehicle = new Boat("4", "red", 0, 2);
				break;
			case 5:
				createdVehicle = new Airplane("5", "red", 3, 2);
				break;
			default:
				InvalidInput = true;
				System.out.println("Invalid input.");
			}
		}

		return createdVehicle;
	}
}
