package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractUomValues;

/**
 * UomValues entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uom_values", catalog = "gepw_lifecycle_tool")
public class UomValues extends AbstractUomValues implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UomValues() {
	}

	/** minimal constructor */
	public UomValues(UomCategories uomCategories, String uomDescription, String uomAbbreviation, Boolean baseUom,
			Float uomMultiplier) {
		super(uomCategories, uomDescription, uomAbbreviation, baseUom, uomMultiplier);
	}

	/** full constructor */
	public UomValues(UomCategories uomCategories, String uomDescription, String uomAbbreviation, Boolean baseUom,
			Float uomMultiplier, Timestamp updated, Set<Reports> reportsesForOilConsumptionUom,
			Set<Users> usersesForDefaultUomPowerId, Set<Reports> reportsesForSiteLoadUom,
			Set<Users> usersesForDefaultUomVolumeId, Set<Reports> reportsesForOilCostUom,
			Set<Users> usersesForDefaultUomEnergyId, Set<Users> usersesForDefaultUomGasId,
			Set<Reports> reportsesForFuelUom, Set<Users> usersesForDefaultUomWeightId) {
		super(uomCategories, uomDescription, uomAbbreviation, baseUom, uomMultiplier, updated,
				reportsesForOilConsumptionUom, usersesForDefaultUomPowerId, reportsesForSiteLoadUom,
				usersesForDefaultUomVolumeId, reportsesForOilCostUom, usersesForDefaultUomEnergyId,
				usersesForDefaultUomGasId, reportsesForFuelUom, usersesForDefaultUomWeightId);
	}

}
