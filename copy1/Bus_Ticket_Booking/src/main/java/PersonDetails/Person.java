package PersonDetails;

public class Person  {
       
	   private int User_Id;
       private String User_Name;
       private String password;
       private String Phone_number;
       private String Email_Id;
       private String Address;
       
       
	public Person(int user_Id,  String phone_number, String email_Id,String address, String user_Name, String password) {
		
		this.User_Id = user_Id;
		this.User_Name = user_Name;
		this.password = password;
		this.Phone_number = phone_number;
		this.Email_Id = email_Id;
		this.Address = address;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
       
  
	
       
}


