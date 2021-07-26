package manager;

import java.util.List;

import common.pojo.User;
import dao.UserDao;

public class UserManager {

private UserDao dao = new UserDao();
	
	
	public List<User> findAll(String f_name) {
		
		return dao.findAll(f_name);
		
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
