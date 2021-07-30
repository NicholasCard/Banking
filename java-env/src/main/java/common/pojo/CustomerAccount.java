package common.pojo;

public class CustomerAccount {

	private int id;
	private double total;
	private String acc_name;
	
		
		
	public CustomerAccount() {
			super();
	}
		
	public CustomerAccount(String acc_name) {
		super();
		this.setAcc_name(acc_name);
	}
		
		
	public CustomerAccount(int id, String acc_name, Double total) {
		super();
		this.setId(id);
		this.setAcc_name(acc_name);
		this.setTotal(total);
		
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

	public void setTotal(double total) {
		this.total = total;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	
}
