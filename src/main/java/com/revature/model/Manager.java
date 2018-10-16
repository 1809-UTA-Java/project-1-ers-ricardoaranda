package com.revature.model;

public class Manager extends User {

	public Manager() {
		super();
	}

	public Manager(String id, String username, String password, String firstname, String lastname, String email, String role) {
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
