package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractReports;

/**
 * Reports entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reports", catalog = "gepw_lifecycle_tool")
public class Reports extends AbstractReports implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Reports() {
	}

	/** minimal constructor */
	public Reports(Engines engines, OilType oilType, Contacts contacts, Currencies currencies, Fuels fuels, Users users,
			String name, Short partsListPriceDiscount) {
		super(engines, oilType, contacts, currencies, fuels, users, name, partsListPriceDiscount);
	}

	/** full constructor */
	public Reports(UomValues uomValuesByOilCostUom, UomValues uomValuesBySiteLoadUom, Engines engines, OilType oilType,
			UomValues uomValuesByOilConsumptionUom, EnginesSpeeds enginesSpeeds, UomValues uomValuesByFuelUom,
			Contacts contacts, Currencies currencies, Fuels fuels, Users users, String name, Short inflation,
			Short siteLoad, Timestamp dateOfCommissioning, Short annualOperatingHours, Short engineCount,
			Boolean usePartsListPriceDiscount, Short partsListPriceDiscount, Boolean includeFuel, Float fuelCost,
			Boolean includeLubrication, Float oilConsumption, Float oilCost, Boolean includeLabor, Float laborRate,
			Timestamp created, Timestamp updated, Boolean showDataByYears, Set<SharedReports> sharedReportses,
			Set<ReportsIntervals> reportsIntervalses) {
		super(uomValuesByOilCostUom, uomValuesBySiteLoadUom, engines, oilType, uomValuesByOilConsumptionUom,
				enginesSpeeds, uomValuesByFuelUom, contacts, currencies, fuels, users, name, inflation, siteLoad,
				dateOfCommissioning, annualOperatingHours, engineCount, usePartsListPriceDiscount,
				partsListPriceDiscount, includeFuel, fuelCost, includeLubrication, oilConsumption, oilCost,
				includeLabor, laborRate, created, updated, showDataByYears, sharedReportses, reportsIntervalses);
	}

}
