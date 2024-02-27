package BusDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connection.Connections;
import ExceptionHandling.Exceptions;
import PersonDetails.DatabaseConnection;
import SearchDetails.Bus;

public class BusOperations {
    static Scanner sc = new Scanner(System.in);
    static int found = 0;
    public static List<Bus> values = new ArrayList<>();

    public static void Add() {
    	DbtoList();
    	 try {
    	        // Gather input for the new bus
    	        System.out.println("Enter Bus Number:");
    	        int busNumber = sc.nextInt();
    	        sc.nextLine(); 
    	        System.out.println("Enter Bus Name:");
    	        String busName = sc.nextLine();
    	        System.out.println("Enter Seat Count:");
    	        int seatCount = sc.nextInt();
    	        System.out.println("Enter Price:");
    	        double price = sc.nextDouble();
    	        System.out.println("Enter Route ID:");
    	        int routeId = sc.nextInt();
    	        sc.nextLine(); 
    	        System.out.println("Enter Driver Name:");
    	        String driverName = sc.nextLine();

    	        // Insert new bus details into the database
    	        String query = "INSERT INTO DATABASE.Bus_Details (Bus_Number, Bus_Name, Seat, Price, Route_Id, Driver_Name) VALUES (?, ?, ?, ?, ?, ?)";
    	        PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
    	        pstmt.setInt(1, busNumber);
    	        pstmt.setString(2, busName);
    	        pstmt.setInt(3, seatCount);
    	        pstmt.setDouble(4, price);
    	        pstmt.setInt(5, routeId);
    	        pstmt.setString(6, driverName);
    	        int rowsInserted = pstmt.executeUpdate();
    	        if (rowsInserted > 0) {
    	            System.out.println("Bus details added successfully!");
    	        } else {
    	            System.out.println("Cannot add bus details. Please Verify Details");
    	        }
    	    } catch (Exception e) {
    	        Exceptions.handleException(e);
    	    }

    }

    
    
    
    public static void Update() {
    	DbtoList();

        System.out.println("Enter the Bus Id To update :");
        int id = sc.nextInt();
        try {
            // Gather updated input for the bus
        	System.out.println("Enter New Bus Id:");
            int busid = sc.nextInt();
            System.out.println("Enter New Bus Number:");
            int busNumber = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println("Enter New Bus Name:");
            String busName = sc.nextLine();
            System.out.println("Enter New Seat Count:");
            int seatCount = sc.nextInt();
            System.out.println("Enter New Price:");
            double price = sc.nextDouble();
            System.out.println("Enter New Route ID:");
            int routeId = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println("Enter New Driver Name:");
            String driverName = sc.nextLine();

            // Update the bus details in the database
            String query = "UPDATE DATABASE.Bus_Details SET Bus_Id=?,Bus_Number = ?, Bus_Name = ?, Seat = ?, Price = ?, Route_Id = ?, Driver_Name = ? WHERE Bus_Id = ?";
            PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
            pstmt.setInt(1, busid);

            pstmt.setInt(2, busNumber);
            pstmt.setString(3, busName);
            pstmt.setInt(4, seatCount);
            pstmt.setDouble(5, price);
            pstmt.setInt(6, routeId);
            pstmt.setString(7, driverName);
            pstmt.setInt(8, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Bus details updated successfully!");
            } else {
                System.out.println("Failed to update bus details.");
            }
        } catch (SQLException e) {
            Exceptions.handleException(e);
        }
        }
    

    public static void Delete() {
    	DbtoList();

        System.out.println("Enter the Bus Id to Remove :");
        int id = sc.nextInt();
        try {
            // Delete the bus details from the database
            String query = "DELETE FROM DATABASE.Bus_Details WHERE Bus_Id = ?";
            PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Bus details deleted successfully!");
            } else {
	            System.out.println("Cannot add bus details. Please Verify Details");
            }
        } catch (Exception e) {
            Exceptions.handleException(e);
        }
    }

    public static void View() {
    	DbtoList();
        String query = "SELECT * FROM DATABASE.Bus_Details";
        try {
            PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("Bus_Id") + " " + rs.getInt("Bus_Number") + " " + rs.getString("Bus_Name")
                        + " " + rs.getString("Seat") + " " + rs.getDouble("Price") + " " + rs.getInt("Route_Id") + " "
                        + rs.getString("Driver_Name"));
            }
            }
        
        catch (SQLException e) {
            Exceptions.handleException(e);
        }
    }

    
	public static List<Bus> DbtoList() {
        try {
            String query = "SELECT * FROM DATABASE.Bus_Details ";
            PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {	
                values.add(new Bus(rs.getInt("Bus_Id"), rs.getInt("Bus_Number"), rs.getString("Bus_Name"),
                        rs.getInt("Seat"), rs.getDouble("Price"), rs.getInt("Route_Id"), rs.getString("Driver_Name")));
            }
            
        } catch (Exception e) {
            Exceptions.handleException(e);
        }
        return values;
    }

    public static void ListtoDB() {
    	try {
            String query = "INSERT INTO DATABASE.Bus_Details (Bus_Id,Bus_Number, Bus_Name, Seat, Price, Route_Id, Driver_Name) VALUES (?,?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
            for (Bus bus : values) {
                pstmt.setInt(1, bus.getBus_Id());
                pstmt.setInt(2, bus.getBus_Number());
                pstmt.setString(3, bus.getBus_Name());
                pstmt.setInt(4, bus.getSeat());
                pstmt.setDouble(5, bus.getPrice());
                pstmt.setInt(6, bus.getRoute_id());
                pstmt.setString(7, bus.getDriver_Name());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("Data updated in the database successfully!");
        } catch (Exception e) {
            Exceptions.handleException(e);
        }
    }
}
