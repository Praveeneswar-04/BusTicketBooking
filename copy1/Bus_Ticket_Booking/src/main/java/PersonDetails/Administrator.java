package PersonDetails;

import java.util.Scanner;
import SearchDetails.*;
import BusDetails.*;

public class Administrator extends Person {
	static Scanner sc = new Scanner(System.in);

	public Administrator(int user_Id, String user_Name, String password, String phone_number, String email_Id,
			String address) {
		super(user_Id, user_Name, password, phone_number, email_Id, address);
	}

	public Administrator() {
	}

	

	public static void Menu() {

		boolean flag = true;
		while (flag) {

			System.out.println("1.Add Bus\n2.Remove Bus\n3.Update Bus\n4.View Bus\n5.Search\n6.Exit");

			System.out.println("*".repeat(10));

			int option = sc.nextInt();
			switch (option) {
			case 1:
				BusOperations.Add();
				break;
			case 2:
				BusOperations.Delete();
				break;
			case 3:
				BusOperations.Update();
				break;
			case 4:
				BusOperations.View();
				break;
			case 5:
				Searching.Search();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Enter a valid Option");
				break;
			}
		}

	}
}
