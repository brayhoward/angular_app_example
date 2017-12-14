package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractOilType;

/**
 * OilType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "oil_type", catalog = "gepw_lifecycle_tool")
public class OilType extends AbstractOilType implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OilType() {
	}

	/** minimal constructor */
	public OilType(String name) {
		super(name);
	}

	/** full constructor */
	public OilType(String name, Timestamp updated, Set<Reports> reportses) {
		super(name, updated, reportses);
	}

}
