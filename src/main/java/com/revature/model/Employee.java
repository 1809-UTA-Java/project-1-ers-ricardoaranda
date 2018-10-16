package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_USERS")
public class Employee extends User {

	public Employee() {
		super();
	}

	public Employee(String id, String username, String password, String firstname, String lastname, String email, String role) {
		super(id, username, password, firstname, lastname, email, role);
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewHomePage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAccountInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editAccountInfo() {
		// TODO Auto-generated method stub
		
	}
	
}
