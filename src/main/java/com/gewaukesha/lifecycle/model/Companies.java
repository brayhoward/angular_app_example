package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractCompanies;

/**
 * Companies entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "companies", catalog = "gepw_lifecycle_tool")
public class Companies extends AbstractCompanies implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Companies() {
	}

	/** minimal constructor */
	public Companies(String name) {
		super(name);
	}

	/** full constructor */
	public Companies(Users users, String name, Timestamp updated, Set<Contacts> contactses) {
		super(users, name, updated, contactses);
	}

}
