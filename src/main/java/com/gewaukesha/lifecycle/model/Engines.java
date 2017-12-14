package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractEngines;

/**
 * Engines entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "engines", catalog = "gepw_lifecycle_tool")
public class Engines extends AbstractEngines implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Engines() {
	}

	/** minimal constructor */
	public Engines(String model) {
		super(model);
	}

	/** full constructor */
	public Engines(String model, String imageUrl, String modelStatus, Float oilConsumptionRate, Float lubeOilCapacity,
			Timestamp updated, Set<Intervals> intervalses, Set<Reports> reportses, Set<EnginesSpeeds> enginesSpeedses) {
		super(model, imageUrl, modelStatus, oilConsumptionRate, lubeOilCapacity, updated, intervalses, reportses,
				enginesSpeedses);
	}

}
