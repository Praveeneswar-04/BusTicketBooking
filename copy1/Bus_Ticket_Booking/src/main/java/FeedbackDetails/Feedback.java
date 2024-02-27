package FeedbackDetails;
import java.sql.PreparedStatement;
import java.util.*;

import Connection.Connections;
public class Feedback {
	static Scanner sc=new Scanner(System.in);
	 public static String getUserFeedback() {
	        System.out.println("Please provide your feedback:");
	        return sc.nextLine();
	    }

	    public static void updateFeedbackInDatabase(String userName, int userId, String feedback) {
	            String updateQuery = "INSERT INTO Feedback (user_id, user_name, feedback, feedback_date) VALUES (?, ?, ?, SYSDATE)";
	            try (PreparedStatement preparedStatement = Connections.getCon().prepareStatement(updateQuery)) {
	                preparedStatement.setInt(1, userId);
	                preparedStatement.setString(2, userName);
	                preparedStatement.setString(3, feedback);
	                int rowsAffected = preparedStatement.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("Feedback updated successfully.");
	                } else {
	                    System.out.println("Failed to update feedback.");
	                }
	            }
	         catch (Exception e) {
	            e.printStackTrace();
	         }}
	    }

