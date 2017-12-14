package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractIntervals;

/**
 * Intervals entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "intervals", catalog = "gepw_lifecycle_tool")
public class Intervals extends AbstractIntervals implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Intervals() {
	}

	/** minimal constructor */
	public Intervals(Engines engines, IntervalTypes intervalTypes, Integer occurrenceHour) {
		super(engines, intervalTypes, occurrenceHour);
	}

	/** full constructor */
	public Intervals(Engines engines, IntervalTypes intervalTypes, Boolean repeat, Short laborHours,
			Integer occurrenceHour, Float travelExpense, Timestamp created, Timestamp updated,
			Set<ReportsIntervals> reportsIntervalses, Set<IntervalsParts> intervalsPartses) {
		super(engines, intervalTypes, repeat, laborHours, occurrenceHour, travelExpense, created, updated,
				reportsIntervalses, intervalsPartses);
	}

}
