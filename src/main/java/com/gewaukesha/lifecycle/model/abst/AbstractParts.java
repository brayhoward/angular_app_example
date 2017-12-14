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

import com.gewaukesha.lifecycle.model.Currencies;
import com.gewaukesha.lifecycle.model.IntervalsParts;
import com.gewaukesha.lifecycle.model.PartsCategories;
import com.gewaukesha.lifecycle.model.PartsType;
import com.gewaukesha.lifecycle.model.ReportsIntervalsParts;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractParts entity provides the base persistence definition of the Parts
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractParts implements java.io.Serializable {

	// Fields

	private String partId;
	private PartsType partsType;
	private Users users;
	private PartsCategories partsCategories;
	private Currencies currencies;
	private String partNumber;
	private String description;
	private Float listPrice;
	private Timestamp created;
	private Timestamp updated;
	private Set<ReportsIntervalsParts> reportsIntervalsPartses = new HashSet<ReportsIntervalsParts>(0);
	private Set<IntervalsParts> intervalsPartses = new HashSet<IntervalsParts>(0);

	// Constructors

	/** default constructor */
	public AbstractParts() {
	}

	/** minimal constructor */
	public AbstractParts(PartsType partsType, PartsCategories partsCategories, String partNumber, Float listPrice) {
		this.partsType = partsType;
		this.partsCategories = partsCategories;
		this.partNumber = partNumber;
		this.listPrice = listPrice;
	}

	/** full constructor */
	public AbstractParts(PartsType partsType, Users users, PartsCategories partsCategories, Currencies currencies,
			String partNumber, String description, Float listPrice, Timestamp created, Timestamp updated,
			Set<ReportsIntervalsParts> reportsIntervalsPartses, Set<IntervalsParts> intervalsPartses) {
		this.partsType = partsType;
		this.users = users;
		this.partsCategories = partsCategories;
		this.currencies = currencies;
		this.partNumber = partNumber;
		this.description = description;
		this.listPrice = listPrice;
		this.created = created;
		this.updated = updated;
		this.reportsIntervalsPartses = reportsIntervalsPartses;
		this.intervalsPartses = intervalsPartses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "part_id", unique = true, nullable = false, length = 40)

	public String getPartId() {
		return this.partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_type_id", nullable = false)

	public PartsType getPartsType() {
		return this.partsType;
	}

	public void setPartsType(PartsType partsType) {
		this.partsType = partsType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_category_id", nullable = false)

	public PartsCategories getPartsCategories() {
		return this.partsCategories;
	}

	public void setPartsCategories(PartsCategories partsCategories) {
		this.partsCategories = partsCategories;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id")

	public Currencies getCurrencies() {
		return this.currencies;
	}

	public void setCurrencies(Currencies currencies) {
		this.currencies = currencies;
	}

	@Column(name = "part_number", nullable = false, length = 40)

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	@Column(name = "description", length = 200)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "list_price", nullable = false, precision = 12, scale = 0)

	public Float getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(Float listPrice) {
		this.listPrice = listPrice;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parts")

	public Set<ReportsIntervalsParts> getReportsIntervalsPartses() {
		return this.reportsIntervalsPartses;
	}

	public void setReportsIntervalsPartses(Set<ReportsIntervalsParts> reportsIntervalsPartses) {
		this.reportsIntervalsPartses = reportsIntervalsPartses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parts")

	public Set<IntervalsParts> getIntervalsPartses() {
		return this.intervalsPartses;
	}

	public void setIntervalsPartses(Set<IntervalsParts> intervalsPartses) {
		this.intervalsPartses = intervalsPartses;
	}

}