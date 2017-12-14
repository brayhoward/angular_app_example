package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.Parts;

/**
 * AbstractPartsCategories entity provides the base persistence definition of
 * the PartsCategories entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractPartsCategories implements java.io.Serializable {

	// Fields

	private String partsCategoryId;
	private String name;
	private Timestamp updated;
	private Set<Parts> partses = new HashSet<Parts>(0);

	// Constructors

	/** default constructor */
	public AbstractPartsCategories() {
	}

	/** minimal constructor */
	public AbstractPartsCategories(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractPartsCategories(String name, Timestamp updated, Set<Parts> partses) {
		this.name = name;
		this.updated = updated;
		this.partses = partses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "parts_category_id", unique = true, nullable = false, length = 40)

	public String getPartsCategoryId() {
		return this.partsCategoryId;
	}

	public void setPartsCategoryId(String partsCategoryId) {
		this.partsCategoryId = partsCategoryId;
	}

	@Column(name = "name", nullable = false, length = 100)

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partsCategories")

	public Set<Parts> getPartses() {
		return this.partses;
	}

	public void setPartses(Set<Parts> partses) {
		this.partses = partses;
	}

}