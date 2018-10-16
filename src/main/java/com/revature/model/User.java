package com.revature.model;

public abstract class User {
	protected String id;
	protected String username;
	protected String password;
	protected String firstname;
	protected String lastname;
	protected String email;
	
	public abstract boolean login();
	public abstract boolean logout();
	public abstract void viewHomePage();
	public abstract void viewAccountInfo();
	public abstract void editAccountInfo();
	

	public User() {
		
	}
	
	public User(String id, String username, String password, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
