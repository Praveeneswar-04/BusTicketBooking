package BookingDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.Connections;

public class ConfirmBooking {

		public void makeBooking(ResultSet resultSet,int bookingId, int paymentId, int seatsReserved) {
		    try {
		        // Prepare the update query
		        String updateQuery = "UPDATE Booking SET User_Id = ?, Payment_Id = ?, User_Name = ?, Seats_Reserved = ? WHERE Booking_Id = ? AND Bus_Number = ?";
		        int userid=resultSet.getInt("User_Id");
		        String username=resultSet.getString("User_Name");
		        int busnumber=resultSet.getInt("Bus_Number");
		        // Get a connection to the database

		        // Create a PreparedStatement
		        PreparedStatement preparedStatement = Connections.getCon().prepareStatement(updateQuery);
		        
		        // Set parameters for the PreparedStatement
		        preparedStatement.setInt(1, userid);
		        preparedStatement.setInt(2, paymentId);
		        preparedStatement.setString(3, username);
		        preparedStatement.setInt(4, seatsReserved);
		        preparedStatement.setInt(5, bookingId);
		        preparedStatement.setInt(6, busnumber);

		        // Execute the update query
		        int rowsAffected = preparedStatement.executeUpdate();

		        // Check if the update was successful
		        if (rowsAffected > 0) {
		            System.out.println("Booking updated successfully.");
		        } else {
		            System.out.println("Booking update failed.");
		        }

		        // Close PreparedStatement and Connection
		        preparedStatement.close();
		       

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}}
	


