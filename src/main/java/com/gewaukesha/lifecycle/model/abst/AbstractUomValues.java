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

import com.gewaukesha.lifecycle.model.Reports;
import com.gewaukesha.lifecycle.model.UomCategories;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractUomValues entity provides the base persistence definition of the
 * UomValues entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractUomValues implements java.io.Serializable {

	// Fields

	private String uomValueId;
	private UomCategories uomCategories;
	private String uomDescription;
	private String uomAbbreviation;
	private Boolean baseUom;
	private Float uomMultiplier;
	private Timestamp updated;
	private Set<Reports> reportsesForOilConsumptionUom = new HashSet<Reports>(0);
	private Set<Users> usersesForDefaultUomPowerId = new HashSet<Users>(0);
	private Set<Reports> reportsesForSiteLoadUom = new HashSet<Reports>(0);
	private Set<Users> usersesForDefaultUomVolumeId = new HashSet<Users>(0);
	private Set<Reports> reportsesForOilCostUom = new HashSet<Reports>(0);
	private Set<Users> usersesForDefaultUomEnergyId = new HashSet<Users>(0);
	private Set<Users> usersesForDefaultUomGasId = new HashSet<Users>(0);
	private Set<Reports> reportsesForFuelUom = new HashSet<Reports>(0);
	private Set<Users> usersesForDefaultUomWeightId = new HashSet<Users>(0);

	// Constructors

	/** default constructor */
	public AbstractUomValues() {
	}

	/** minimal constructor */
	public AbstractUomValues(UomCategories uomCategories, String uomDescription, String uomAbbreviation,
			Boolean baseUom, Float uomMultiplier) {
		this.uomCategories = uomCategories;
		this.uomDescription = uomDescription;
		this.uomAbbreviation = uomAbbreviation;
		this.baseUom = baseUom;
		this.uomMultiplier = uomMultiplier;
	}

	/** full constructor */
	public AbstractUomValues(UomCategories uomCategories, String uomDescription, String uomAbbreviation,
			Boolean baseUom, Float uomMultiplier, Timestamp updated, Set<Reports> reportsesForOilConsumptionUom,
			Set<Users> usersesForDefaultUomPowerId, Set<Reports> reportsesForSiteLoadUom,
			Set<Users> usersesForDefaultUomVolumeId, Set<Reports> reportsesForOilCostUom,
			Set<Users> usersesForDefaultUomEnergyId, Set<Users> usersesForDefaultUomGasId,
			Set<Reports> reportsesForFuelUom, Set<Users> usersesForDefaultUomWeightId) {
		this.uomCategories = uomCategories;
		this.uomDescription = uomDescription;
		this.uomAbbreviation = uomAbbreviation;
		this.baseUom = baseUom;
		this.uomMultiplier = uomMultiplier;
		this.updated = updated;
		this.reportsesForOilConsumptionUom = reportsesForOilConsumptionUom;
		this.usersesForDefaultUomPowerId = usersesForDefaultUomPowerId;
		this.reportsesForSiteLoadUom = reportsesForSiteLoadUom;
		this.usersesForDefaultUomVolumeId = usersesForDefaultUomVolumeId;
		this.reportsesForOilCostUom = reportsesForOilCostUom;
		this.usersesForDefaultUomEnergyId = usersesForDefaultUomEnergyId;
		this.usersesForDefaultUomGasId = usersesForDefaultUomGasId;
		this.reportsesForFuelUom = reportsesForFuelUom;
		this.usersesForDefaultUomWeightId = usersesForDefaultUomWeightId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "uom_value_id", unique = true, nullable = false, length = 40)

	public String getUomValueId() {
		return this.uomValueId;
	}

	public void setUomValueId(String uomValueId) {
		this.uomValueId = uomValueId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uom_category_id", nullable = false)

	public UomCategories getUomCategories() {
		return this.uomCategories;
	}

	public void setUomCategories(UomCategories uomCategories) {
		this.uomCategories = uomCategories;
	}

	@Column(name = "uom_description", nullable = false, length = 200)

	public String getUomDescription() {
		return this.uomDescription;
	}

	public void setUomDescription(String uomDescription) {
		this.uomDescription = uomDescription;
	}

	@Column(name = "uom_abbreviation", nullable = false, length = 60)

	public String getUomAbbreviation() {
		return this.uomAbbreviation;
	}

	public void setUomAbbreviation(String uomAbbreviation) {
		this.uomAbbreviation = uomAbbreviation;
	}

	@Column(name = "base_uom", nullable = false)

	public Boolean getBaseUom() {
		return this.baseUom;
	}

	public void setBaseUom(Boolean baseUom) {
		this.baseUom = baseUom;
	}

	@Column(name = "uom_multiplier", nullable = false, precision = 12, scale = 0)

	public Float getUomMultiplier() {
		return this.uomMultiplier;
	}

	public void setUomMultiplier(Float uomMultiplier) {
		this.uomMultiplier = uomMultiplier;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByOilConsumptionUom")

	public Set<Reports> getReportsesForOilConsumptionUom() {
		return this.reportsesForOilConsumptionUom;
	}

	public void setReportsesForOilConsumptionUom(Set<Reports> reportsesForOilConsumptionUom) {
		this.reportsesForOilConsumptionUom = reportsesForOilConsumptionUom;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByDefaultUomPowerId")

	public Set<Users> getUsersesForDefaultUomPowerId() {
		return this.usersesForDefaultUomPowerId;
	}

	public void setUsersesForDefaultUomPowerId(Set<Users> usersesForDefaultUomPowerId) {
		this.usersesForDefaultUomPowerId = usersesForDefaultUomPowerId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesBySiteLoadUom")

	public Set<Reports> getReportsesForSiteLoadUom() {
		return this.reportsesForSiteLoadUom;
	}

	public void setReportsesForSiteLoadUom(Set<Reports> reportsesForSiteLoadUom) {
		this.reportsesForSiteLoadUom = reportsesForSiteLoadUom;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByDefaultUomVolumeId")

	public Set<Users> getUsersesForDefaultUomVolumeId() {
		return this.usersesForDefaultUomVolumeId;
	}

	public void setUsersesForDefaultUomVolumeId(Set<Users> usersesForDefaultUomVolumeId) {
		this.usersesForDefaultUomVolumeId = usersesForDefaultUomVolumeId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByOilCostUom")

	public Set<Reports> getReportsesForOilCostUom() {
		return this.reportsesForOilCostUom;
	}

	public void setReportsesForOilCostUom(Set<Reports> reportsesForOilCostUom) {
		this.reportsesForOilCostUom = reportsesForOilCostUom;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByDefaultUomEnergyId")

	public Set<Users> getUsersesForDefaultUomEnergyId() {
		return this.usersesForDefaultUomEnergyId;
	}

	public void setUsersesForDefaultUomEnergyId(Set<Users> usersesForDefaultUomEnergyId) {
		this.usersesForDefaultUomEnergyId = usersesForDefaultUomEnergyId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByDefaultUomGasId")

	public Set<Users> getUsersesForDefaultUomGasId() {
		return this.usersesForDefaultUomGasId;
	}

	public void setUsersesForDefaultUomGasId(Set<Users> usersesForDefaultUomGasId) {
		this.usersesForDefaultUomGasId = usersesForDefaultUomGasId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByFuelUom")

	public Set<Reports> getReportsesForFuelUom() {
		return this.reportsesForFuelUom;
	}

	public void setReportsesForFuelUom(Set<Reports> reportsesForFuelUom) {
		this.reportsesForFuelUom = reportsesForFuelUom;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomValuesByDefaultUomWeightId")

	public Set<Users> getUsersesForDefaultUomWeightId() {
		return this.usersesForDefaultUomWeightId;
	}

	public void setUsersesForDefaultUomWeightId(Set<Users> usersesForDefaultUomWeightId) {
		this.usersesForDefaultUomWeightId = usersesForDefaultUomWeightId;
	}

}