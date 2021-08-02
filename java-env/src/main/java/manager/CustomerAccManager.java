package manager;

import java.util.List;

import common.pojo.CustomerAccount;
import common.pojo.Transaction;
import common.pojo.User;
import dao.CustomerAccDao;


public class CustomerAccManager {

	private CustomerAccDao customerAccDao = new CustomerAccDao();
	
	public List<CustomerAccount> showAccounts(User currentUser) {
		//function that will return the users info when determined they are a customer
		
			return customerAccDao.showAccounts(currentUser);
		
	}
	
	//fix the return type here
	public void deposit(int id, int deposit, int user_id) {
		customerAccDao.deposit(id, deposit, user_id);
	}
	
	public int viewBalance(int user_id, int id) {
		return customerAccDao.viewBalance(user_id, id);
	}
	
	public void accWithdrawal(int id, int withdrawal, int user_id) {
		customerAccDao.accWithdrawal(id, withdrawal, user_id);
	}
	
	public void transactionUpdate(int id, int user_id, String type, int amount) {
		customerAccDao.transactionUpdate(id, user_id, type, amount);
	}
	
	public List<Transaction> transactions(int id) {
		//function that will return the users info when determined they are a customer
		
			return customerAccDao.transactions(id);
		
	}
	
	public List<Transaction> accTransactions(int id, int acc_id) {
		//function that will return the users info when determined they are a customer
		
			return customerAccDao.accTransactions(id, acc_id);
		
	}
	
	public void createAccount(String acc_name, int intial_value) {
		//function that will return the users info when determined they are a customer
		
			 customerAccDao.createAccount(acc_name, intial_value);
		
	}
	
	public void deleteAccount(int acc_id, int user_id) {
		//function that will return the users info when determined they are a customer
		
			 customerAccDao.deleteAccount(acc_id, user_id);
		
	}
}
