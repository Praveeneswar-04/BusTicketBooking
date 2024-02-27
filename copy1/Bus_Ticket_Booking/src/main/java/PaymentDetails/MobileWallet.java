package PaymentDetails;

import java.util.Scanner;

public class MobileWallet extends Payment 
{
   static Scanner scanner = new Scanner(System.in);

    public MobileWallet()
    {
        System.out.println("Card payment selected.");

        System.out.print("Enter Wallet number: ");
        String Wallet = scanner.next();

        processCardPayment(Wallet);
    }

    private void processCardPayment(String Wallet)
    {
        System.out.println("Card payment processed successfully.");
        System.out.println("Card Number: " + Wallet);
        System.out.println("Booking Successful!");
    }
}
