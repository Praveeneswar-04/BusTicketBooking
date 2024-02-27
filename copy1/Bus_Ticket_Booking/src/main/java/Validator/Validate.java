package Validator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ExceptionHandling.Exceptions;

public class Validate {
		static Scanner sc=new Scanner(System.in);
	    private static final String Mobile_Pattern ="^[0-9]{10}$";
	    private static final String EMAIL_Pattern= "[a-zA-Z0-9_-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";
	    private static final String PASSWORD_Pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	    private static final String USERNAME_Pattern = "^[a-zA-Z0-9_]{3,15}$";
        
	    public static String validateMobileNumber() {
	    	
	    	String phno=sc.next();
	        if (phno == null) {
            System.out.println("Mobile Number Cannot be  Empty");	        }

	        Pattern pattern = Pattern.compile(Mobile_Pattern);
	        Matcher matcher = pattern.matcher(phno);

	        if (!(matcher.matches())) {
        		Exceptions.handleException(new Exception("Inavlid Mobile Number"));
	        } 
			return phno;
	    }

	    public static String validateEmail() {
	    	String email=sc.next();
	        if (email == null) {
        		Exceptions.handleException(new Exception("Email Cannot be Empty"));}

	        Pattern pattern = Pattern.compile(EMAIL_Pattern);
	        Matcher matcher = pattern.matcher(email);

	        if (!(matcher.matches())) {
	        		Exceptions.handleException(new Exception("Inavlid Email"));
	        } 
	        
			return email;
	    }

	    public static String validatePassword() {
	    	String password=sc.next();
	        if (password == null||password.isEmpty()) {
        		Exceptions.handleException(new Exception("Password Cannot Be Empty"));
	        }

	        Pattern pattern = Pattern.compile(PASSWORD_Pattern);
	        Matcher matcher = pattern.matcher(password);

	        if (!(matcher.matches())){
        		Exceptions.handleException(new Exception("Inavlid Password"));
	        } 
	        return password;
	    }

	    public static String validateUsername() {
	    	String username=sc.next();
	        if (username == null||username.isEmpty()) {
        		Exceptions.handleException(new Exception("User Name Cannot be Empty"));
	        }

	        Pattern pattern = Pattern.compile(USERNAME_Pattern);
	        Matcher matcher = pattern.matcher(username);

	        if (!(matcher.matches())){
        		Exceptions.handleException(new Exception("Inavlid User Name"));
	        } 
	        return username;
	    }
        
	   
	}


