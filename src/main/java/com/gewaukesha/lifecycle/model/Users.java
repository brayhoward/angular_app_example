package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractUsers;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "gepw_lifecycle_tool")
public class Users extends AbstractUsers implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Roles roles, String gesso) {
		super(roles, gesso);
	}

	/** full constructor */
	public Users(Roles roles, UomValues uomValuesByDefaultUomVolumeId, UomValues uomValuesByDefaultUomEnergyId,
			UomValues uomValuesByDefaultUomGasId, UomValues uomValuesByDefaultUomWeightId,
			UomValues uomValuesByDefaultUomPowerId, Currencies currencies, String name, String gesso, Boolean active,
			Timestamp created, Timestamp updated, Timestamp lastLogin, Set<Parts> partses, Set<Contacts> contactses,
			Set<UsersSettings> usersSettingses, Set<Companies> companieses, Set<SharedReports> sharedReportses,
			Set<Reports> reportses) {
		super(roles, uomValuesByDefaultUomVolumeId, uomValuesByDefaultUomEnergyId, uomValuesByDefaultUomGasId,
				uomValuesByDefaultUomWeightId, uomValuesByDefaultUomPowerId, currencies, name, gesso, active, created,
				updated, lastLogin, partses, contactses, usersSettingses, companieses, sharedReportses, reportses);
	}

}
