package com.gewaukesha.lifecycle.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractIntervalTypes;

/**
 * IntervalTypes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "interval_types", catalog = "gepw_lifecycle_tool")
public class IntervalTypes extends AbstractIntervalTypes implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public IntervalTypes() {
	}

	/** full constructor */
	public IntervalTypes(String name, Set<Intervals> intervalses) {
		super(name, intervalses);
	}

}
