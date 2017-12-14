package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.Companies;
import com.gewaukesha.lifecycle.model.Reports;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractContacts entity provides the base persistence definition of the
 * Contacts entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractContacts implements java.io.Serializable {

	// Fields

	private String contactId;
	private Companies companies;
	private Users users;
	private String name;
	private Timestamp updated;
	private Set<Reports> reportses = new HashSet<Reports>(0);

	// Constructors

	/** default constructor */
	public AbstractContacts() {
	}

	/** minimal constructor */
	public AbstractContacts(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractContacts(Companies companies, Users users, String name, Timestamp updated, Set<Reports> reportses) {
		this.companies = companies;
		this.users = users;
		this.name = name;
		this.updated = updated;
		this.reportses = reportses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "contact_id", unique = true, nullable = false, length = 40)

	public String getContactId() {
		return this.contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")

	public Companies getCompanies() {
		return this.companies;
	}

	public void setCompanies(Companies companies) {
		this.companies = companies;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_user_id")

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "name", nullable = false, length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contacts")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

}