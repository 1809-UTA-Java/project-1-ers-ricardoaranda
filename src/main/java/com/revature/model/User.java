package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class User {
	@Id
	@Column(name = "u_id")
	protected String id;

	@Column(name = "u_username")
	protected String username;

	@Column(name = "u_password")
	protected String password;

	@Column(name = "u_firstname")
	protected String firstname;

	@Column(name = "u_lastname")
	protected String lastname;

	@Column(name = "u_email")
	protected String email;

	@Column(name = "u_role")
	protected String role;

	public abstract boolean login();
	public abstract boolean logout();
	public abstract void viewHomePage();
	public abstract void viewAccountInfo();
	public abstract void editAccountInfo();

	public User() {

	}

	public User(String id, String username, String password, String firstname, String lastname, String email,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
