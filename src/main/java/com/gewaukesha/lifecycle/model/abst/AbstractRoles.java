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

import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractRoles entity provides the base persistence definition of the Roles
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractRoles implements java.io.Serializable {

	// Fields

	private String roleId;
	private String name;
	private Boolean canAdmin;
	private Boolean canViewAllParts;
	private Boolean canViewAllReports;
	private Boolean canEditReport;
	private Timestamp updated;
	private Set<Users> userses = new HashSet<Users>(0);

	// Constructors

	/** default constructor */
	public AbstractRoles() {
	}

	/** minimal constructor */
	public AbstractRoles(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractRoles(String name, Boolean canAdmin, Boolean canViewAllParts, Boolean canViewAllReports,
			Boolean canEditReport, Timestamp updated, Set<Users> userses) {
		this.name = name;
		this.canAdmin = canAdmin;
		this.canViewAllParts = canViewAllParts;
		this.canViewAllReports = canViewAllReports;
		this.canEditReport = canEditReport;
		this.updated = updated;
		this.userses = userses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "role_id", unique = true, nullable = false, length = 40)

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "name", nullable = false, length = 80)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "can_admin")

	public Boolean getCanAdmin() {
		return this.canAdmin;
	}

	public void setCanAdmin(Boolean canAdmin) {
		this.canAdmin = canAdmin;
	}

	@Column(name = "can_view_all_parts")

	public Boolean getCanViewAllParts() {
		return this.canViewAllParts;
	}

	public void setCanViewAllParts(Boolean canViewAllParts) {
		this.canViewAllParts = canViewAllParts;
	}

	@Column(name = "can_view_all_reports")

	public Boolean getCanViewAllReports() {
		return this.canViewAllReports;
	}

	public void setCanViewAllReports(Boolean canViewAllReports) {
		this.canViewAllReports = canViewAllReports;
	}

	@Column(name = "can_edit_report")

	public Boolean getCanEditReport() {
		return this.canEditReport;
	}

	public void setCanEditReport(Boolean canEditReport) {
		this.canEditReport = canEditReport;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}