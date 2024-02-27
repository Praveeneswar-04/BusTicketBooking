package PersonDetails;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.Connections;
import ExceptionHandling.Exceptions;
import SearchDetails.Bus;

public class DatabaseConnection {
	
	static ArrayList<User> values = new ArrayList<>();

	public static void Validatelogin(String User_Name, String User_Password, String name) {
		String Name = name;
		String User_name = User_Name;
		String User_password = User_Password;

		Connections.invoke();
		try {
			Statement stmt = Connections.getCon().createStatement();
			int count = -1;

			if (Name.equals("Admin")) {
				String validate_Admin = "SELECT Admin_User_Name ,Password from DATABASE.Admin_Details ";
				ResultSet values = stmt.executeQuery(validate_Admin);
				while (values.next()) {
					String db_name = values.getString("Admin_User_Name");
					String db_pwd = values.getString("Password");
					if (User_name.equals(db_name) && User_password.equals(db_pwd)) {
						System.out.println("Login Succesfull!");
						Administrator.Menu();
						count++;
					}

				}
				if (count <0) {
					System.out.println("Invalid Credentials.");
				}
			}
			if (Name.equals("User")) {
				String validate_User = "SELECT USER_NAME ,Password from DATABASE.User_Details ";
				ResultSet values = stmt.executeQuery(validate_User);
				while (values.next()) {
					String db_name = values.getString("User_Name");
					String db_pwd = values.getString("Password");
					if (User_name.equals(db_name) && User_password.equals(db_pwd)) {
						System.out.println("Login Succesfull!");
						count++;
						User.menu();
					}
				}
				if (count <0) {
					System.out.println("Invalid Credentials.");
				}

			}

			if (Name.equals("BusOperator")) {
				String validate_BusOperator = "SELECT Operator_Name ,Password from DATABASE.Bus_Operator_Details ";
				ResultSet values = stmt.executeQuery(validate_BusOperator);
				while (values.next()) {
					String db_name = values.getString("Operator_Name");
					String db_pwd = values.getString("Password");
					if (User_name.equals(db_name) && User_password.equals(db_pwd)) {
						System.out.println("Login Succesfull!");
						count++;
						BusOperator.Menu();

					}

				}
				if (count <0) {
					System.out.println("Invalid Credentials.");
				}

			}
		} catch (Exception e) {
			Exceptions.handleException(e);
		}
	}

	public static void AddUser(User user) {
		Connections.invoke();

		String query = "INSERT INTO DATABASE.User_Details  VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = Connections.getCon().prepareStatement(query);
			pstmt.setInt(1, user.getUser_Id());
			pstmt.setString(2, user.getUser_Name());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhone_number());
			pstmt.setString(5, user.getEmail_Id());
			pstmt.setString(6, user.getAddress());

			pstmt.executeUpdate();
			System.out.println("User registered successfully!");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public List<Bus> getAllBus() {
		List<Bus> buses = new ArrayList<>();
		try {
			String query = "SELECT * FROM DATABASE.Bus_Details";
			Statement s = Connections.getCon().createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				Bus bus = new Bus(rs.getInt("Bus_Id"), rs.getInt("Bus_Number"), rs.getString("Bus_Name"),
						rs.getInt("Seat"), rs.getDouble("Price"), rs.getInt("Route_Id"), rs.getString("Driver_Name"));
				buses.add(bus);
			}
		} catch (Exception e) {
			System.out.println();
		}
		return buses;
	}

}
