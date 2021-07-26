package client;

import java.util.List;
import java.util.Scanner;

import common.pojo.User;
import manager.UserManager;

public class ConsoleApp {

	private UserManager manager = new UserManager();
	
	 
	public void start() {
		
		showLogin();
		System.out.println("Enter Action: ");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		
		switch (choice) {
		case "1":
			listView();
			break;
		default:
			break;
		}
		
		//these will be the methods to show the prompt and the scanner and what not 
		
		
		//could do this with try with resources
		//further research
		input.close();
		//searchView();
		//addView();
		//updateView();
		//deleteView();
		
	}
	
	public void searchView() {
		// TODO Auto-generated method stub
		
		
	}
	
	private void customerMenu() {
		
		//need to separate these but Ill hold them here for this menu
		System.out.println("1. Select an Account");
		
		
		//these all need to be their separate functions which I need to add to the AccountService
		//and the AccountDao*
		
		//*might need to rename that 
		
	
		System.out.println("1. View Balance");
		System.out.println("2. Make a Deposit");
		System.out.println("3. Make a Withdrawl");
		System.out.println("4. Add an Account");
		System.out.println("5. Delete an Account");
		System.out.println("6. Go Back");
		
	}
	
	
	
	private void showLogin() {
	
		//should honestly just ask for the credentials right away
		System.out.println("1. LogIn/Register");
		
	}
	
	private void Login() {
		
		//this needs to relate to the loginCheck with the UserManager 
		//User needs to be able to input a username and password 
		//A Credentials object needs to be made with the username and password and that 
		//will be used to check the database if that user and password exist
		
		
	}
	
	private void listView() {
		
		//this function is throwing a null pointer exception need to figure out why
		
		
		List<User> users = manager.findAll();
		
		//header
		System.out.println("|  ID  |  First Name  |  Last Name  |  Role  |");
		
		//data
		
		for (User u : users) {
			System.out.println(u.getId() + " | " + u.getF_name() + " | " + u.getL_name() + " | " + u.getRole());
		}
		
	}
}
