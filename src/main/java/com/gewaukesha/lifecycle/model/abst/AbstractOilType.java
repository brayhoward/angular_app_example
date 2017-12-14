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

import com.gewaukesha.lifecycle.model.Reports;

/**
 * AbstractOilType entity provides the base persistence definition of the
 * OilType entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractOilType implements java.io.Serializable {

	// Fields

	private String oilTypeId;
	private String name;
	private Timestamp updated;
	private Set<Reports> reportses = new HashSet<Reports>(0);

	// Constructors

	/** default constructor */
	public AbstractOilType() {
	}

	/** minimal constructor */
	public AbstractOilType(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractOilType(String name, Timestamp updated, Set<Reports> reportses) {
		this.name = name;
		this.updated = updated;
		this.reportses = reportses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "oil_type_id", unique = true, nullable = false, length = 40)

	public String getOilTypeId() {
		return this.oilTypeId;
	}

	public void setOilTypeId(String oilTypeId) {
		this.oilTypeId = oilTypeId;
	}

	@Column(name = "name", nullable = false, length = 45)

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "oilType")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

}