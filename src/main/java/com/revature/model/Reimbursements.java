package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENTS")
public class Reimbursements {
	public enum ReimbursementType {
		TRAVEL, SUPPLIES, MISCELLANIOUS
	}

	public enum ReimbursementStatus {
		APPROVED, DENIED
	}

	// change id to String type
	private int id;
	private int ammount;
	private String description;
	private byte receipt[];
	private Timestamp submitted;
	private Timestamp resolved;
	private int authorId;
	private int resolverId;
	private ReimbursementType type;
	private ReimbursementStatus status;

	public Reimbursements() {

	}

	public Reimbursements(int id, int ammount, String description, byte[] receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.id = id;
		this.ammount = ammount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
}
