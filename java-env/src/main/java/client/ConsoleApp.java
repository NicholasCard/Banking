package client;

import java.util.List;
import java.util.Scanner;

import common.pojo.CustomerAccount;
import common.pojo.Transaction;
import common.pojo.User;
import manager.CustomerAccManager;
import manager.EmployeeManager;
import manager.LoginManager;


public class ConsoleApp {

	//might be a way to combine these but for now just make a new manager
	
	private LoginManager loginManager = new LoginManager();
	private CustomerAccManager cam = new CustomerAccManager();
	private EmployeeManager em = new EmployeeManager();
	
	
	User currentUser = new User();
	
	
	Scanner input = new Scanner(System.in);
	
	public void start() {
		
		
		System.out.println("1. LogIn");
		System.out.println("2. Register");

		String userInput = input.next();
		
		switch(userInput) {
		case "1":
			currentUser = login();
			break;
		case "2":
			currentUser = register();
			
			break;
		default:
			break;
		}
		
		System.out.println("Enter Action: ");
	
		
		if (currentUser == null) {
			System.out.println("your credentials are incorrect please try again");
			start();
		}  else {
		
		String role = checkRole();
	
		
		if (role.equals("customer")) {
			showCustomerAccounts();
		} else if (role.equals("employee")) {
			showEmployeeAccount();
		} else {
			System.out.println("something went wrong in the start logic");
		}
		
		input.close();
		
		}
	}
	
	
	private User register() {
		System.out.println("Thank you for registering with us!");
		System.out.println("Please Fill out all Information needed to make an account");
		System.out.println("First input your First name: ");
		String firstName = input.next();
		System.out.println("Next input your Last name: ");
		String lastName = input.next();
		System.out.println("Please type in your email address (this will be your username): ");
		String userName = input.next();
		System.out.println("Now please set your password: ");
		String password = input.next();
		
		loginManager.registerUser(firstName, lastName, userName, password);
		
		System.out.println("Amazing! You have been registered!");
		System.out.println("Just use your username and password you used in the form to log in!");
		
		currentUser = login();
		
		return currentUser;
		
	}


		
		
		private User login() {
			
			System.out.println("Enter your login information starting with username: ");
			String user_name = input.next();
			System.out.println("Next your password: ");
			String password = input.next();
			
			User currentUser = loginManager.checkCredentialsUser(user_name, password);
			
			return currentUser;
			
		}
		
		
		private String checkRole() {
			String role = null;
			if ((currentUser != null) & (currentUser.getRole().equals("customer"))) {
				System.out.println("Welcome " + currentUser.getF_name() + " " + currentUser.getL_name());
				
				role = "customer";
				
				
			} else if ((currentUser != null) && (currentUser.getRole().equals("employee"))){
				System.out.println("Ready to start a days work I see " + currentUser.getF_name() + " " + currentUser.getL_name());
			
				role = "employee";
		} else {
			System.out.println("you are neither of these and thats a problem");
		}
			return role;
	}
	
	
	
		private void showCustomerAccounts() {
			
			
			//needs to be a function in here that displays all the user accounts 
			//needs to be a separate function
			System.out.println("Welcome! " + currentUser.getF_name());
			
			while(true) {
			
			System.out.println("Please select an option");
			System.out.println("1. Select an Account");
			System.out.println("2. See All your Transactions");
			System.out.println("3. Create a new Account");
			System.out.println("4. Delete an account");
			System.out.println("5. Log Out");
		
			
			String userInput = input.next();
			
		
			switch (userInput) {
			case "1":
				
				System.out.println("you are selecting an account");
				//selectAccount() function i have to make
				//then once an account is made thats when the customer menu pops up 
				showAccounts();
				
				break;
			case "2":
				//make a logout function thats made anytime someone selects log out.
				System.out.println("you have selected view all transactions");
				
				viewTransactions();
				break;
				
			case "3":
				System.out.println("You have selected to create a new Account");
				createAccount();
				break;
			case "4":
				System.out.println("you have selected to delete an account");
				deleteAccount();
				break;
			case "5":
				System.out.println("you have selected log out");
				break;
			default:
				break;
			}
			
		}
			
			
		}
		
		
		private void deleteAccount() {
			
CustomerAccount customerAcc = new CustomerAccount();
			
			
			List<CustomerAccount> ca = cam.showAccounts(currentUser);
			
			
			System.out.println("please select an account to delete by routing number");
			
			
			//need to fix this because i want it to stay in transactions but thats tricky because of the foreign key constraint
			System.out.println("BE WARNED THIS WILL DELETE ANY OTHER TRANSACTIONS INVOLVONG THIS ACCOUNT");
			System.out.println("|  Routing Number  |  Account Name  |  Balance  |");
			
			//data
			
			for (CustomerAccount a : ca) {
				System.out.println(a.getId() + " | " + a.getAcc_name() + " | " + a.getTotal() + " | ");
			}
			int userInput = input.nextInt();
			
			int accountId = userInput;
			
			for (CustomerAccount c : ca) {
			    if (c.getId() == (accountId)) {
			        customerAcc = c;
			        System.out.println(customerAcc.getAcc_name());
			        
			        cam.deleteAccount(c.getId(), currentUser.getId());
			        break;
			    } else {
			    	System.out.println("hey this didnt work ");
			    }
			}
			
			
			
		}


