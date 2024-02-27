package PersonDetails;

import java.util.Scanner;

import ExceptionHandling.Exceptions;

public class Account {
    private String User_name;
    private String password;
    private String person;
    static Scanner sc=new Scanner(System.in);
    

	public Account(String user_name, String password) {

		this.User_name = user_name;
		this.password = password;
	}
	public Account(String name) {
		this.person=name;
	}
	public  void login () {
		try {
		System.out.println("Enter the User Name:");
		String u_name = sc.next();
		System.out.println("Enter the Password:");
		String pwd = sc.next();
		Account acc=new Account(u_name,pwd);
		DatabaseConnection.Validatelogin(acc.User_name, acc.password, person);

		}
	
	    catch(Exception e) {
		Exceptions.handleException(e);
	}
		}
	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
