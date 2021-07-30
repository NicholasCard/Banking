package manager;

import java.util.List;

import common.pojo.User;
import dao.UserDao;

public class UserManager {

private UserDao dao = new UserDao();
	
	
//simple find all users to test the database 

//need to separate the different functionalities of each part of the application

//1.login
//2. Customer menus
//3. account manager
//4. transaction manager
//5. employee manager
//basic ways to separate 




	public List<User> findAll(String f_name) {
		
		return null;
		//return dao.findAll(f_name);
		
	}
	
	public int save(User u) {
		return 0;
	}
	
	public void update(int id, String f_name) {
		
	}
	
	public void delete(int id) {
		
	}



	
	public List<User> findAll() {
	// TODO Auto-generated method stub
		return dao.findAll();
	}

}
