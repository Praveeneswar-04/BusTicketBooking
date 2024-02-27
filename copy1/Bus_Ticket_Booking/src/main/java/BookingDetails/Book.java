package BookingDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Connection.Connections;
import PaymentDetails.*;
public class Book {
	static Scanner sc = new Scanner(System.in);

	public static void bookTickect() {
		System.out.println("Please Select the Bus to Book ");

		System.out.println("Enter Bus ID ");
		int number = sc.nextInt();

		String query = "SELECT b.*, r.* FROM DATABASE.Bus_Details b JOIN DATABASE.Route_Details r ON b.route_Id = r.route_Id WHERE b.Bus_Id=? ";

		try {
			PreparedStatement preparedStatement = Connections.getCon().prepareStatement(query);
			preparedStatement.setInt(1, number);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				// Process the result set
//				displayBusAndRouteInfo(resultSet);
				if(number==resultSet.getInt("Bus_Id")) {
				int affectedRows = preparedStatement.getUpdateCount();
			    System.out.println("Number of affected rows: " + affectedRows);
				
				// Get bus number
				int busNumber = resultSet.getInt("bus_number");

				// Confirm booking
				System.out.println("Do you want to book this bus? (yes/no)");
				String confirmation = sc.next();
				if (confirmation.equalsIgnoreCase("yes")) {
					System.out.println("Enter Seats Required :");
					int seats=sc.nextInt();
					ConfirmBooking booking = new ConfirmBooking();
					int payment_id=Payment.paymentmethod();
					booking.makeBooking(resultSet, busNumber,payment_id,seats);
				} else {
					System.out.println("Booking canceled.");
				}
			} else {
				System.out.println("Sorry! Bus not found.");
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void displayBusAndRouteInfo(ResultSet resultSet) {

		try {
		int busId = resultSet.getInt("Bus_Id");
        int busNumber = resultSet.getInt("Bus_Number");
        String busName = resultSet.getString("Bus_Name");
        int seat = resultSet.getInt("Seat");
        double price = resultSet.getDouble("Price");
        int routeId = resultSet.getInt("Route_Id");
        String driverName = resultSet.getString("Driver_Name");
        String originCity = resultSet.getString("Origin_City");
        String destinationCity = resultSet.getString("Destination_City");
        displayBusDetails(busId, busNumber, busName, seat, price, routeId,  driverName, originCity, destinationCity);}
		 catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	 public static void displayBusDetails(int busId, int busNumber, String busName, int seat, double price, int routeId, String driverName, String originCity, String destinationCity) {
	        System.out.println("Bus ID: " + busId);
	        System.out.println("Bus Number: " + busNumber);
	        System.out.println("Bus Name: " + busName);
	        System.out.println("Seat: " + seat);
	        System.out.println("Price: " + price);
	        System.out.println("Route ID: " + routeId);
	        System.out.println("Driver Name: " + driverName);
	        System.out.println("Origin City: " + originCity);
	        System.out.println("Destination City: " + destinationCity);
	    }
		 public static void displayBookingDetails(int bookingId, int userId, int paymentId, String userName, int seatsReserved, String busNumber) {
		        System.out.println("Booking ID: " + bookingId);
		        System.out.println("User ID: " + userId);
		        System.out.println("Payment ID: " + paymentId);
		        System.out.println("User Name: " + userName);
		        System.out.println("Seats Reserved: " + seatsReserved);
		        System.out.println("Bus Number: " + busNumber);}
		    

		 public static void bookingHistory() {
			 String query="";
			try{	
			 PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
				ResultSet resultSet=pstmt.executeQuery();
		        
		            int bookingId = resultSet.getInt("Booking_Id");
		            int userId = resultSet.getInt("User_Id");
		            int paymentId = resultSet.getInt("Payment_Id");
		            String userName = resultSet.getString("User_Name");
		            int seatsReserved = resultSet.getInt("Seats_Reserved");
		            String busNumber = resultSet.getString("Bus_Number");

		            displayBookingDetails(bookingId, userId, paymentId, userName, seatsReserved, busNumber);
		        }
		        catch (SQLException e) {
		            e.printStackTrace();
		        }}}
		    
	

