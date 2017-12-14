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

import com.gewaukesha.lifecycle.model.UomValues;

/**
 * AbstractUomCategories entity provides the base persistence definition of the
 * UomCategories entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractUomCategories implements java.io.Serializable {

	// Fields

	private String uomCategoriesId;
	private String name;
	private Set<UomValues> uomValueses = new HashSet<UomValues>(0);

	// Constructors

	/** default constructor */
	public AbstractUomCategories() {
	}

	/** minimal constructor */
	public AbstractUomCategories(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractUomCategories(String name, Set<UomValues> uomValueses) {
		this.name = name;
		this.uomValueses = uomValueses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "uom_categories_id", unique = true, nullable = false, length = 40)

	public String getUomCategoriesId() {
		return this.uomCategoriesId;
	}

	public void setUomCategoriesId(String uomCategoriesId) {
		this.uomCategoriesId = uomCategoriesId;
	}

	@Column(name = "name", nullable = false, length = 70)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uomCategories")

	public Set<UomValues> getUomValueses() {
		return this.uomValueses;
	}

	public void setUomValueses(Set<UomValues> uomValueses) {
		this.uomValueses = uomValueses;
	}

}