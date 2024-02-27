package PersonDetails;

import java.util.Scanner;

import BookingDetails.*;
import Validator.Validate;
import SearchDetails.*;

public class User extends Person {
	private static Scanner sc = new Scanner(System.in);
	

	public User(int user_Id, String user_name, String Password, String phone_number, String email_Id, String address) {
		super(user_Id, user_name, Password, phone_number, email_Id, address);
	}

	public User() {
		super();
	}


	public static void Register() {

		System.out.println("Enter your details to Register");
		
		System.out.println("Enter User Name:");
		String user_Name = Validate.validateUsername();

		System.out.println("Enter User ID:");
		int user_Id = sc.nextInt();

		System.out.println("Enter your Password:");
		String password = Validate.validatePassword();

		System.out.println("Enter your Email-ID:");
		String email_Id = Validate.validateEmail();

		System.out.println("Enter Phone Number:");
		String phone_number = Validate.validateMobileNumber();

		System.out.println("Enter Your Address:");
		sc.nextLine();
		String address = sc.nextLine();

		System.out.println("Welcome " + user_Name);

		User user = new User(user_Id, user_Name, password, phone_number, email_Id, address);
		DatabaseConnection.AddUser(user);
	}

	// ------------------------------------------------------------------------------------------------------------------------------------//

	public static void menu() {
		boolean flag = true;
		while (flag) {
			System.out.println("1. Search");
			System.out.println("2. Book");
			System.out.println("3. Booking History");
			System.out.println("4. Feedback");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Searching.Search();
				break;
			case 2:
				Book.bookTickect();
				break;
			case 3:
				 Book.bookingHistory();
				break;
			case 6:
				// cancelBooking();
				break;
			case 4:
				// feedback();
				break;
			case 5:
				flag = true;
				break;
			default:
				System.out.println("Invalid choice. Please enter a number from 1 to 7.");
			}
		}
	}
}
