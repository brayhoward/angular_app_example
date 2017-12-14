package com.gewaukesha.lifecycle.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractUsersSettings;

/**
 * UsersSettings entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users_settings", catalog = "gepw_lifecycle_tool")
public class UsersSettings extends AbstractUsersSettings implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UsersSettings() {
	}

	/** minimal constructor */
	public UsersSettings(Users users, String settingKey) {
		super(users, settingKey);
	}

	/** full constructor */
	public UsersSettings(Users users, String settingKey, String settingValue) {
		super(users, settingKey, settingValue);
	}

}
