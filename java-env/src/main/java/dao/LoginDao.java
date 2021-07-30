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
		User authorizedUser = new User();
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT id, user_name, f_name, l_name, role FROM bank.users WHERE user_name = ? and password = ?;");
			
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
			//this can be a method but for right now i have to chill
			authorizedUser.setId(rs.getInt(1));
			authorizedUser.setUser_name(rs.getString(2));
			authorizedUser.setF_name(rs.getString(3));
			authorizedUser.setL_name(rs.getString(4));
			authorizedUser.setRole(rs.getString(5));
		}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return authorizedUser;
	}
	
	
}
