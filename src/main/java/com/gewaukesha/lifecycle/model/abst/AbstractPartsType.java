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
 * AbstractPartsType entity provides the base persistence definition of the
 * PartsType entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractPartsType implements java.io.Serializable {

	// Fields

	private String partsTypeId;
	private String name;
	private Timestamp updated;
	private Set<Parts> partses = new HashSet<Parts>(0);

	// Constructors

	/** default constructor */
	public AbstractPartsType() {
	}

	/** minimal constructor */
	public AbstractPartsType(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractPartsType(String name, Timestamp updated, Set<Parts> partses) {
		this.name = name;
		this.updated = updated;
		this.partses = partses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "parts_type_id", unique = true, nullable = false, length = 40)

	public String getPartsTypeId() {
		return this.partsTypeId;
	}

	public void setPartsTypeId(String partsTypeId) {
		this.partsTypeId = partsTypeId;
	}

	@Column(name = "name", nullable = false, length = 70)

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partsType")

	public Set<Parts> getPartses() {
		return this.partses;
	}

	public void setPartses(Set<Parts> partses) {
		this.partses = partses;
	}

}