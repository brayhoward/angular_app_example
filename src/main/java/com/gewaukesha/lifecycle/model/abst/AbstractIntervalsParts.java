package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.Intervals;
import com.gewaukesha.lifecycle.model.Parts;

/**
 * AbstractIntervalsParts entity provides the base persistence definition of the
 * IntervalsParts entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractIntervalsParts implements java.io.Serializable {

	// Fields

	private Integer intervalPartsId;
	private Parts parts;
	private Intervals intervals;
	private Integer count;
	private Timestamp updated;

	// Constructors

	/** default constructor */
	public AbstractIntervalsParts() {
	}

	/** minimal constructor */
	public AbstractIntervalsParts(Parts parts, Intervals intervals) {
		this.parts = parts;
		this.intervals = intervals;
	}

	/** full constructor */
	public AbstractIntervalsParts(Parts parts, Intervals intervals, Integer count, Timestamp updated) {
		this.parts = parts;
		this.intervals = intervals;
		this.count = count;
		this.updated = updated;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "interval_parts_id", unique = true, nullable = false)

	public Integer getIntervalPartsId() {
		return this.intervalPartsId;
	}

	public void setIntervalPartsId(Integer intervalPartsId) {
		this.intervalPartsId = intervalPartsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id", nullable = false)

	public Parts getParts() {
		return this.parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "interval_id", nullable = false)

	public Intervals getIntervals() {
		return this.intervals;
	}

	public void setIntervals(Intervals intervals) {
		this.intervals = intervals;
	}

	@Column(name = "count")

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

}