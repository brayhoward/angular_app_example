package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractRoles;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roles", catalog = "gepw_lifecycle_tool")
public class Roles extends AbstractRoles implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** minimal constructor */
	public Roles(String name) {
		super(name);
	}

	/** full constructor */
	public Roles(String name, Boolean canAdmin, Boolean canViewAllParts, Boolean canViewAllReports,
			Boolean canEditReport, Timestamp updated, Set<Users> userses) {
		super(name, canAdmin, canViewAllParts, canViewAllReports, canEditReport, updated, userses);
	}

}
