package com.gewaukesha.lifecycle.model.abst;

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

import com.gewaukesha.lifecycle.model.Intervals;

/**
 * AbstractIntervalTypes entity provides the base persistence definition of the
 * IntervalTypes entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractIntervalTypes implements java.io.Serializable {

	// Fields

	private String intervalTypesId;
	private String name;
	private Set<Intervals> intervalses = new HashSet<Intervals>(0);

	// Constructors

	/** default constructor */
	public AbstractIntervalTypes() {
	}

	/** full constructor */
	public AbstractIntervalTypes(String name, Set<Intervals> intervalses) {
		this.name = name;
		this.intervalses = intervalses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "interval_types_id", unique = true, nullable = false, length = 40)

	public String getIntervalTypesId() {
		return this.intervalTypesId;
	}

	public void setIntervalTypesId(String intervalTypesId) {
		this.intervalTypesId = intervalTypesId;
	}

	@Column(name = "name", length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "intervalTypes")

	public Set<Intervals> getIntervalses() {
		return this.intervalses;
	}

	public void setIntervalses(Set<Intervals> intervalses) {
		this.intervalses = intervalses;
	}

}