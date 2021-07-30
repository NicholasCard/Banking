package manager;

import common.pojo.CustomerAccount;
import common.pojo.User;
import dao.CustomerAccDao;


public class CustomerAccManager {

	private CustomerAccDao customerAccDao = new CustomerAccDao();
	
	public CustomerAccount customerAcc(User currentUser) {
		//function that will return the users info when determined they are a customer
		
			return customerAccDao.showAccounts(currentUser);
		
	}
}
