package com.gewaukesha.lifecycle.model.abst;

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

import com.gewaukesha.lifecycle.model.Parts;
import com.gewaukesha.lifecycle.model.Reports;
import com.gewaukesha.lifecycle.model.Users;

/**
 * AbstractCurrencies entity provides the base persistence definition of the
 * Currencies entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractCurrencies implements java.io.Serializable {

	// Fields

	private String currencyId;
	private String fullName;
	private String shortName;
	private String symbol;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Reports> reportses = new HashSet<Reports>(0);
	private Set<Parts> partses = new HashSet<Parts>(0);

	// Constructors

	/** default constructor */
	public AbstractCurrencies() {
	}

	/** minimal constructor */
	public AbstractCurrencies(String fullName, String shortName, String symbol) {
		this.fullName = fullName;
		this.shortName = shortName;
		this.symbol = symbol;
	}

	/** full constructor */
	public AbstractCurrencies(String fullName, String shortName, String symbol, Set<Users> userses,
			Set<Reports> reportses, Set<Parts> partses) {
		this.fullName = fullName;
		this.shortName = shortName;
		this.symbol = symbol;
		this.userses = userses;
		this.reportses = reportses;
		this.partses = partses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "currency_id", unique = true, nullable = false, length = 40)

	public String getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	@Column(name = "full_name", nullable = false, length = 100)

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "short_name", nullable = false, length = 3)

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "symbol", nullable = false, length = 1)

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "currencies")

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "currencies")

	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "currencies")

	public Set<Parts> getPartses() {
		return this.partses;
	}

	public void setPartses(Set<Parts> partses) {
		this.partses = partses;
	}

}