package com.gewaukesha.lifecycle.model.abst;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractUsersSettings entity provides the base persistence definition of the
 * UsersSettings entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractUsersSettings implements java.io.Serializable {

	// Fields

	private String userSettingsId;
	private Users users;
	private String settingKey;
	private String settingValue;

	// Constructors

	/** default constructor */
	public AbstractUsersSettings() {
	}

	/** minimal constructor */
	public AbstractUsersSettings(Users users, String settingKey) {
		this.users = users;
		this.settingKey = settingKey;
	}

	/** full constructor */
	public AbstractUsersSettings(Users users, String settingKey, String settingValue) {
		this.users = users;
		this.settingKey = settingKey;
		this.settingValue = settingValue;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "user_settings_id", unique = true, nullable = false, length = 40)

	public String getUserSettingsId() {
		return this.userSettingsId;
	}

	public void setUserSettingsId(String userSettingsId) {
		this.userSettingsId = userSettingsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "setting_key", nullable = false, length = 50)

	public String getSettingKey() {
		return this.settingKey;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	@Column(name = "setting_value", length = 500)

	public String getSettingValue() {
		return this.settingValue;
	}

	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}

}