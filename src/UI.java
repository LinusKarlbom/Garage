import java.util.Scanner;

public class UI {

	public static void main(String[] args) {

		boolean exit = false;
		GarageHandler garageHandler = new GarageHandler(10);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!");
		
		while(exit == false) {
			printAvailibleOptions(garageHandler);
			int input = haveUserChooseBetweenAvailibleOptions(scanner);
			executeTheCommand(garageHandler, input, scanner);	
		}		
	}
	
	public static void printAvailibleOptions(GarageHandler garageHandler) {
		if (garageHandler.getNumberOfGarages() > 0) {
			System.out.println("Input 1 in order to list all parked vehicles.");
			System.out.println("Input 2 in order to list all types of parked vehicles.");
			System.out.println("Input 3 in order to park a vehicle.");
			System.out.println("Input 4 in order to unpark a vehicle.");
			System.out.println("Input 5 in order to create a new garage");
			System.out.println("Input 6 in order to exit the application.");
		}
		else {
			System.out.println("Input 1 in order to create a new garage");
			System.out.println("Input 2 in order to exit the application.");
		}
	}
	
	public static int haveUserChooseBetweenAvailibleOptions(Scanner scanner) {
		return scanner.nextInt();
	}
	
	public static void executeTheCommand(GarageHandler garageHandler, int input, Scanner scanner){
		if (garageHandler.getNumberOfGarages() > 0) {
			int userInput;
			switch(input) {
			case 1:
				userInput = chooseAGarage(garageHandler, scanner);
				System.out.println(garageHandler.listAllParkedVehicles(userInput));
				break;
			case 2:
				userInput = chooseAGarage(garageHandler, scanner);
				System.out.println(garageHandler.listAllParkedVehicleTypes(userInput));
				break;
			case 3:
				userInput = chooseAGarage(garageHandler, scanner);
				Vehicle vehicle = haveUserCreateAVehicle(scanner);
				try {
					garageHandler.parkVehicle(vehicle, userInput);
				}
				catch (GarageFullException e) {
					
				}
				break;
			case 4:
				userInput = chooseAGarage(garageHandler, scanner);
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Not a valid input");
			}
		}
		else {
			switch(input) {
			case 1:
				//do something
				break;
			case 2:
				break;
			default:
				System.out.println("Not a valid input");
			}
		}
	}
	
	public static int chooseAGarage (GarageHandler garageHandler, Scanner scanner) {
		System.out.println("");
		//have to do much more here
		return scanner.nextInt();
	}
	
	public static Vehicle haveUserCreateAVehicle(Scanner scanner){
		return null;
	}
	
	public static boolean yesOrNoPrompt(Scanner scanner) {
		boolean response = false;
		String responseString;
		boolean gotAnyValidResponse = false;
		
		while(!gotAnyValidResponse) {
			System.out.print("Input Y for yes, or N for No: ");
			responseString = scanner.nextLine();
			if (responseString.equals("Y")) {
				response = true;
				gotAnyValidResponse = true;
			}
			else if (responseString.equals("N")) {
				response = false;
				gotAnyValidResponse = true;
			}
			else{
				System.out.println();
				System.out.print("Invalid Input. Please input either Y or N");
			}
		}
		System.out.println();
		return response;
	}

}
