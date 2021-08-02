package manager;

import java.util.List;

import common.pojo.Transaction;
import dao.CustomerAccDao;
import dao.EmployeeDao;

public class EmployeeManager {

	private EmployeeDao employeeDao = new EmployeeDao();
	
	
	public List<Transaction> showTransactions() {
		//function that will return the users info when determined they are a customer
		
			return employeeDao.showTransactions();
		
	}
}
