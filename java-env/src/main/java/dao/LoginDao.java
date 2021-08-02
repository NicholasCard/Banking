package dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import common.util.DatabaseUtil;
import common.pojo.User;

public class LoginDao {

	

	public User checkCredentialsUser(String user_name, String password) {
		List<User> users = new ArrayList<User>();
		User authorizedUser = new User();
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, f_name, l_name, role FROM bank.users WHERE user_name = ? and password = ?;");
			
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				authorizedUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return authorizedUser;
	}
	
	
}
