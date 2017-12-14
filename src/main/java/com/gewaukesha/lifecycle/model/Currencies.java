package com.gewaukesha.lifecycle.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gewaukesha.lifecycle.model.abst.AbstractCurrencies;

/**
 * Currencies entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "currencies", catalog = "gepw_lifecycle_tool")
public class Currencies extends AbstractCurrencies implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Currencies() {
	}

	/** minimal constructor */
	public Currencies(String fullName, String shortName, String symbol) {
		super(fullName, shortName, symbol);
	}

	/** full constructor */
	public Currencies(String fullName, String shortName, String symbol, Set<Users> userses, Set<Reports> reportses,
			Set<Parts> partses) {
		super(fullName, shortName, symbol, userses, reportses, partses);
	}

}
