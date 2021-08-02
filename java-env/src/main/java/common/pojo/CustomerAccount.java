package common.pojo;

public class CustomerAccount {

	private int id;
	private int total;
	private String acc_name;
	private String approved;
	private String f_name;
	private String l_name;
	private int user_id;
		
	public CustomerAccount() {
			super();
	}
		
	public CustomerAccount(String acc_name) {
		super();
		this.setAcc_name(acc_name);
	}
		
		
	
	
	public CustomerAccount(int id, String acc_name, int total) {
		super();
		this.setId(id);
		this.setAcc_name(acc_name);
		this.setTotal(total);
		
	}
	
	public CustomerAccount(int id, int user_id, int total, String acc_name, String approved, String f_name, String l_name) {
		super();
		this.setId(id);
		this.setUser_id(user_id);
		this.setAcc_name(acc_name);
		this.setTotal(total);
		this.setApproved(approved);
		this.setF_name(f_name);
		this.setL_name(l_name);
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
