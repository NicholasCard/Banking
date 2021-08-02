package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.pojo.CustomerAccount;
import common.pojo.Transaction;
import common.util.DatabaseUtil;

public class EmployeeDao {
	
	public List<Transaction> showTransactions() {

			List<Transaction> t = new ArrayList<Transaction>();
		
	
				try {
					Connection conn = DatabaseUtil.getInstance().getConnection();
					//make a better query statement
					//have to check somewhere if the value is lower than the current account balance
			
					PreparedStatement transactionPstmt = conn.prepareStatement("SELECT t.* FROM bank.transactions t;");
			
					
			
					ResultSet rs = transactionPstmt.executeQuery();
			 
										
					while (rs.next()) {
				
						t.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(5), rs.getString(4), rs.getString(8)));
					}
			
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				return t;
		}
	
	public List<CustomerAccount> approveAccounts() {

		
		List<CustomerAccount> ca = new ArrayList<CustomerAccount>();

			try {
				Connection conn = DatabaseUtil.getInstance().getConnection();
				//make a better query statement
				//have to check somewhere if the value is lower than the current account balance
		
				PreparedStatement transactionPstmt = conn.prepareStatement("SELECT a.*, u.f_name, u.l_name FROM bank.accounts a JOIN bank.users u ON a.user_id = u.id WHERE approved = 'false';");
		
				
		
				ResultSet rs = transactionPstmt.executeQuery();
		 
									
				while (rs.next()) {
			
					ca.add(new CustomerAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
				}
		
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return ca;
	}
	
}
