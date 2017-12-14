package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractEnginesSpeeds;

/**
 * EnginesSpeeds entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "engines_speeds", catalog = "gepw_lifecycle_tool")
public class EnginesSpeeds extends AbstractEnginesSpeeds implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public EnginesSpeeds() {
	}

	/** minimal constructor */
	public EnginesSpeeds(Engines engines, Short rpm, Short maxBhp, Integer bottomEndOverhaulHours,
			Short topToBottomRatio) {
		super(engines, rpm, maxBhp, bottomEndOverhaulHours, topToBottomRatio);
	}

	/** full constructor */
	public EnginesSpeeds(Engines engines, Short rpm, Short maxBhp, String btuHpHpFormula,
			Integer bottomEndOverhaulHours, Short topToBottomRatio, Timestamp updated, Set<Reports> reportses) {
		super(engines, rpm, maxBhp, btuHpHpFormula, bottomEndOverhaulHours, topToBottomRatio, updated, reportses);
	}

}
