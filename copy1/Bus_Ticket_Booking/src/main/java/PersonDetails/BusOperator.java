package PersonDetails;

import java.util.Scanner;

import BusDetails.BusOperations;
import SearchDetails.Searching;

public class BusOperator extends Person {
	static Scanner sc = new Scanner(System.in);
	public BusOperator() {
	}

	public BusOperator(int user_Id, String user_Name, String password, String phone_number, String email_Id,
			String address) {
		super(user_Id, user_Name, password, phone_number, email_Id, address);
	}

	

	public static void Menu() {

		boolean flag = true;
		while (flag) {
			System.out.println("Welcome Bus Operator " );
			System.out.println("1.Add Bus\n2.Update Bus\n3.View Bus\n4.Search\n5.\n6.");
			System.out.println("Enter Your Option ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				BusOperations.Add();
				break;
			case 2:
				BusOperations.Update();
				break;
			case 3:
				BusOperations.View();
				break;
			case 4:
				Searching.Search();
				break;
			case 5:
				break;
			case 6:
//				Bus_Route();
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Enter a valid Option");
				break;
			}
		}

	}
}
