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

import com.gewaukesha.lifecycle.model.Contacts;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractCompanies entity provides the base persistence definition of the
 * Companies entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractCompanies implements java.io.Serializable {

	// Fields

	private String companyId;
	private Users users;
	private String name;
	private Timestamp updated;
	private Set<Contacts> contactses = new HashSet<Contacts>(0);

	// Constructors

	/** default constructor */
	public AbstractCompanies() {
	}

	/** minimal constructor */
	public AbstractCompanies(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractCompanies(Users users, String name, Timestamp updated, Set<Contacts> contactses) {
		this.users = users;
		this.name = name;
		this.updated = updated;
		this.contactses = contactses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "company_id", unique = true, nullable = false, length = 40)

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_user_id")

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "name", nullable = false, length = 60)

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companies")

	public Set<Contacts> getContactses() {
		return this.contactses;
	}

	public void setContactses(Set<Contacts> contactses) {
		this.contactses = contactses;
	}

}