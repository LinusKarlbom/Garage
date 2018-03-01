package ui;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import garage.Garage;
import utilities.GarageFullException;
import utilities.GarageHandler;
import utilities.GarageNotFoundException;
import utilities.MaximumNumberOfGaragesReachedException;
import utilities.NoVehicleWithThatIndexException;
import vehicles.Airplane;
import vehicles.Boat;
import vehicles.Buss;
import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

public class UI {

	public static void main(String[] args) {

		boolean exit = false;
		GarageHandler garageHandler = new GarageHandler(10);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!");

		while (exit == false) {
			printAvailibleOptions(garageHandler);
			int input = chooseAnOption(scanner);
			exit = executeACommand(garageHandler, input, scanner);
		}
		System.out.println("Goodbye!");
	}

	/*
	 * Prints the options available to the user for a certain GarageHandler
	 * parameter.
	 */
	private static void printAvailibleOptions(GarageHandler garageHandler) {
		if (garageHandler.getNumberOfGarages() > 0) {
			System.out.println();
			System.out.println("Input 1 in order to park a vehicle.");
			System.out.println("Input 2 in order to unpark a vehicle.");
			System.out.println("Input 3 in order to list all parked vehicles.");
			System.out.println("Input 4 in order to list all types of parked vehicles.");
			System.out.println("Input 5 in order to search for a parked vehicles.");
			System.out.println("Input 6 in order to change the maximum capacity of a garage.");
			System.out.println("Input 7 in order to create a new garage.");
			System.out.println("Input 8 in order to save a garage to a file.");
			System.out.println("Input 9 in order to load a garage from a file.");
			System.out.println("Input 10 in order to exit the application.");
		} else {
			System.out.println("Input 1 in order to create a new garage");
			System.out.println("Input 2 in order to load a garage from a file");
			System.out.println("Input 3 in order to exit the application.");
		}
	}

	/*
	 * Takes user input for which option to choose.
	 */
	private static int chooseAnOption(Scanner scanner) {
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}

	/*
	 * Executes the command corresponding to the input parameter.
	 */
	private static boolean executeACommand(GarageHandler garageHandler, int choosenOption, Scanner scanner) {
		if (garageHandler.getNumberOfGarages() > 0) {
			switch (choosenOption) {
			//Park a vehicle.
			case 1:
				int choosenGarage = chooseAGarage(garageHandler, scanner);
				Vehicle vehicle = haveUserCreateAVehicle(scanner);
				try {
					garageHandler.parkVehicle(vehicle, choosenGarage);
				} catch (GarageFullException e) {
					System.out.println("The garage is full, so the parking could not be done.");
				}
				break;
			//Unpark a vehicle.
			case 2:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				int choosenVehicle = chooseAVehicle(garageHandler, choosenGarage, scanner);
				try {
					garageHandler.unparkVehicle(choosenVehicle, choosenGarage);
				} catch (NoVehicleWithThatIndexException e) {
					System.out.println("Write something here");
				}
				break;
			//List all parked vehicles.
			case 3:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				String vehicleList;
				try {
					vehicleList = garageHandler.listAllParkedVehicles(choosenGarage);
					if (vehicleList.length() > 0) {
						System.out.println(vehicleList);
					} else {
						System.out.println("There are no vehicles in the garage.");
					}
				} catch (GarageNotFoundException e2) {
					System.out.println("There is no such garage.");
				}
				break;
			//List all types of parked vehicles.
			case 4:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				try {
					vehicleList = garageHandler.listAllParkedVehicleTypes(choosenGarage);
					if (vehicleList.length() > 0) {
						System.out.println(vehicleList);
					} else {
						System.out.println("There are no vehicles in the garage.");
					}
				} catch (GarageNotFoundException e2) {
					System.out.println("There is no such garage.");
				}
				break;
			//Search for a parked vehicles.
			case 5:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				System.out.println("Input the registration number of the vehicle to search for");
				String registrationNumeber = scanner.nextLine();
				String foundName = garageHandler.findVehicle(registrationNumeber, choosenGarage).getName();
				if (foundName == null) {
					System.out.println("No matching vehicle found.");
				} else {
					System.out.println("The search found: " + foundName);
				}
				break;
			//Change the maximum capacity of a garage.
			case 6:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				System.out.println("How many vehicles do you want the garage to be able to hold?");
				int maximumNumberOfVehicles = scanner.nextInt();
				garageHandler.changeMaximumNumberOfVehiclesForAGarage(maximumNumberOfVehicles, choosenGarage);
				break;
			//Create a new garage.
			case 7:
				System.out.println("How many vehicles do you want the garage to be able to hold?");
				maximumNumberOfVehicles = scanner.nextInt();
				try {
					garageHandler.addGarage(maximumNumberOfVehicles);
				} catch (MaximumNumberOfGaragesReachedException e) {
					System.out.println("Maximum number of garages reached");
				}
				break;
			//Save a garage to a file.
			case 8:
				choosenGarage = chooseAGarage(garageHandler, scanner);
				saveGarage(garageHandler, choosenGarage);
				break;
			//Load a garage from a file.
			case 9:
				loadGarage(garageHandler);
				break;
			//Exit the application.
			case 10:
				return true;
			default:
				System.out.println("Not a valid input");
			}
		} else {
			switch (choosenOption) {
			//Create a new garage.
			case 1:
				System.out.println("How many vehicles do you want the garage to be able to hold?");
				int maximumNumberOfVehicles = scanner.nextInt();
				try {
					garageHandler.addGarage(maximumNumberOfVehicles);
				} catch (MaximumNumberOfGaragesReachedException e) {
					System.out.println("Maximum number of garages reached");
				}
				break;
			//Load a garage from a file.
			case 2:
				loadGarage(garageHandler);
				break;
			//Exit the application.
			case 3:
				return true;
			default:
				System.out.println("Not a valid input");
			}
		}
		return false;
	}

