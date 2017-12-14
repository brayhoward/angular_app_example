package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractReportsIntervalsParts;

/**
 * ReportsIntervalsParts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reports_intervals_parts", catalog = "gepw_lifecycle_tool")
public class ReportsIntervalsParts extends AbstractReportsIntervalsParts implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ReportsIntervalsParts() {
	}

	/** full constructor */
	public ReportsIntervalsParts(Parts parts, ReportsIntervals reportsIntervals, Integer quantity, Timestamp updated) {
		super(parts, reportsIntervals, quantity, updated);
	}

}
