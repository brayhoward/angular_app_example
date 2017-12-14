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

import com.gewaukesha.lifecycle.model.Companies;
import com.gewaukesha.lifecycle.model.Contacts;
import com.gewaukesha.lifecycle.model.Currencies;
import com.gewaukesha.lifecycle.model.Parts;
import com.gewaukesha.lifecycle.model.Reports;
import com.gewaukesha.lifecycle.model.Roles;
import com.gewaukesha.lifecycle.model.SharedReports;
import com.gewaukesha.lifecycle.model.UomValues;
import com.gewaukesha.lifecycle.model.UsersSettings;

/**
 * AbstractUsers entity provides the base persistence definition of the Users
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractUsers implements java.io.Serializable {

	// Fields

	private String userId;
	private Roles roles;
	private UomValues uomValuesByDefaultUomVolumeId;
	private UomValues uomValuesByDefaultUomEnergyId;
	private UomValues uomValuesByDefaultUomGasId;
	private UomValues uomValuesByDefaultUomWeightId;
	private UomValues uomValuesByDefaultUomPowerId;
	private Currencies currencies;
	private String name;
	private String gesso;
	private Boolean active;
	private Timestamp created;
	private Timestamp updated;
	private Timestamp lastLogin;
	private Set<Parts> partses = new HashSet<Parts>(0);
	private Set<Contacts> contactses = new HashSet<Contacts>(0);
	private Set<UsersSettings> usersSettingses = new HashSet<UsersSettings>(0);
	private Set<Companies> companieses = new HashSet<Companies>(0);
	private Set<SharedReports> sharedReportses = new HashSet<SharedReports>(0);
	private Set<Reports> reportses = new HashSet<Reports>(0);

	// Constructors

	/** default constructor */
	public AbstractUsers() {
	}

	/** minimal constructor */
	public AbstractUsers(Roles roles, String gesso) {
		this.roles = roles;
		this.gesso = gesso;
	}

	/** full constructor */
	public AbstractUsers(Roles roles, UomValues uomValuesByDefaultUomVolumeId, UomValues uomValuesByDefaultUomEnergyId,
			UomValues uomValuesByDefaultUomGasId, UomValues uomValuesByDefaultUomWeightId,
			UomValues uomValuesByDefaultUomPowerId, Currencies currencies, String name, String gesso, Boolean active,
			Timestamp created, Timestamp updated, Timestamp lastLogin, Set<Parts> partses, Set<Contacts> contactses,
			Set<UsersSettings> usersSettingses, Set<Companies> companieses, Set<SharedReports> sharedReportses,
			Set<Reports> reportses) {
		this.roles = roles;
		this.uomValuesByDefaultUomVolumeId = uomValuesByDefaultUomVolumeId;
		this.uomValuesByDefaultUomEnergyId = uomValuesByDefaultUomEnergyId;
		this.uomValuesByDefaultUomGasId = uomValuesByDefaultUomGasId;
		this.uomValuesByDefaultUomWeightId = uomValuesByDefaultUomWeightId;
		this.uomValuesByDefaultUomPowerId = uomValuesByDefaultUomPowerId;
		this.currencies = currencies;
		this.name = name;
		this.gesso = gesso;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.lastLogin = lastLogin;
		this.partses = partses;
		this.contactses = contactses;
		this.usersSettingses = usersSettingses;
		this.companieses = companieses;
		this.sharedReportses = sharedReportses;
		this.reportses = reportses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "user_id", unique = true, nullable = false, length = 40)

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_uom_volume_id")

	public UomValues getUomValuesByDefaultUomVolumeId() {
		return this.uomValuesByDefaultUomVolumeId;
	}

	public void setUomValuesByDefaultUomVolumeId(UomValues uomValuesByDefaultUomVolumeId) {
		this.uomValuesByDefaultUomVolumeId = uomValuesByDefaultUomVolumeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_uom_energy_id")

	public UomValues getUomValuesByDefaultUomEnergyId() {
		return this.uomValuesByDefaultUomEnergyId;
	}

	public void setUomValuesByDefaultUomEnergyId(UomValues uomValuesByDefaultUomEnergyId) {
		this.uomValuesByDefaultUomEnergyId = uomValuesByDefaultUomEnergyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_uom_gas_id")

	public UomValues getUomValuesByDefaultUomGasId() {
		return this.uomValuesByDefaultUomGasId;
	}

	public void setUomValuesByDefaultUomGasId(UomValues uomValuesByDefaultUomGasId) {
		this.uomValuesByDefaultUomGasId = uomValuesByDefaultUomGasId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_uom_weight_id")

	public UomValues getUomValuesByDefaultUomWeightId() {
		return this.uomValuesByDefaultUomWeightId;
	}

	public void setUomValuesByDefaultUomWeightId(UomValues uomValuesByDefaultUomWeightId) {
		this.uomValuesByDefaultUomWeightId = uomValuesByDefaultUomWeightId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_uom_power_id")

	public UomValues getUomValuesByDefaultUomPowerId() {
		return this.uomValuesByDefaultUomPowerId;
	}

	public void setUomValuesByDefaultUomPowerId(UomValues uomValuesByDefaultUomPowerId) {
		this.uomValuesByDefaultUomPowerId = uomValuesByDefaultUomPowerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id")

	public Currencies getCurrencies() {
		return this.currencies;
	}

	public void setCurrencies(Currencies currencies) {
		this.currencies = currencies;
	}

	@Column(name = "name", length = 80)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gesso", nullable = false, length = 100)

	public String getGesso() {
		return this.gesso;
	}

	public void setGesso(String gesso) {
		this.gesso = gesso;
	}

	@Column(name = "active")

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	@Column(name = "last_login", length = 19)

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<Parts> getPartses() {
		return this.partses;
	}

	public void setPartses(Set<Parts> partses) {
		this.partses = partses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<Contacts> getContactses() {
		return this.contactses;
	}

	public void setContactses(Set<Contacts> contactses) {
		this.contactses = contactses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<UsersSettings> getUsersSettingses() {
		return this.usersSettingses;
	}

	public void setUsersSettingses(Set<UsersSettings> usersSettingses) {
		this.usersSettingses = usersSettingses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<Companies> getCompanieses() {
		return this.companieses;
	}

	public void setCompanieses(Set<Companies> companieses) {
		this.companieses = companieses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<SharedReports> getSharedReportses() {
		return this.sharedReportses;
	}

	public void setSharedReportses(Set<SharedReports> sharedReportses) {
		this.sharedReportses = sharedReportses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

}