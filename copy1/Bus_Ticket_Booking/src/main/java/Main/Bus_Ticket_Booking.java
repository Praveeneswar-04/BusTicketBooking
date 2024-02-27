package Main;

import java.util.Scanner;

import ExceptionHandling.Exceptions;
import GuestDetails.*;
import PersonDetails.Account;
import PersonDetails.Administrator;
import PersonDetails.BusOperator;
import PersonDetails.User;

public class Bus_Ticket_Booking {
	static Scanner sc = new Scanner(System.in);
	static boolean flag0 = true;

	public static void main(String[] args) {

		System.out.println("Welcome to XYZ Bus Ticket Booking!");
		try {
			
			 while (flag0) {
				System.out.println("1. Login\n2. Register\n3. Guest\n4. Exit");
				System.out.println("Enter Your Option:");
				int Option = sc.nextInt();

				switch (Option) {
				case 1:
					login();
					break;
				case 2:
					User.Register();
					break;
				case 3:
					Guest.Guest_User();
					break;
				case 4:
					flag0 = false;
					System.out.println("Thank You Visit Again !");
					break;
				default:
					System.out.println("Choose a Valid Option");
					break;
				}
			 }
		} catch (Exception e) {
			Exceptions.handleException(e);
		}
	}

	public static void login() {
		boolean flag = true;
		do {
			try {
				System.out.println("Login As\n1. User\n2. Admin\n3. Bus Operator\n4. Go Back\n5. Exit");
				System.out.println("Enter your Option:");
				int option = sc.nextInt();

				switch (option) {
				case 1:
					String User = "User";
					Account acc = new Account(User);
					acc.login();
					break;
				case 2:
					String Admin = "Admin";
					Account acc1 = new Account(Admin);
					acc1.login();
					break;
				case 3:
					String Operator = "BusOperator";
					Account acc2 = new Account(Operator);
					acc2.login();
					break;
				case 4:
					return;
				case 5:
					flag0 = false;
				default:
					System.out.println("Choose a Valid Option");
					break;
				}
			} catch (Exception e) {
				Exceptions.handleException(e);
			}

		} while (flag);
	}

	public static void Guest() {
	}
}
