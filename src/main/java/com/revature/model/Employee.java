package com.revature.model;

public class Employee extends User {

	public Employee() {
		super();
	}

	public Employee(int id, String username, String password, String firstname, String lastname, String email) {
		super(id, username, password, firstname, lastname, email);
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
