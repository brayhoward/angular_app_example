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
 * AbstractFuels entity provides the base persistence definition of the Fuels
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractFuels implements java.io.Serializable {

	// Fields

	private String fuelId;
	private String name;
	private Timestamp updated;
	private Boolean altWarning;
	private Set<Reports> reportses = new HashSet<Reports>(0);

	// Constructors

	/** default constructor */
	public AbstractFuels() {
	}

	/** minimal constructor */
	public AbstractFuels(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractFuels(String name, Timestamp updated, Boolean altWarning, Set<Reports> reportses) {
		this.name = name;
		this.updated = updated;
		this.altWarning = altWarning;
		this.reportses = reportses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "fuel_id", unique = true, nullable = false, length = 40)

	public String getFuelId() {
		return this.fuelId;
	}

	public void setFuelId(String fuelId) {
		this.fuelId = fuelId;
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

	@Column(name = "alt_warning")

	public Boolean getAltWarning() {
		return this.altWarning;
	}

	public void setAltWarning(Boolean altWarning) {
		this.altWarning = altWarning;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fuels")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

}