		private void createAccount() {
			System.out.println("Please create a name for your account");
			String acc_name = input.next();
			
			System.out.println("Please Select an initial value to put into that account");
			
			int initial_amount = input.nextInt();
			
			
			cam.createAccount(acc_name, initial_amount);
			
			System.out.println("You successfully made an account!");
		}


		private void viewTransactions() {
			
			List<Transaction> t = cam.transactions(currentUser.getId());
			System.out.println("|  AccountNumber  |  Account Name  |  Amount  |  Transaction Type  |");
			
			
			for (Transaction tr : t) {
				System.out.println(tr.getId() + " | " + tr.getAcc_name() + " | " + tr.getTransaction_amount() /*+ " | " + tr.getTransaction_date()*/ +" | " + tr.getTransaction_type());
			}
			
		}


		private void showAccounts() {
			
			CustomerAccount customerAcc = new CustomerAccount();
			
			
			List<CustomerAccount> ca = cam.showAccounts(currentUser);
			
			
			System.out.println("please select an account by routing number");
			System.out.println("|  Routing Number  |  Account Name  |  Balance  |");
			
			//data
			
			for (CustomerAccount a : ca) {
				System.out.println(a.getId() + " | " + a.getAcc_name() + " | " + a.getTotal() + " | ");
			}
			int userInput = input.nextInt();
			
			//could make it so i just have to instantiate that account object and then once its not selected anymore it 
			//deletes or overrides the other account object
			int accountId = userInput;
			
			for (CustomerAccount c : ca) {
			    if (c.getId() == (accountId)) {
			        customerAcc = c;
			        System.out.println(customerAcc.getAcc_name());
			        
			        customerMenu(customerAcc);
			        break;
			    } else {
			    	System.out.println("hey this didnt work ");
			    }
			}
		}

	private void customerMenu(CustomerAccount customerAcc) {
	
		//new flow starts here to make sure the account selected is the one shown 
		
		while(true) {
		
		System.out.println("1. View Balance");
		System.out.println("2. Make a Deposit");
		System.out.println("3. Make a Withdrawal");
		System.out.println("4. View Transactions for this account");
		//make a go back menu item
		System.out.println("5. Go Back");
		
		
		String userInput = input.next();
		
		switch (userInput) {
		case "1":
			
			System.out.println("You are viewing your balance on this account");
			System.out.println("Here is your current Balance: " + showBalance(customerAcc.getId()));
			
			break;
		case "2":
			System.out.println("You are making a deposit");
			//function that asks for an amount and then adds that amount to the account total
			deposit(customerAcc.getId());
			
			
			showBalance(customerAcc.getId());
			break;
			
		case "3":
			System.out.println("You are making a withdraw");
			//function that takes a user inputed amount and checks to see if its more than the current account total
			withdrawal(customerAcc.getId());
			
			
			System.out.println("Here is your current Balance: " + showBalance(customerAcc.getId()));
		break;
		
		case "4":
			System.out.println("Transactions for this specific account ");
			accTransactions(currentUser.getId(), customerAcc.getId());	
			break;
		case "5":
			System.out.println("Exit out!");
		default:
			showCustomerAccounts();
			break;
		}
	}
		
	}
	
