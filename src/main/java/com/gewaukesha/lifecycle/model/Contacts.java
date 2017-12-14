package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractContacts;

/**
 * Contacts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "contacts", catalog = "gepw_lifecycle_tool")
public class Contacts extends AbstractContacts implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Contacts() {
	}

	/** minimal constructor */
	public Contacts(String name) {
		super(name);
	}

	/** full constructor */
	public Contacts(Companies companies, Users users, String name, Timestamp updated, Set<Reports> reportses) {
		super(companies, users, name, updated, reportses);
	}

}
