package com.itwill.instagram.model;

//DTO....

public class InstaMember {
	//field...
	private String id;
	private String password;
	private String email;
	private String phone;

	//constructor
	public InstaMember() {}

	public InstaMember(String id, String password, String email, String phone) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}//아규먼트를 갖는 생성자....

	//getter,setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "Instagram Account ( Id = "+this.id+
				", Password = "+this.password+
				", E-mail = "+this.email+
				", Phone = "+this.phone+
				" )";
	}//toString over_ride...


}
