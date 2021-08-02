package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.pojo.User;
import common.util.DatabaseUtil;

public class RegisterDao {

	public void registerUser(String f_name, String l_name, String userName, String password) {
		
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO bank.users(f_name, l_name, user_name, password, role) VALUES(?, ?, ?, ?, 'customer');");
			
			
			pstmt.setString(1, f_name);
			pstmt.setString(2, l_name);
			pstmt.setString(3, userName);
			pstmt.setString(4, password);
			
			pstmt.executeUpdate();
			//pstmt.executeQuery();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	
}
