package client;

import java.util.List;
import java.util.Scanner;


import common.pojo.User;

import manager.LoginManager;


public class ConsoleApp {

	//might be a way to combine these but for now just make a new manager
	
	private LoginManager loginManager = new LoginManager();
	
	User currentUser = new User();
	
	
	Scanner input = new Scanner(System.in);
	
	//attempting to make the user global but honestly making it global could be a security issue
	//User globalUser = new User();
	 
	
	public void start() {
		
		
		showLogin();
		System.out.println("Enter Action: ");
	
		currentUser = login();
		
		checkRole();
		
		/*
		if (checkRole().equals("customer")) {
			showCustomerAccount();
		} else if (checkRole().equals("employee")) {
			showEmployeeAccount();
		} else {
			System.out.println("something went wrong in the start logic");
		}
			
		*/
		
		input.close();
		
		
	}
	
		private void showLogin() {
		System.out.println("1. LogIn/Register");
		//have to ask for a register option but i want the user to be able to go through everything they need
		}
		
		
		
		private User login() {
			//User currentUser = new User();
			
			System.out.println("Enter your login information starting with username: ");
			String user_name = input.next();
			System.out.println("Next your password: ");
			String password = input.next();
			
			
			User currentUser = loginManager.checkCredentialsUser(user_name, password);
			
			
			
			return currentUser;
			
		}
		
		
		private void checkRole() {
			//String role = null;
			
			//System.out.println(currentUser.getRole());
			if ((currentUser != null) & (currentUser.getRole().equals("customer"))) {
				System.out.println("you are a customer welcome!");
				
				System.out.println("this is printing the currentUser within the login function: " + currentUser.getF_name());
				//role = "customer";
				showCustomerAccount();
				
				

				
				
			} else if ((currentUser != null) && (currentUser.getRole().equals("employee"))){
				System.out.println("You are an employee");
				
				//role = "employee";
				
			
		} else {
			System.out.println("you are neither of these and thats a problem");
		}
			//return role;
			
	}
	
	
	
		private void showCustomerAccount() {
			
			
			//needs to be a function in here that displays all the user accounts 
			
			System.out.println("Welcome! " + currentUser.getF_name());
			System.out.println("Please select an option");
			System.out.println("1. Select an Account");
			
			System.out.println("2. Log Out");
			
			String userInput = input.next();
			
			
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
			
			input.close();
		}

	private void customerMenu(User currentUser) {
	
		
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
			//showCustomerAccount(currentUser);
		default:
			break;
		}
		
	}
	
	private void showEmployeeAccount() {
		
		//needs to be changed to be employee specific but for now its fine
		System.out.println("Welcome to your account! " + currentUser.getF_name());
		System.out.println("Please select an option");
		System.out.println("1. Select an Account");
		
		System.out.println("2. Log Out");
		
		//Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		switch (userInput) {
		case "1":
			
			System.out.println("you are selecting an account");
			
			customerMenu(currentUser);
			
			break;
		case "2":
			
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
