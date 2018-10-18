package com.revature.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_USERS")
public class Manager extends User {

	@OneToMany(cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "u_id_resolver")
	protected Set<Reimbursements> reimbursements;

	public Manager() {
		super();
	}

	public Manager(String id, String username, String password, String firstname, String lastname, String email,
			String role) {
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

	public Set<Reimbursements> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(Set<Reimbursements> reimbursements) {
		this.reimbursements = reimbursements;
	}

}
