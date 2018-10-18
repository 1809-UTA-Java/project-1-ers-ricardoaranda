package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_REIMBURSEMENTS")
public class Reimbursements {
	public enum ReimbursementType {
		TRAVEL, SUPPLIES, MISCELLANIOUS
	}

	public enum ReimbursementStatus {
		APPROVED, DENIED, PENDING
	}

	// change id to String type
	@Id
	@Column(name = "r_id")
	private String id;

	@Column(name = "r_amount")
	private int ammount;

	@Column(name = "r_description")
	private String description;

	@Column(name = "r_receipt")
	private byte receipt[];

	@Column(name = "r_submitted")
	private Timestamp submitted;

	@Column(name = "r_resolved")
	private Timestamp resolved;

	@Column(name = "r_type")
	private String type;

	@Column(name = "r_status")
	private String status;

//	@Column(name="u_id_author")
//	private int authorId;
//	
//	@Column(name="u_id_resolver")
//	private int resolverId;

	// u_id_author???
//	@ManyToOne
//	private User user;
	@ManyToOne
	@JoinColumn(name="u_id_author") //
	private Employee author;

	@ManyToOne
	@JoinColumn(name="u_id_resolver")
	private Manager resolver;

	public Reimbursements() {

	}

	public Reimbursements(String id, int ammount, String description, 
//			byte[] receipt, 
			Timestamp submitted, 
//			Timestamp resolved, int authorId, int resolverId, 
			Employee author,
			String type, String status) {
		super();
		this.id = id;
		this.ammount = ammount;
		this.description = description;
//		this.receipt = receipt;
		this.submitted = submitted;
//		this.resolved = resolved;
//		this.authorId = authorId;
//		this.resolverId = resolverId;
		this.author = author;
		this.type = type;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

//	public int getAuthorId() {
//		return authorId;
//	}
//
//	public void setAuthorId(int authorId) {
//		this.authorId = authorId;
//	}
//
//	public int getResolverId() {
//		return resolverId;
//	}
//
//	public void setResolverId(int resolverId) {
//		this.resolverId = resolverId;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	public Manager getResolver() {
		return resolver;
	}

	public void setResolver(Manager resolver) {
		this.resolver = resolver;
	}

}
