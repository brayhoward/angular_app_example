package com.gewaukesha.lifecycle.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractUomCategories;

/**
 * UomCategories entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uom_categories", catalog = "gepw_lifecycle_tool")
public class UomCategories extends AbstractUomCategories implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UomCategories() {
	}

	/** minimal constructor */
	public UomCategories(String name) {
		super(name);
	}

	/** full constructor */
	public UomCategories(String name, Set<UomValues> uomValueses) {
		super(name, uomValueses);
	}

}
