package PaymentDetails;

import java.util.*;

	public class Card extends Payment 
	{
	   static Scanner scanner = new Scanner(System.in);

	    public Card()
	    {
	        System.out.println("Card payment selected.");

	        System.out.print("Enter card number: ");
	        String cardNumber = scanner.next();

	        processCardPayment(cardNumber);
	    }

	    private void processCardPayment(String cardNumber)
	    {
	        System.out.println("Card payment processed successfully.");
	        System.out.println("Card Number: " + cardNumber);
	        System.out.println("Booking Successful!");
	    }
	}

