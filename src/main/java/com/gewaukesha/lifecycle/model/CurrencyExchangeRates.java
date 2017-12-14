package com.gewaukesha.lifecycle.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractCurrencyExchangeRates;

/**
 * CurrencyExchangeRates entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "currency_exchange_rates", catalog = "gepw_lifecycle_tool")
public class CurrencyExchangeRates extends AbstractCurrencyExchangeRates implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CurrencyExchangeRates() {
	}

	/** minimal constructor */
	public CurrencyExchangeRates(CurrencyExchangeRatesId id, Float rate, Timestamp rateAsOf) {
		super(id, rate, rateAsOf);
	}

	/** full constructor */
	public CurrencyExchangeRates(CurrencyExchangeRatesId id, Float rate, Timestamp rateAsOf, Timestamp updated) {
		super(id, rate, rateAsOf, updated);
	}

}
