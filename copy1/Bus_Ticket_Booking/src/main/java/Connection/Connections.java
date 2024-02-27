package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username="SYSTEM";
	private static final String password="Praveen";
	public  static Connection con;

	
public  static void invoke() {
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection(url, username, password);
	}
	catch(Exception e ) {
		e.printStackTrace();
	}
	}

public static Connection getCon() {
	return con;
}


public static void close_connection() {
	try {
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
