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
import com.gewaukesha.lifecycle.model.Reports;

/**
 * AbstractEnginesSpeeds entity provides the base persistence definition of the
 * EnginesSpeeds entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractEnginesSpeeds implements java.io.Serializable {

	// Fields

	private String enginesSpeedsId;
	private Engines engines;
	private Short rpm;
	private Short maxBhp;
	private String btuHpHpFormula;
	private Integer bottomEndOverhaulHours;
	private Short topToBottomRatio;
	private Timestamp updated;
	private Set<Reports> reportses = new HashSet<Reports>(0);

	// Constructors

	/** default constructor */
	public AbstractEnginesSpeeds() {
	}

	/** minimal constructor */
	public AbstractEnginesSpeeds(Engines engines, Short rpm, Short maxBhp, Integer bottomEndOverhaulHours,
			Short topToBottomRatio) {
		this.engines = engines;
		this.rpm = rpm;
		this.maxBhp = maxBhp;
		this.bottomEndOverhaulHours = bottomEndOverhaulHours;
		this.topToBottomRatio = topToBottomRatio;
	}

	/** full constructor */
	public AbstractEnginesSpeeds(Engines engines, Short rpm, Short maxBhp, String btuHpHpFormula,
			Integer bottomEndOverhaulHours, Short topToBottomRatio, Timestamp updated, Set<Reports> reportses) {
		this.engines = engines;
		this.rpm = rpm;
		this.maxBhp = maxBhp;
		this.btuHpHpFormula = btuHpHpFormula;
		this.bottomEndOverhaulHours = bottomEndOverhaulHours;
		this.topToBottomRatio = topToBottomRatio;
		this.updated = updated;
		this.reportses = reportses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "engines_speeds_id", unique = true, nullable = false, length = 40)

	public String getEnginesSpeedsId() {
		return this.enginesSpeedsId;
	}

	public void setEnginesSpeedsId(String enginesSpeedsId) {
		this.enginesSpeedsId = enginesSpeedsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "engine_id", nullable = false)

	public Engines getEngines() {
		return this.engines;
	}

	public void setEngines(Engines engines) {
		this.engines = engines;
	}

	@Column(name = "rpm", nullable = false)

	public Short getRpm() {
		return this.rpm;
	}

	public void setRpm(Short rpm) {
		this.rpm = rpm;
	}

	@Column(name = "max_bhp", nullable = false)

	public Short getMaxBhp() {
		return this.maxBhp;
	}

	public void setMaxBhp(Short maxBhp) {
		this.maxBhp = maxBhp;
	}

	@Column(name = "btu_hp_hp_formula", length = 100)

	public String getBtuHpHpFormula() {
		return this.btuHpHpFormula;
	}

	public void setBtuHpHpFormula(String btuHpHpFormula) {
		this.btuHpHpFormula = btuHpHpFormula;
	}

	@Column(name = "bottom_end_overhaul_hours", nullable = false)

	public Integer getBottomEndOverhaulHours() {
		return this.bottomEndOverhaulHours;
	}

	public void setBottomEndOverhaulHours(Integer bottomEndOverhaulHours) {
		this.bottomEndOverhaulHours = bottomEndOverhaulHours;
	}

	@Column(name = "top_to_bottom_ratio", nullable = false)

	public Short getTopToBottomRatio() {
		return this.topToBottomRatio;
	}

	public void setTopToBottomRatio(Short topToBottomRatio) {
		this.topToBottomRatio = topToBottomRatio;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "enginesSpeeds")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

}