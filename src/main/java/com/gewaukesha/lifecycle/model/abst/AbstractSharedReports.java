package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.Reports;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractSharedReports entity provides the base persistence definition of the
 * SharedReports entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractSharedReports implements java.io.Serializable {

	// Fields

	private String sharedReportsId;
	private Users users;
	private Reports reports;
	private String addressesTo;
	private Timestamp created;

	// Constructors

	/** default constructor */
	public AbstractSharedReports() {
	}

	/** minimal constructor */
	public AbstractSharedReports(Users users, Reports reports, String addressesTo) {
		this.users = users;
		this.reports = reports;
		this.addressesTo = addressesTo;
	}

	/** full constructor */
	public AbstractSharedReports(Users users, Reports reports, String addressesTo, Timestamp created) {
		this.users = users;
		this.reports = reports;
		this.addressesTo = addressesTo;
		this.created = created;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "shared_reports_id", unique = true, nullable = false, length = 36)

	public String getSharedReportsId() {
		return this.sharedReportsId;
	}

	public void setSharedReportsId(String sharedReportsId) {
		this.sharedReportsId = sharedReportsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_id", nullable = false)

	public Reports getReports() {
		return this.reports;
	}

	public void setReports(Reports reports) {
		this.reports = reports;
	}

	@Column(name = "addresses_to", nullable = false, length = 1000)

	public String getAddressesTo() {
		return this.addressesTo;
	}

	public void setAddressesTo(String addressesTo) {
		this.addressesTo = addressesTo;
	}

	@Column(name = "created", length = 19)

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

}