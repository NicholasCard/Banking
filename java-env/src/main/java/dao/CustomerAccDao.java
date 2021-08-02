package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import common.pojo.CustomerAccount;
import common.pojo.Transaction;
import common.pojo.User;
import common.util.DatabaseUtil;

public class CustomerAccDao {
	
	public List<CustomerAccount> showAccounts(User currentUser) {
		List<CustomerAccount> ca = new ArrayList<CustomerAccount>();
		
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT id, total, acc_name FROM bank.accounts WHERE user_id = ?;");
			
			pstmt.setInt(1, currentUser.getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
			//this can be a method but for right now i have to chill
				ca.add(new CustomerAccount(rs.getInt(1), rs.getString(3), rs.getInt(2)));
		}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ca;
	}
	
	//need a view account query so that I can grab the balance anytime instead of running the view all account query
	
	//adding little functions to just display information would be extremely useful
	
	
	
	public int viewBalance(int user_id, int id) {
		int balance = 0;

		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT total FROM bank.accounts WHERE user_id = ? and id = ?;");
			
			
			
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, id);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				balance = rs.getInt(1);
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return balance;
	}
	
	public void accWithdrawal(int id, int withdrawal, int user_id) {
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			//have to check somewhere if the value is lower than the current account balance
			
			PreparedStatement withdrawalPstmt = conn.prepareStatement("UPDATE bank.accounts SET total = total + ? WHERE user_id = ? AND id = ?;");
			
			
			
			withdrawalPstmt.setInt(1, withdrawal);
			withdrawalPstmt.setInt(2, user_id);
			withdrawalPstmt.setInt(3, id);
			
			withdrawalPstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
		


	public void deposit(int id, int deposit, int user_id) {
	
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			PreparedStatement pstmt = conn.prepareStatement("UPDATE bank.accounts SET total = total + ? WHERE user_id = ? AND id = ?;");
		
			pstmt.setInt(1, deposit);
			pstmt.setInt(2, user_id);
			pstmt.setInt(3, id);
		
			pstmt.executeUpdate();
		
		} catch (SQLException ex) {
		ex.printStackTrace();
		}
	}

	public void transactionUpdate(int acc_id, int user_id, String type, int amount) {
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			//have to check somewhere if the value is lower than the current account balance
			
			PreparedStatement transactionPstmt = conn.prepareStatement("INSERT INTO bank.transactions (user_id, acc_id, transaction_type, amount) VALUES(?, ?, ?, ?);");
			
			transactionPstmt.setInt(1, user_id);
			transactionPstmt.setInt(2, acc_id);
			transactionPstmt.setString(3, type);
			transactionPstmt.setInt(4, amount);
			
			int row = transactionPstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
public List<Transaction> transactions(int user_id) {
		
	List<Transaction> t = new ArrayList<Transaction>();
	
	
	//figure out date time and the formatting later
    //Date date = Calendar.getInstance().getTime();  
    //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
    
    //String strDate = dateFormat.format(date);  
		
	
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			//have to check somewhere if the value is lower than the current account balance
			
			PreparedStatement transactionPstmt = conn.prepareStatement("SELECT t.*, a.acc_name FROM bank.transactions t JOIN bank.accounts a ON t.user_id = a.user_id where t.user_id = ?;");
			
			transactionPstmt.setInt(1, user_id);
			
			 ResultSet rs = transactionPstmt.executeQuery();
			 
			 //add date
			 while (rs.next()) {
					//this can be a method but for right now i have to chill
						t.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(5), rs.getString(4), rs.getString(8)));
				}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return t;
	}
	
public List<Transaction> accTransactions(int user_id, int acc_id) {
	
	List<Transaction> at = new ArrayList<Transaction>();
	
	
	//figure out date time and the formatting later
    //Date date = Calendar.getInstance().getTime();  
    //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
    
    //String strDate = dateFormat.format(date);  
		
	
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			//have to check somewhere if the value is lower than the current account balance
			
			PreparedStatement transactionPstmt = conn.prepareStatement("SELECT t.*, a.acc_name FROM bank.transactions t JOIN bank.accounts a ON t.user_id = a.user_id WHERE t.user_id = ? AND t.acc_id = ?;");
			
			transactionPstmt.setInt(1, user_id);
			transactionPstmt.setInt(2, acc_id);
			
			 ResultSet rs = transactionPstmt.executeQuery();
			 
			 //add date
			 while (rs.next()) {
					//this can be a method but for right now i have to chill
						at.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(5), rs.getString(4), rs.getString(8)));
				}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return at;
	}

	public void createAccount(String acc_name, int initial_value) {
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			//have to check somewhere if the value is lower than the current account balance
			
			PreparedStatement createPstmt = conn.prepareStatement("INSERT INTO bank.accounts(acc_name, total) VALUES(?, ?);");
			
			createPstmt.setString(1, acc_name);
			createPstmt.setInt(2, initial_value);
			
			createPstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void deleteAccount(int acc_id, int user_id) {
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			//make a better query statement
			//have to check somewhere if the value is lower than the current account balance
			
			PreparedStatement deletePstmt = conn.prepareStatement("DELETE FROM bank.accounts WHERE id = ? AND user_id = ?;");
			
			deletePstmt.setInt(1, acc_id);
			deletePstmt.setInt(2, user_id);
			
			
			deletePstmt.executeUpdate();
			
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
