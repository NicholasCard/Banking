package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.pojo.CustomerAccount;
import common.pojo.User;
import common.util.DatabaseUtil;

public class CustomerAccDao {

	
	//need the functions that grab the 
	//-view balance
	//deposit
	//withdrawal
	
	public CustomerAccount showAccounts(User currentUser) {
		
		CustomerAccount selectedAcc = new CustomerAccount();
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT id, total, acc_name FROM bank.accounts WHERE user_id = ?;");
			
			pstmt.setInt(1, currentUser.getId());
			
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
			//this can be a method but for right now i have to chill
			selectedAcc.setId(rs.getInt(1));
			selectedAcc.setTotal(rs.getInt(2));
			selectedAcc.setAcc_name(rs.getString(3));
			
		}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return selectedAcc;
	}
}
