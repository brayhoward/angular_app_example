package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractPartsCategories;

/**
 * PartsCategories entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "parts_categories", catalog = "gepw_lifecycle_tool")
public class PartsCategories extends AbstractPartsCategories implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PartsCategories() {
	}

	/** minimal constructor */
	public PartsCategories(String name) {
		super(name);
	}

	/** full constructor */
	public PartsCategories(String name, Timestamp updated, Set<Parts> partses) {
		super(name, updated, partses);
	}

}
