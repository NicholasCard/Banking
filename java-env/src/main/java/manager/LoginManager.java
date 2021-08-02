package manager;

import java.util.List;



import common.pojo.User;
import dao.LoginDao;
import dao.RegisterDao;

public class LoginManager {

	
	
	//need to follow the bread crumbs for this code to replicate it 
	//i really didnt need the credentials pojo because its only used once and then should return the user
	//maybe change the userlist to a Usre
	
	private LoginDao loginDao = new LoginDao();
	private RegisterDao registerDao = new RegisterDao();

	public User checkCredentialsUser(String user_name, String password) {
		
		return loginDao.checkCredentialsUser(user_name, password);
	}
	
	public void registerUser(String f_name, String l_name, String user_name, String password) {
		registerDao.registerUser(f_name, l_name, user_name, password);
	}
}
