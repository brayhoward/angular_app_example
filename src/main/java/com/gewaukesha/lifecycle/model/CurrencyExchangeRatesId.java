package com.gewaukesha.lifecycle.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CurrencyExchangeRatesId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class CurrencyExchangeRatesId implements java.io.Serializable {

	// Fields

	private String from;
	private String to;

	// Constructors

	/** default constructor */
	public CurrencyExchangeRatesId() {
	}

	/** full constructor */
	public CurrencyExchangeRatesId(String from, String to) {
		this.from = from;
		this.to = to;
	}

	// Property accessors

	@Column(name = "from", nullable = false, length = 3)

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "to", nullable = false, length = 3)

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CurrencyExchangeRatesId))
			return false;
		CurrencyExchangeRatesId castOther = (CurrencyExchangeRatesId) other;

		return ((this.getFrom() == castOther.getFrom()) || (this.getFrom() != null && castOther.getFrom() != null
				&& this.getFrom().equals(castOther.getFrom())))
				&& ((this.getTo() == castOther.getTo()) || (this.getTo() != null && castOther.getTo() != null
						&& this.getTo().equals(castOther.getTo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFrom() == null ? 0 : this.getFrom().hashCode());
		result = 37 * result + (getTo() == null ? 0 : this.getTo().hashCode());
		return result;
	}

}