	private void accTransactions(int user_id, int acc_id) {
		List<Transaction> at = cam.transactions(currentUser.getId());
		
		//add the date here later
		System.out.println("|  AccountNumber  |  Account Name  |  Amount  |  Transaction Type  |");
		
		//data
		
		for (Transaction t : at) {
			System.out.println(t.getId() + " | " + t.getAcc_name() + " | " + t.getTransaction_amount() /*+ " | " + tr.getTransaction_date()*/ +" | " + t.getTransaction_type());
		}
		
	}


	private int showBalance(int id) {
		int balance = cam.viewBalance(currentUser.getId(), id);
		
		return balance;
		
	}
	
	private void deposit(int id) {
		
		System.out.println("Please input the amount you want to deposit");
		int userInput = input.nextInt();
		
		int deposit = userInput;
		
		if (deposit <= 0) {
			System.out.println("You need to input an amount higher than 0");
		} else {
		
		cam.deposit(id, deposit, currentUser.getId());
		cam.transactionUpdate(id, currentUser.getId(), "deposit", deposit);
		System.out.println("You have successfully deposited: " + deposit + " dollars");
		}
	}
	
	private void withdrawal(int id) {
		System.out.println("Please input the amount you want to deposit");
		int userInput = input.nextInt();
		
		int withdrawal = -userInput;
		
		
		if ((showBalance(id) < withdrawal) && (withdrawal > 0)){
			System.out.println("you need to select an amount thats above your current balance");
			withdrawal(id);
			
		
		} else {
			cam.accWithdrawal(id, withdrawal, currentUser.getId());
			cam.transactionUpdate(id, currentUser.getId(), "withdrawal", withdrawal);
			
			System.out.println("You have successfully withdrawaled: " + withdrawal + " dollars");
		}
	}
	
	
	
	
	private void showEmployeeAccount() {
		
		//needs to be changed to be employee specific but for now its fine
		System.out.println("Welcome to your account! " + currentUser.getF_name());
		System.out.println("Please select an option");
		System.out.println("1. See all Transactions");
		System.out.println("2. Approve Accounts");
		System.out.println("3. Log Out");
		
		//Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		switch (userInput) {
		case "1":
			System.out.println("You have selected see all transactions");
			viewAllTransactions();
			break;
			
		case "2":
			System.out.println("Approve accounts");
			approveAccounts();
			break;
			
		case "3":
			System.out.println("you have selected log out");
			
		default:
			break;
		}
	}
	
	
	private void viewAllTransactions() {
		
		List<Transaction> at = em.showTransactions();
		
		//could add more filter options for the employee side but this is all the user side I need
		System.out.println("Here are all of the transactions");
		System.out.println("|  AccountNumber  |  Account Name  |  Amount  |  Transaction Type  |");
		
		//data
		
		for (Transaction t : at) {
			System.out.println(t.getId() + " | " + t.getAcc_name() + " | " + t.getTransaction_amount() /*+ " | " + tr.getTransaction_date()*/ +" | " + t.getTransaction_type());
		}
		
	}
	
private void approveAccounts() {
		
		List<CustomerAccount> aa = em.approveAccounts();
		
		//could add more filter options for the employee side but this is all the user side I need
		System.out.println("Here are all of the transactions");
		System.out.println("|  AccountNumber  |  Account Name  |  Amount  |  Transaction Type  |");
		
		//data
		
		for (CustomerAccount a : aa) {
			System.out.println(a.getId() + " | " + a.getAcc_name() + " | " + a.getTotal() +" | " + a.getF_name() + " " +  a.getL_name());
		}
		
		int userInput = input.nextInt();
		
		//could make it so i just have to instantiate that account object and then once its not selected anymore it 
		//deletes or overrides the other account object
		int accountId = userInput;
		
		for (CustomerAccount a : aa) {
		    if (a.getId() == (accountId)) {
		        
		        System.out.println("You have selected " + a.getAcc_name() + " to be approved");
		        em.approved(accountId);
		        
		        break;
		    } else {
		    	System.out.println("You selected an account that doesnt exist");
		    	approveAccounts();
		    }
		}
	}

	

}
