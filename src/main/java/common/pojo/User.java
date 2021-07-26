package common.pojo;

public class User {

	private int id;
	private String f_name;
	private String l_name;
	private String role;
		
		
	public User() {
			super();
	}
		
	public User(String f_name) {
		super();
		this.f_name = f_name;
	}
		
		
	public User(int id, String f_name, String l_name, String role) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.role = role;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
