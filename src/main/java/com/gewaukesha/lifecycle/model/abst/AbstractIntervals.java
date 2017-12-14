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

import com.gewaukesha.lifecycle.model.Engines;
import com.gewaukesha.lifecycle.model.IntervalTypes;
import com.gewaukesha.lifecycle.model.IntervalsParts;
import com.gewaukesha.lifecycle.model.ReportsIntervals;

/**
 * AbstractIntervals entity provides the base persistence definition of the
 * Intervals entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractIntervals implements java.io.Serializable {

	// Fields

	private String intervalId;
	private Engines engines;
	private IntervalTypes intervalTypes;
	private Boolean repeat;
	private Short laborHours;
	private Integer occurrenceHour;
	private Float travelExpense;
	private Timestamp created;
	private Timestamp updated;
	private Set<ReportsIntervals> reportsIntervalses = new HashSet<ReportsIntervals>(0);
	private Set<IntervalsParts> intervalsPartses = new HashSet<IntervalsParts>(0);

	// Constructors

	/** default constructor */
	public AbstractIntervals() {
	}

	/** minimal constructor */
	public AbstractIntervals(Engines engines, IntervalTypes intervalTypes, Integer occurrenceHour) {
		this.engines = engines;
		this.intervalTypes = intervalTypes;
		this.occurrenceHour = occurrenceHour;
	}

	/** full constructor */
	public AbstractIntervals(Engines engines, IntervalTypes intervalTypes, Boolean repeat, Short laborHours,
			Integer occurrenceHour, Float travelExpense, Timestamp created, Timestamp updated,
			Set<ReportsIntervals> reportsIntervalses, Set<IntervalsParts> intervalsPartses) {
		this.engines = engines;
		this.intervalTypes = intervalTypes;
		this.repeat = repeat;
		this.laborHours = laborHours;
		this.occurrenceHour = occurrenceHour;
		this.travelExpense = travelExpense;
		this.created = created;
		this.updated = updated;
		this.reportsIntervalses = reportsIntervalses;
		this.intervalsPartses = intervalsPartses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "interval_id", unique = true, nullable = false, length = 40)

	public String getIntervalId() {
		return this.intervalId;
	}

	public void setIntervalId(String intervalId) {
		this.intervalId = intervalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "engine_id", nullable = false)

	public Engines getEngines() {
		return this.engines;
	}

	public void setEngines(Engines engines) {
		this.engines = engines;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "interval_type_id", nullable = false)

	public IntervalTypes getIntervalTypes() {
		return this.intervalTypes;
	}

	public void setIntervalTypes(IntervalTypes intervalTypes) {
		this.intervalTypes = intervalTypes;
	}

	@Column(name = "repeat")

	public Boolean getRepeat() {
		return this.repeat;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
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

	@Column(name = "travel_expense", precision = 12, scale = 0)

	public Float getTravelExpense() {
		return this.travelExpense;
	}

	public void setTravelExpense(Float travelExpense) {
		this.travelExpense = travelExpense;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "intervals")

	public Set<ReportsIntervals> getReportsIntervalses() {
		return this.reportsIntervalses;
	}

	public void setReportsIntervalses(Set<ReportsIntervals> reportsIntervalses) {
		this.reportsIntervalses = reportsIntervalses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "intervals")

	public Set<IntervalsParts> getIntervalsPartses() {
		return this.intervalsPartses;
	}

	public void setIntervalsPartses(Set<IntervalsParts> intervalsPartses) {
		this.intervalsPartses = intervalsPartses;
	}

}