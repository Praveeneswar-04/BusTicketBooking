package PaymentDetails;

import java.util.Scanner;

public class Cash extends Payment 
{
    Scanner scanner = new Scanner(System.in);

    public Cash() 
    {
        System.out.println("Cash payment selected.");

        System.out.println("Enter cash amount: ");
        double amount = scanner.nextDouble();

        processCashPayment(amount);
    }

    private void processCashPayment(double amount) 
    {
        System.out.println("Cash payment processed successfully.");
        System.out.println("Amount Paid: $" + amount);
        System.out.println("Booking Successful!");
    }
}
