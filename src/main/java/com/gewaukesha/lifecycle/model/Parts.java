package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractParts;

/**
 * Parts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "parts", catalog = "gepw_lifecycle_tool")
public class Parts extends AbstractParts implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Parts() {
	}

	/** minimal constructor */
	public Parts(PartsType partsType, PartsCategories partsCategories, String partNumber, Float listPrice) {
		super(partsType, partsCategories, partNumber, listPrice);
	}

	/** full constructor */
	public Parts(PartsType partsType, Users users, PartsCategories partsCategories, Currencies currencies,
			String partNumber, String description, Float listPrice, Timestamp created, Timestamp updated,
			Set<ReportsIntervalsParts> reportsIntervalsPartses, Set<IntervalsParts> intervalsPartses) {
		super(partsType, users, partsCategories, currencies, partNumber, description, listPrice, created, updated,
				reportsIntervalsPartses, intervalsPartses);
	}

}
