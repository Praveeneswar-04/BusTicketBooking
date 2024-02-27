package SearchDetails;

import java.util.List;
import java.util.Scanner;

import BusDetails.BusOperations;
import ExceptionHandling.Exceptions;

public class Searching {

	static Scanner sc = new Scanner(System.in);
	static List<Bus> values = BusOperations.DbtoList();

	static Bus_List object = new Bus_List();

	public static void Search() {

		BusOperations.DbtoList();
		System.out.println("Buses ");
		object.view(values);
		System.out.println(
				"1. Search By Bus Name\n2. Search by Place\n3. Sort By Price\n4. Sort By Name\n5. Filter By Price\n6. Filter By Seat\n.7. Exit");
		System.out.println("Enter from the option");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("Enter the Name:");
			sc.nextLine();
			String name = sc.nextLine();
			object.searchByName(values, name);
			break;
		case 2:
			System.out.println("Enter the Place");
			sc.nextLine();
			String Place = sc.nextLine();
			object.searchByPlace(values, Place);
			break;
		case 3:
			object.sortByPrice(values);
			// Implement sort by price
			break;
		case 4:
			object.sortByName(values);
			// Implement sort by name
			break;
		case 5:
			System.out.println("Enter Your price Range:\nMin:");
			try {
				double min = sc.nextDouble();
				System.out.println("Max");
				double max = sc.nextDouble();
				object.filterByPriceRange(values, option, option);
			} catch (Exception e) {
				Exceptions.handleException(e);
			}
			// Implement filter by price
			break;
		case 6:
			System.out.println("Enter the Number of Seats");
			try {
				int seats = sc.nextInt();
				object.filterBySeatsAvailable(values, option);
			} catch (Exception e) {
				Exceptions.handleException(e);
			} // Implement filter by seat
			break;
		case 7:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid choice. Please enter a number between 1 and 7.");
		}
	}

}
