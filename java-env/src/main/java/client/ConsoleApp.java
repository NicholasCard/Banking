package client;

import java.util.List;
import java.util.Scanner;


import common.pojo.User;

import manager.LoginManager;


public class ConsoleApp {

	//might be a way to combine these but for now just make a new manager
	
	private LoginManager loginManager = new LoginManager();
	
	
	//attempting to make the user global but hoenslty making it global could be a secruity issue
	//User globalUser = new User();
	 
	public void start() {
		
		showLogin();
		System.out.println("Enter Action: ");
		
		login();
		
	}
	
		private void showLogin() {
	
		
		System.out.println("1. LogIn/Register");
		//have to ask for a register option but i want the user to be able to go through everything they need
		}
		
		
		private void login() {
			
			System.out.println("Enter your login information starting with username: ");
			Scanner input = new Scanner(System.in);
			String user_name = input.next();
			System.out.println("Next your password: ");
			String password = input.next();
			
			User currentUser = loginManager.checkCredentialsUser(user_name, password);
			
			if ((currentUser != null) & (currentUser.getRole().equals("customer"))) {
				System.out.println("you are a customer welcome!");
				
				
				//this if statement is not then running showCustomerAcc for some reason
				
				System.out.println("this is printing the currentUser within the login function: " + currentUser.getF_name());
				
				
				//why is it just stopping here
				
				showCustomerAccount(currentUser);
				
				//need to figure out how to pass around the current user 
				//i might just have to do it like this or instantiate it in the main method instead of here but 
				//not sure yet
				
				
				
			} else if ((currentUser != null) && (currentUser.getRole().equals("employee"))){
				System.out.println("You are an employee");
				showEmployeeAccount(currentUser);
			
			//need to make this break with the scanner to go to a retry or an exit menu
		} else {
			System.out.println("you are neither of these and thats a problem");
		}
			
			input.close();
			
		}
	
	
	
		private void showCustomerAccount(User currentUser) {
			
			
			
			
			System.out.println("Welcome to your account! " + currentUser.getF_name());
			System.out.println("Please select an option");
			System.out.println("1. Select an Account");
			
			System.out.println("2. Log Out");
			
			Scanner input = new Scanner(System.in);
			String userInput = input.next();
			
			//also needs a back button but I do need to make the scanner a bit easier to use and read instead of making a new
			//one every time
			//research making the loops 
			
			
			switch (userInput) {
			case "1":
				
				System.out.println("you are selecting an account");
				//selectAccount() function i have to make
				//then once an account is made thats when the customer menu pops up 
				customerMenu(currentUser);
				
				break;
			case "2":
				//make a logout function thats made anytime someone selects log out.
				System.out.println("you have selected log out");
				
			default:
				break;
			}
			
		}

	private void customerMenu(User currentUser) {
		
		//this has to go somewhere and i might make another class just for all of these functions
		//because this is getting sort of ridiculous
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		System.out.println("1. View Balance");
		System.out.println("2. Make a Deposit");
		System.out.println("3. Make a Withdrawal");
		System.out.println("4. Add an Account");
		System.out.println("5. Delete an Account");
		System.out.println("6. Go Back");
		
		switch (userInput) {
		case "1":
			
			System.out.println("You are viewing your balance on this account");
			//function that just shows the balance of the selected account 
			//need some way to store the account ID that is currently being viewed
			break;
		case "2":
			System.out.println("You are making a deposit");
			//function that asks for an amount and then adds that amount to the account total
			
		case "3":
			System.out.println("You are making a withdraw");
			//function that takes a user inputed amount and checks to see if its more than the current account total
		
		
		case "4":
			System.out.println("You went back to the previous menu ");
			showCustomerAccount(currentUser);
		default:
			break;
		}
		
	}
	
	private void showEmployeeAccount(User currentUser) {
		System.out.println("Welcome to your account! " + currentUser.getF_name());
		System.out.println("Please select an option");
		System.out.println("1. Select an Account");
		
		System.out.println("2. Log Out");
		
		
		
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		
		
		
		//also needs a back button but I do need to make the scanner a bit easier to use and read instead of making a new
		//one every time
		//research making the loops 
		
		
		switch (userInput) {
		case "1":
			
			System.out.println("you are selecting an account");
			//selectAccount() function i have to make
			//then once an account is made thats when the customer menu pops up 
			customerMenu(currentUser);
			
			break;
		case "2":
			//make a logout function thats made anytime someone selects log out.
			System.out.println("you have selected log out");
			
		default:
			break;
		}
		
		
	}
	
	
	
	
	
	
	
	/*
	
	private void listView() {
		
		//this function is throwing a null pointer exception need to figure out why
		
		
		List<User> users = manager.findAll();
		
		//header
		System.out.println("|  ID  |  First Name  |  Last Name  |  Role  |");
		
		//data
		
		for (User u : users) {
			System.out.println(u.getId() + " | " + u.getF_name() + " | " + u.getL_name() + " | " + u.getRole());
		}
		
	}*/
}
