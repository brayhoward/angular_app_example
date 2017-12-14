package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractSharedReports;

/**
 * SharedReports entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shared_reports", catalog = "gepw_lifecycle_tool")
public class SharedReports extends AbstractSharedReports implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public SharedReports() {
	}

	/** minimal constructor */
	public SharedReports(Users users, Reports reports, String addressesTo) {
		super(users, reports, addressesTo);
	}

	/** full constructor */
	public SharedReports(Users users, Reports reports, String addressesTo, Timestamp created) {
		super(users, reports, addressesTo, created);
	}

}