	/*
	 * Has the user choose among the parked vehicles in a garage and returns the
	 * index corresponding to that vehicle.
	 */
	private static int chooseAVehicle(GarageHandler garageHandler, int garageNumber, Scanner scanner) {
		boolean InvalidInput = true;
		int choosenVehicle = 0;
		while (InvalidInput) {
			System.out.print("There exists garages corresponding to the integers ");

			// Get the numbers of commas in garageHandler.listAllParkedVehicles(garage)
			int numberOfCommas;
			try {
				numberOfCommas = garageHandler.listAllParkedVehicles(garageNumber).length()
						- garageHandler.listAllParkedVehicles(garageNumber).replace(",", "").length();

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
		scanner.nextLine();
		return choosenVehicle;
	}

	/*
	 * Has the user choose among the created garages and returns the index
	 * corresponding to that garage.
	 */
	private static int chooseAGarage(GarageHandler garageHandler, Scanner scanner) {
		boolean InvalidInput = true;
		int choosenGarage = 0;
		while (InvalidInput) {
			System.out.print(
					"Choose a garage for which to perform the action. There exists garages corresponding to the integers ");
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
		scanner.nextLine();
		return choosenGarage;
	}

	/*
	 * Has the user create a vehicle and returns that vehicle.
	 */
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
			scanner.nextLine();
			InvalidInput = false;

			System.out.println("Input the registration number of the vehicle");
			String registrationNumeber = scanner.nextLine();
			System.out.println("Input the color of the vehicle");
			String color = scanner.nextLine();
			System.out.println("Input the number of wheels of the vehicle");
			int numberOfWheels = scanner.nextInt();
			scanner.nextLine();

			switch (vehicleTypeInt) {
			//A car is created.
			case 1:
				System.out.println("Input the fuel type of the car");
				String fuelType = scanner.nextLine();
				createdVehicle = new Car(registrationNumeber, color, numberOfWheels, fuelType);
				break;
			//A motorcycle is created.
			case 2:
				System.out.println("Input the cylinder volume of the motorcycle");
				int cylinderVolume = scanner.nextInt();
				createdVehicle = new Motorcycle(registrationNumeber, color, numberOfWheels, cylinderVolume);
				break;
			//A buss is created.
			case 3:
				System.out.println("Input the number of seats for the buss");
				int numberOfSeats = scanner.nextInt();
				createdVehicle = new Buss(registrationNumeber, color, numberOfWheels, numberOfSeats);
				break;
			//A boat is created.
			case 4:
				System.out.println("Input the length of the boat");
				int length = scanner.nextInt();
				createdVehicle = new Boat(registrationNumeber, color, numberOfWheels, length);
				break;
			//An airplane is created.
			case 5:
				System.out.println("Input the number of engines of the airplane");
				int numberOfEngines = scanner.nextInt();
				createdVehicle = new Airplane(registrationNumeber, color, numberOfWheels, numberOfEngines);
				break;
			default:
				InvalidInput = true;
				System.out.println("Invalid input.");
			}
		}

		return createdVehicle;
	}

	/*
	 * Saves a garage to file.
	 */
	private static void saveGarage(GarageHandler garageHandler, int garageIndex) {
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("savedGarage.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(garageHandler.getGarage(garageIndex));
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Loads a garage from file.
	 */
	private static void loadGarage(GarageHandler garageHandler) {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("savedGarage.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Garage garage = (Garage) ois.readObject();
			ois.close();
			try {
				garageHandler.addGarage(garage);
			} catch (MaximumNumberOfGaragesReachedException e) {
				System.out.println("Maximum number of garages reached, so a new one couldn't be added.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
