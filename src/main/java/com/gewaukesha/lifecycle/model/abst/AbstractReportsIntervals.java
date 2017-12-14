package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.Intervals;
import com.gewaukesha.lifecycle.model.Reports;
import com.gewaukesha.lifecycle.model.ReportsIntervalsParts;

/**
 * AbstractReportsIntervals entity provides the base persistence definition of
 * the ReportsIntervals entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractReportsIntervals implements java.io.Serializable {

	// Fields

	private String reportIntervalId;
	private Intervals intervals;
	private Reports reports;
	private Short laborHours;
	private Integer occurrenceHour;
	private Float travelExpenses;
	private Boolean repeat;
	private Boolean active;
	private Timestamp created;
	private Timestamp updated;
	private Set<ReportsIntervalsParts> reportsIntervalsPartses = new HashSet<ReportsIntervalsParts>(0);

	// Constructors

	/** default constructor */
	public AbstractReportsIntervals() {
	}

	/** minimal constructor */
	public AbstractReportsIntervals(Intervals intervals, Reports reports, Integer occurrenceHour, Boolean repeat) {
		this.intervals = intervals;
		this.reports = reports;
		this.occurrenceHour = occurrenceHour;
		this.repeat = repeat;
	}

	/** full constructor */
	public AbstractReportsIntervals(Intervals intervals, Reports reports, Short laborHours, Integer occurrenceHour,
			Float travelExpenses, Boolean repeat, Boolean active, Timestamp created, Timestamp updated,
			Set<ReportsIntervalsParts> reportsIntervalsPartses) {
		this.intervals = intervals;
		this.reports = reports;
		this.laborHours = laborHours;
		this.occurrenceHour = occurrenceHour;
		this.travelExpenses = travelExpenses;
		this.repeat = repeat;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.reportsIntervalsPartses = reportsIntervalsPartses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "report_interval_id", unique = true, nullable = false, length = 40)

	public String getReportIntervalId() {
		return this.reportIntervalId;
	}

	public void setReportIntervalId(String reportIntervalId) {
		this.reportIntervalId = reportIntervalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "interval_id", nullable = false)

	public Intervals getIntervals() {
		return this.intervals;
	}

	public void setIntervals(Intervals intervals) {
		this.intervals = intervals;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_id", nullable = false)

	public Reports getReports() {
		return this.reports;
	}

	public void setReports(Reports reports) {
		this.reports = reports;
	}

	@Column(name = "labor_hours")

	public Short getLaborHours() {
		return this.laborHours;
	}

	public void setLaborHours(Short laborHours) {
		this.laborHours = laborHours;
	}

	@Column(name = "occurrence_hour", nullable = false)

	public Integer getOccurrenceHour() {
		return this.occurrenceHour;
	}

	public void setOccurrenceHour(Integer occurrenceHour) {
		this.occurrenceHour = occurrenceHour;
	}

	@Column(name = "travel_expenses", precision = 12, scale = 0)

	public Float getTravelExpenses() {
		return this.travelExpenses;
	}

	public void setTravelExpenses(Float travelExpenses) {
		this.travelExpenses = travelExpenses;
	}

	@Column(name = "repeat", nullable = false)

	public Boolean getRepeat() {
		return this.repeat;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
	}

	@Column(name = "active")

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "created", length = 19)

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reportsIntervals")

	public Set<ReportsIntervalsParts> getReportsIntervalsPartses() {
		return this.reportsIntervalsPartses;
	}

	public void setReportsIntervalsPartses(Set<ReportsIntervalsParts> reportsIntervalsPartses) {
		this.reportsIntervalsPartses = reportsIntervalsPartses;
	}

}