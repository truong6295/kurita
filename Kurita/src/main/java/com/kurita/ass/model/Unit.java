package com.kurita.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idunit;

	private String unit;

	//bi-directional many-to-many association to Type
	@ManyToMany(mappedBy="units", fetch=FetchType.EAGER)
	private Set<Type> types;

	public Unit() {
	}

	public Unit(String unit) {
		this.unit=unit;
	}
	public int getIdunit() {
		return this.idunit;
	}

	public void setIdunit(int idunit) {
		this.idunit = idunit;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Set<Type> getTypes() {
		return this.types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

}