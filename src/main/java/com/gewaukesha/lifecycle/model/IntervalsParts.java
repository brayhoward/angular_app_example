package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractIntervalsParts;

/**
 * IntervalsParts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "intervals_parts", catalog = "gepw_lifecycle_tool")
public class IntervalsParts extends AbstractIntervalsParts implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public IntervalsParts() {
	}

	/** minimal constructor */
	public IntervalsParts(Parts parts, Intervals intervals) {
		super(parts, intervals);
	}

	/** full constructor */
	public IntervalsParts(Parts parts, Intervals intervals, Integer count, Timestamp updated) {
		super(parts, intervals, count, updated);
	}

}
