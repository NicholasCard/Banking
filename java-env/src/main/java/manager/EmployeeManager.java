package manager;

import java.util.List;

import common.pojo.CustomerAccount;
import common.pojo.Transaction;
import dao.CustomerAccDao;
import dao.EmployeeDao;

public class EmployeeManager {

	private EmployeeDao employeeDao = new EmployeeDao();
	
	
	public List<Transaction> showTransactions() {
		//function that will return the users info when determined they are a customer
		
			return employeeDao.showTransactions();
		
	}
	
	public List<CustomerAccount> approveAccounts() {
		//function that will return the users info when determined they are a customer
		
			return employeeDao.approveAccounts();
		
	}
	
	public void approved(int id) {
		//function that will return the users info when determined they are a customer
		
			employeeDao.approved(id);
		
	}
}
