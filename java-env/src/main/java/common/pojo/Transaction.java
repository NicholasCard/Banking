package common.pojo;

public class Transaction {
	private int id;
	private int acc_id;
	private int user_id;
	private int transaction_amount;
	
	private String transaction_type;
	private String transaction_date;
	private String acc_name;
	
		
		
	public Transaction() {
			super();
	}
		
	public Transaction(int id, int acc_id, int user_id, int transaction_amount, String transaction_type, String transaction_date, String acc_name) {
		super();
		this.setId(id);
		this.setAcc_id(acc_id);
		this.setUser_id(user_id);
		this.setTransaction_amount(transaction_amount);
		this.setTransaction_type(transaction_type);
		this.setTransaction_date(transaction_date);
		this.setAcc_name(acc_name);
	}

	public Transaction(int id, int acc_id, int user_id, int transaction_amount, String transaction_type, String acc_name) {
		super();
		this.setId(id);
		this.setAcc_id(acc_id);
		this.setUser_id(user_id);
		this.setTransaction_amount(transaction_amount);
		this.setTransaction_type(transaction_type);
		
		this.setAcc_name(acc_name);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public int getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	 
}
