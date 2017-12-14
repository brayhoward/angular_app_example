package com.gewaukesha.lifecycle.model.abst;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

import com.gewaukesha.lifecycle.model.CurrencyExchangeRatesId;

/**
 * AbstractCurrencyExchangeRates entity provides the base persistence definition
 * of the CurrencyExchangeRates entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractCurrencyExchangeRates implements java.io.Serializable {

	// Fields

	private CurrencyExchangeRatesId id;
	private Float rate;
	private Timestamp rateAsOf;
	private Timestamp updated;

	// Constructors

	/** default constructor */
	public AbstractCurrencyExchangeRates() {
	}

	/** minimal constructor */
	public AbstractCurrencyExchangeRates(CurrencyExchangeRatesId id, Float rate, Timestamp rateAsOf) {
		this.id = id;
		this.rate = rate;
		this.rateAsOf = rateAsOf;
	}

	/** full constructor */
	public AbstractCurrencyExchangeRates(CurrencyExchangeRatesId id, Float rate, Timestamp rateAsOf,
			Timestamp updated) {
		this.id = id;
		this.rate = rate;
		this.rateAsOf = rateAsOf;
		this.updated = updated;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "from", column = @Column(name = "from", nullable = false, length = 3)),
			@AttributeOverride(name = "to", column = @Column(name = "to", nullable = false, length = 3)) })

	public CurrencyExchangeRatesId getId() {
		return this.id;
	}

	public void setId(CurrencyExchangeRatesId id) {
		this.id = id;
	}

	@Column(name = "rate", nullable = false, precision = 12, scale = 0)

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	@Column(name = "rate_as_of", nullable = false, length = 19)

	public Timestamp getRateAsOf() {
		return this.rateAsOf;
	}

	public void setRateAsOf(Timestamp rateAsOf) {
		this.rateAsOf = rateAsOf;
	}

	@Column(name = "updated", length = 19)

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

}