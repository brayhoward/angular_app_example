package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.EnginesSpeeds;
import com.gewaukesha.lifecycle.model.Intervals;
import com.gewaukesha.lifecycle.model.Reports;

/**
 * AbstractEngines entity provides the base persistence definition of the
 * Engines entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractEngines implements java.io.Serializable {

	// Fields

	private String engineId;
	private String model;
	private String imageUrl;
	private String modelStatus;
	private Float oilConsumptionRate;
	private Float lubeOilCapacity;
	private Timestamp updated;
	private Set<Intervals> intervalses = new HashSet<Intervals>(0);
	private Set<Reports> reportses = new HashSet<Reports>(0);
	private Set<EnginesSpeeds> enginesSpeedses = new HashSet<EnginesSpeeds>(0);

	// Constructors

	/** default constructor */
	public AbstractEngines() {
	}

	/** minimal constructor */
	public AbstractEngines(String model) {
		this.model = model;
	}

	/** full constructor */
	public AbstractEngines(String model, String imageUrl, String modelStatus, Float oilConsumptionRate,
			Float lubeOilCapacity, Timestamp updated, Set<Intervals> intervalses, Set<Reports> reportses,
			Set<EnginesSpeeds> enginesSpeedses) {
		this.model = model;
		this.imageUrl = imageUrl;
		this.modelStatus = modelStatus;
		this.oilConsumptionRate = oilConsumptionRate;
		this.lubeOilCapacity = lubeOilCapacity;
		this.updated = updated;
		this.intervalses = intervalses;
		this.reportses = reportses;
		this.enginesSpeedses = enginesSpeedses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "engine_id", unique = true, nullable = false, length = 40)

	public String getEngineId() {
		return this.engineId;
	}

	public void setEngineId(String engineId) {
		this.engineId = engineId;
	}

	@Column(name = "model", nullable = false, length = 30)

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "image_url", length = 300)

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "model_status", length = 1)

	public String getModelStatus() {
		return this.modelStatus;
	}

	public void setModelStatus(String modelStatus) {
		this.modelStatus = modelStatus;
	}

	@Column(name = "oil_consumption_rate", precision = 12, scale = 0)

	public Float getOilConsumptionRate() {
		return this.oilConsumptionRate;
	}

	public void setOilConsumptionRate(Float oilConsumptionRate) {
		this.oilConsumptionRate = oilConsumptionRate;
	}

	@Column(name = "lube_oil_capacity", precision = 12, scale = 0)

	public Float getLubeOilCapacity() {
		return this.lubeOilCapacity;
	}

	public void setLubeOilCapacity(Float lubeOilCapacity) {
		this.lubeOilCapacity = lubeOilCapacity;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "engines")

	public Set<Intervals> getIntervalses() {
		return this.intervalses;
	}

	public void setIntervalses(Set<Intervals> intervalses) {
		this.intervalses = intervalses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "engines")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "engines")

	public Set<EnginesSpeeds> getEnginesSpeedses() {
		return this.enginesSpeedses;
	}

	public void setEnginesSpeedses(Set<EnginesSpeeds> enginesSpeedses) {
		this.enginesSpeedses = enginesSpeedses;
	}

}