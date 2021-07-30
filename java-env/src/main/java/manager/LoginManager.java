package manager;

import java.util.List;



import common.pojo.User;
import dao.LoginDao;

public class LoginManager {

	
	
	//need to follow the bread crumbs for this code to replicate it 
	//i really didnt need the credentials pojo because its only used once and then should return the user
	//maybe change the userlist to a Usre
	
	private LoginDao loginDao = new LoginDao();
	

	public User checkCredentialsUser(String user_name, String password) {
		
		return loginDao.checkCredentialsUser(user_name, password);
	}
}
