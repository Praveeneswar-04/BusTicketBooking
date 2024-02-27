package PaymentDetails;

import java.util.Scanner;

public class Payment {
static Scanner scanner = new Scanner(System.in);
	
	public static int paymentmethod(){
	
		System.out.println("Payment Type: ");
		System.out.println("1. Cash \n2. Card\n3. Mobile Wallet");
		int choise = scanner.nextInt();
		switch(choise)
		{
		case 1:
			Cash cash = new Cash();
			break;
			
		case 2:
			Card card = new Card();
			break;
		case 3:
			MobileWallet wallet = new MobileWallet();
			break;
			
		default:
			System.out.println("Invalid choice. Please enter a valid option.");
}
		return choise;
		}}
