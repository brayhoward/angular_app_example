package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractFuels;

/**
 * Fuels entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fuels", catalog = "gepw_lifecycle_tool")
public class Fuels extends AbstractFuels implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Fuels() {
	}

	/** minimal constructor */
	public Fuels(String name) {
		super(name);
	}

	/** full constructor */
	public Fuels(String name, Timestamp updated, Boolean altWarning, Set<Reports> reportses) {
		super(name, updated, altWarning, reportses);
	}

}
