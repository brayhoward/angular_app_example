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

import com.gewaukesha.lifecycle.model.Parts;
import com.gewaukesha.lifecycle.model.ReportsIntervals;

/**
 * AbstractReportsIntervalsParts entity provides the base persistence definition
 * of the ReportsIntervalsParts entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractReportsIntervalsParts implements java.io.Serializable {

	// Fields

	private String reportsIntervalsPartsId;
	private Parts parts;
	private ReportsIntervals reportsIntervals;
	private Integer quantity;
	private Timestamp updated;

	// Constructors

	/** default constructor */
	public AbstractReportsIntervalsParts() {
	}

	/** full constructor */
	public AbstractReportsIntervalsParts(Parts parts, ReportsIntervals reportsIntervals, Integer quantity,
			Timestamp updated) {
		this.parts = parts;
		this.reportsIntervals = reportsIntervals;
		this.quantity = quantity;
		this.updated = updated;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "reports_intervals_parts_id", unique = true, nullable = false, length = 40)

	public String getReportsIntervalsPartsId() {
		return this.reportsIntervalsPartsId;
	}

	public void setReportsIntervalsPartsId(String reportsIntervalsPartsId) {
		this.reportsIntervalsPartsId = reportsIntervalsPartsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")

	public Parts getParts() {
		return this.parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_interval_id")

	public ReportsIntervals getReportsIntervals() {
		return this.reportsIntervals;
	}

	public void setReportsIntervals(ReportsIntervals reportsIntervals) {
		this.reportsIntervals = reportsIntervals;
	}

	@Column(name = "quantity")

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

}