package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.pojo.User;
import common.util.DatabaseUtil;

public class UserDao {

	// this function will eventually call the SQL statement that just selects all of the 
		//Users from the database
		public List<User> findAll() {
			List<User> users = new ArrayList<User>();
			
			try {
				Connection conn = DatabaseUtil.getInstance().getConnection();
				
			
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bank.users;");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					//i really like this notation makes it easy to understand for my json brain
					users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} 
			
			return users;
	 		
		}
		
		public User grabUser(String user_name, String password) {
			
			//this function has to be able to grab all the needed user information for the user object form the password and the 
			//username
			
			//need to have a function run inside of the loginDoa and loginManager in some way so that things dont get crazy
			//easier to seperate
			//maybe i can just grab the info already from the select statement im making. I dont need to really have a credentials object
			//because it should just do it all in one place and only once i dont need to keep track of it. 
			return null;
		}
		
		public int save(User u) {
			return 0;
		}
		
		public void update(int id, String f_name) {
			
		}
		
	public void delete(int id) {
			
		}
}
