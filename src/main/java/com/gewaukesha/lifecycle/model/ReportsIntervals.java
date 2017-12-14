package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractReportsIntervals;

/**
 * ReportsIntervals entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reports_intervals", catalog = "gepw_lifecycle_tool")
public class ReportsIntervals extends AbstractReportsIntervals implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ReportsIntervals() {
	}

	/** minimal constructor */
	public ReportsIntervals(Intervals intervals, Reports reports, Integer occurrenceHour, Boolean repeat) {
		super(intervals, reports, occurrenceHour, repeat);
	}

	/** full constructor */
	public ReportsIntervals(Intervals intervals, Reports reports, Short laborHours, Integer occurrenceHour,
			Float travelExpenses, Boolean repeat, Boolean active, Timestamp created, Timestamp updated,
			Set<ReportsIntervalsParts> reportsIntervalsPartses) {
		super(intervals, reports, laborHours, occurrenceHour, travelExpenses, repeat, active, created, updated,
				reportsIntervalsPartses);
	}

}
