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

import com.gewaukesha.lifecycle.model.Contacts;
import com.gewaukesha.lifecycle.model.Currencies;
import com.gewaukesha.lifecycle.model.Engines;
import com.gewaukesha.lifecycle.model.EnginesSpeeds;
import com.gewaukesha.lifecycle.model.Fuels;
import com.gewaukesha.lifecycle.model.OilType;
import com.gewaukesha.lifecycle.model.ReportsIntervals;
import com.gewaukesha.lifecycle.model.SharedReports;
import com.gewaukesha.lifecycle.model.UomValues;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractReports entity provides the base persistence definition of the
 * Reports entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractReports implements java.io.Serializable {

	// Fields

	private String reportId;
	private UomValues uomValuesByOilCostUom;
	private UomValues uomValuesBySiteLoadUom;
	private Engines engines;
	private OilType oilType;
	private UomValues uomValuesByOilConsumptionUom;
	private EnginesSpeeds enginesSpeeds;
	private UomValues uomValuesByFuelUom;
	private Contacts contacts;
	private Currencies currencies;
	private Fuels fuels;
	private Users users;
	private String name;
	private Short inflation;
	private Short siteLoad;
	private Timestamp dateOfCommissioning;
	private Short annualOperatingHours;
	private Short engineCount;
	private Boolean usePartsListPriceDiscount;
	private Short partsListPriceDiscount;
	private Boolean includeFuel;
	private Float fuelCost;
	private Boolean includeLubrication;
	private Float oilConsumption;
	private Float oilCost;
	private Boolean includeLabor;
	private Float laborRate;
	private Timestamp created;
	private Timestamp updated;
	private Boolean showDataByYears;
	private Set<SharedReports> sharedReportses = new HashSet<SharedReports>(0);
	private Set<ReportsIntervals> reportsIntervalses = new HashSet<ReportsIntervals>(0);

	// Constructors

	/** default constructor */
	public AbstractReports() {
	}

	/** minimal constructor */
	public AbstractReports(Engines engines, OilType oilType, Contacts contacts, Currencies currencies, Fuels fuels,
			Users users, String name, Short partsListPriceDiscount) {
		this.engines = engines;
		this.oilType = oilType;
		this.contacts = contacts;
		this.currencies = currencies;
		this.fuels = fuels;
		this.users = users;
		this.name = name;
		this.partsListPriceDiscount = partsListPriceDiscount;
	}

	/** full constructor */
	public AbstractReports(UomValues uomValuesByOilCostUom, UomValues uomValuesBySiteLoadUom, Engines engines,
			OilType oilType, UomValues uomValuesByOilConsumptionUom, EnginesSpeeds enginesSpeeds,
			UomValues uomValuesByFuelUom, Contacts contacts, Currencies currencies, Fuels fuels, Users users,
			String name, Short inflation, Short siteLoad, Timestamp dateOfCommissioning, Short annualOperatingHours,
			Short engineCount, Boolean usePartsListPriceDiscount, Short partsListPriceDiscount, Boolean includeFuel,
			Float fuelCost, Boolean includeLubrication, Float oilConsumption, Float oilCost, Boolean includeLabor,
			Float laborRate, Timestamp created, Timestamp updated, Boolean showDataByYears,
			Set<SharedReports> sharedReportses, Set<ReportsIntervals> reportsIntervalses) {
		this.uomValuesByOilCostUom = uomValuesByOilCostUom;
		this.uomValuesBySiteLoadUom = uomValuesBySiteLoadUom;
		this.engines = engines;
		this.oilType = oilType;
		this.uomValuesByOilConsumptionUom = uomValuesByOilConsumptionUom;
		this.enginesSpeeds = enginesSpeeds;
		this.uomValuesByFuelUom = uomValuesByFuelUom;
		this.contacts = contacts;
		this.currencies = currencies;
		this.fuels = fuels;
		this.users = users;
		this.name = name;
		this.inflation = inflation;
		this.siteLoad = siteLoad;
		this.dateOfCommissioning = dateOfCommissioning;
		this.annualOperatingHours = annualOperatingHours;
		this.engineCount = engineCount;
		this.usePartsListPriceDiscount = usePartsListPriceDiscount;
		this.partsListPriceDiscount = partsListPriceDiscount;
		this.includeFuel = includeFuel;
		this.fuelCost = fuelCost;
		this.includeLubrication = includeLubrication;
		this.oilConsumption = oilConsumption;
		this.oilCost = oilCost;
		this.includeLabor = includeLabor;
		this.laborRate = laborRate;
		this.created = created;
		this.updated = updated;
		this.showDataByYears = showDataByYears;
		this.sharedReportses = sharedReportses;
		this.reportsIntervalses = reportsIntervalses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "report_id", unique = true, nullable = false, length = 40)

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oil_cost_uom")

	public UomValues getUomValuesByOilCostUom() {
		return this.uomValuesByOilCostUom;
	}

	public void setUomValuesByOilCostUom(UomValues uomValuesByOilCostUom) {
		this.uomValuesByOilCostUom = uomValuesByOilCostUom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_load_uom")

	public UomValues getUomValuesBySiteLoadUom() {
		return this.uomValuesBySiteLoadUom;
	}

	public void setUomValuesBySiteLoadUom(UomValues uomValuesBySiteLoadUom) {
		this.uomValuesBySiteLoadUom = uomValuesBySiteLoadUom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "engine_id", nullable = false)

	public Engines getEngines() {
		return this.engines;
	}

	public void setEngines(Engines engines) {
		this.engines = engines;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oil_type_id", nullable = false)

	public OilType getOilType() {
		return this.oilType;
	}

	public void setOilType(OilType oilType) {
		this.oilType = oilType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oil_consumption_uom")

	public UomValues getUomValuesByOilConsumptionUom() {
		return this.uomValuesByOilConsumptionUom;
	}

	public void setUomValuesByOilConsumptionUom(UomValues uomValuesByOilConsumptionUom) {
		this.uomValuesByOilConsumptionUom = uomValuesByOilConsumptionUom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "engine_speed_id")

	public EnginesSpeeds getEnginesSpeeds() {
		return this.enginesSpeeds;
	}

	public void setEnginesSpeeds(EnginesSpeeds enginesSpeeds) {
		this.enginesSpeeds = enginesSpeeds;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fuel_uom")

	public UomValues getUomValuesByFuelUom() {
		return this.uomValuesByFuelUom;
	}

	public void setUomValuesByFuelUom(UomValues uomValuesByFuelUom) {
		this.uomValuesByFuelUom = uomValuesByFuelUom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id", nullable = false)

	public Contacts getContacts() {
		return this.contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id", nullable = false)

	public Currencies getCurrencies() {
		return this.currencies;
	}

	public void setCurrencies(Currencies currencies) {
		this.currencies = currencies;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fuel_id", nullable = false)

	public Fuels getFuels() {
		return this.fuels;
	}

	public void setFuels(Fuels fuels) {
		this.fuels = fuels;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_user_id", nullable = false)

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "name", nullable = false, length = 60)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "inflation")

	public Short getInflation() {
		return this.inflation;
	}

	public void setInflation(Short inflation) {
		this.inflation = inflation;
	}

	@Column(name = "site_load")

	public Short getSiteLoad() {
		return this.siteLoad;
	}

	public void setSiteLoad(Short siteLoad) {
		this.siteLoad = siteLoad;
	}

	@Column(name = "date_of_commissioning", length = 19)

	public Timestamp getDateOfCommissioning() {
		return this.dateOfCommissioning;
	}

	public void setDateOfCommissioning(Timestamp dateOfCommissioning) {
		this.dateOfCommissioning = dateOfCommissioning;
	}

	@Column(name = "annual_operating_hours")

	public Short getAnnualOperatingHours() {
		return this.annualOperatingHours;
	}

	public void setAnnualOperatingHours(Short annualOperatingHours) {
		this.annualOperatingHours = annualOperatingHours;
	}

	@Column(name = "engine_count")

	public Short getEngineCount() {
		return this.engineCount;
	}

	public void setEngineCount(Short engineCount) {
		this.engineCount = engineCount;
	}

	@Column(name = "use_parts_list_price_discount")

	public Boolean getUsePartsListPriceDiscount() {
		return this.usePartsListPriceDiscount;
	}

	public void setUsePartsListPriceDiscount(Boolean usePartsListPriceDiscount) {
		this.usePartsListPriceDiscount = usePartsListPriceDiscount;
	}

	@Column(name = "parts_list_price_discount", nullable = false)

	public Short getPartsListPriceDiscount() {
		return this.partsListPriceDiscount;
	}

	public void setPartsListPriceDiscount(Short partsListPriceDiscount) {
		this.partsListPriceDiscount = partsListPriceDiscount;
	}

	@Column(name = "include_fuel")

	public Boolean getIncludeFuel() {
		return this.includeFuel;
	}

	public void setIncludeFuel(Boolean includeFuel) {
		this.includeFuel = includeFuel;
	}

	@Column(name = "fuel_cost", precision = 12, scale = 0)

	public Float getFuelCost() {
		return this.fuelCost;
	}

	public void setFuelCost(Float fuelCost) {
		this.fuelCost = fuelCost;
	}

	@Column(name = "include_lubrication")

	public Boolean getIncludeLubrication() {
		return this.includeLubrication;
	}

	public void setIncludeLubrication(Boolean includeLubrication) {
		this.includeLubrication = includeLubrication;
	}

	@Column(name = "oil_consumption", precision = 12, scale = 0)

	public Float getOilConsumption() {
		return this.oilConsumption;
	}

	public void setOilConsumption(Float oilConsumption) {
		this.oilConsumption = oilConsumption;
	}

	@Column(name = "oil_cost", precision = 12, scale = 0)

	public Float getOilCost() {
		return this.oilCost;
	}

	public void setOilCost(Float oilCost) {
		this.oilCost = oilCost;
	}

	@Column(name = "include_labor")

	public Boolean getIncludeLabor() {
		return this.includeLabor;
	}

	public void setIncludeLabor(Boolean includeLabor) {
		this.includeLabor = includeLabor;
	}

	@Column(name = "labor_rate", precision = 12, scale = 0)

	public Float getLaborRate() {
		return this.laborRate;
	}

	public void setLaborRate(Float laborRate) {
		this.laborRate = laborRate;
	}

	@Column(name = "created", length = 19)

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@Column(name = "show_data_by_years")

	public Boolean getShowDataByYears() {
		return this.showDataByYears;
	}

	public void setShowDataByYears(Boolean showDataByYears) {
		this.showDataByYears = showDataByYears;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reports")

	public Set<SharedReports> getSharedReportses() {
		return this.sharedReportses;
	}

	public void setSharedReportses(Set<SharedReports> sharedReportses) {
		this.sharedReportses = sharedReportses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reports")

	public Set<ReportsIntervals> getReportsIntervalses() {
		return this.reportsIntervalses;
	}

	public void setReportsIntervalses(Set<ReportsIntervals> reportsIntervalses) {
		this.reportsIntervalses = reportsIntervalses;
	}

}