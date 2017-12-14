package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractPartsType;

/**
 * PartsType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "parts_type", catalog = "gepw_lifecycle_tool")
public class PartsType extends AbstractPartsType implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PartsType() {
	}

	/** minimal constructor */
	public PartsType(String name) {
		super(name);
	}

	/** full constructor */
	public PartsType(String name, Timestamp updated, Set<Parts> partses) {
		super(name, updated, partses);
	}

}
