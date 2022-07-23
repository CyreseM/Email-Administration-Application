 package emailapp;

import java.util.Scanner;

public class Email {
	 private String firstName;
	 private String lastName;
	 private String passWord;
	 private String email;
	 private String department;
	 private int  mailBoxCapacity = 500;
	 private String alternateEmail;
	 private int defaultPasswordLength = 10 ;
	 private String companySuffix = "mycompany.com";
	 //constructor to receive first name and last name
	 public Email(String firstName, String lastName) {
		 this.firstName = firstName;
		 this.lastName = lastName;
		 System.out.println("EMAIL CREATED: "+  this.firstName +" "+ this.lastName);
		 
		 
		 this.department = setDepartment();
		 System.out.println("Department "+ this.department);
		 //Call a method that returns a random password
		 this.passWord = randomPassword(defaultPasswordLength);
		 System.out.println("Your password is: "+ this.passWord);
		 
		 // Combine elements to generate email
		 email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "."+companySuffix;
		 System.out.println("Your email is: "+ email);
	 }
	 
	 
	 private String setDepartment() {
		 System.out.print("Department codes \n1 for Sales \n2 for development \n3 for Accounting \n0 for none \n Enter the department code");
		 Scanner in = new Scanner(System.in);
		 int depChoice = in.nextInt();
		 if(depChoice == 1 ) {
			 return  "sales";
		 }else if(depChoice == 2) {return "dev";}
		 else if(depChoice == 3) {return "acct";}
		 else {return "";}
	 }
	  
	 //Generate a random password
	 private String randomPassword(int length) {
		 String passWordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789%&@";
		 char[] password = new char[length];
		 for(int i=0; i < length; i++) {
			 int rand = (int) (Math.random() * passWordSet.length());
			 password[i] = passWordSet.charAt(rand);
		 }
		 return new String(password);
	 }
	 
	 //Set the mailbox capacity
	 public void setMailCapacity(int capacity) {
		 this.mailBoxCapacity = capacity;
	 }
	 
	 public void setAlternateEmail(String altEmail) {
		 this.alternateEmail = altEmail;
	 }
	 
	 
	 public void changePassword(String password) {
		 this.passWord =  password;
		 
	 }
	 
	 public int getMailCapacity(){return mailBoxCapacity;}
	 public String getAlternateEmail(){return alternateEmail;}
	 public String getPassword() {return passWord;}
	 
	 public String showInfo() {
		 return "DISPLAY NAME: " + firstName + " "+ lastName + 
				"COMPANY EMAIL: "+ email +  
		 		"MAILBOX CAPACITY: "+ mailBoxCapacity + "mb";
	 }
}
 