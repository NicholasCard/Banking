package client;

import java.util.List;
import java.util.Scanner;


import common.pojo.User;

import manager.LoginManager;
import manager.UserManager;

public class ConsoleApp {

	//might be a way to combine these but for now just make a new manager
	private UserManager manager = new UserManager();
	
	private LoginManager loginManager = new LoginManager();
	
	 
	public void start() {
		
		showLogin();
		System.out.println("Enter Action: ");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		switch (userInput) {
		case "1":
			//listView();
			login();
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
	
	private void showUserAccount() {
		
		//should honestly just ask for the credentials right away
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		System.out.println("Welcome to your account! ");
		System.out.println("Please select an option");
		System.out.println("1. Select an Account");
		System.out.println("2. Log Out");
		
		
		//also needs a back button but I do need to make the scanner a bit easier to use and read instead of making a new
		//one every time
		//research making the loops 
		
		//also need a function that creates the user info that is logged in
		
		switch (userInput) {
		case "1":
			//selectAccount() function i have to make
			System.out.println("you are selecting an account");
			break;
		case "2":
			//make a logout function thats made anytime someone selects log out.
			System.out.println("you have selected log out");
		default:
			break;
		}
		
	}
	
	private void login() {
		
		System.out.println("Enter your login information starting with username: ");
		Scanner input = new Scanner(System.in);
		String user_name = input.next();
		System.out.println("Next your password: ");
		String password = input.next();
		
		User currentUser = loginManager.checkCredentialsUser(user_name, password);
		
		if (currentUser != null) {
			System.out.println();
			System.out.println(currentUser.getF_name());
			showUserAccount();
		} else {
		System.out.println("you need to try again");
		//need to make this break with the scanner to go to a retry or an exit menu
	}
		
	

		input.close();
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
