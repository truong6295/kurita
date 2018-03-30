package com.kurita.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtype;

	private String aggregation;

	private String type;

	//bi-directional many-to-one association to Meter
	@OneToMany(mappedBy="type", fetch=FetchType.EAGER)
	private Set<Meter> meters;

	//bi-directional many-to-many association to Unit
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="type_has_unit"
		, joinColumns={
			@JoinColumn(name="type_idtype")
			}
		, inverseJoinColumns={
			@JoinColumn(name="unit_idunit")
			}
		)
	private Set<Unit> units;

	public Type() {
	}

	public Type(String aggregation,String type) {
		this.aggregation=aggregation;
		this.type=type;
	}
	public int getIdtype() {
		return this.idtype;
	}

	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}

	public String getAggregation() {
		return this.aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Meter> getMeters() {
		return this.meters;
	}

	public void setMeters(Set<Meter> meters) {
		this.meters = meters;
	}

	public Meter addMeter(Meter meter) {
		getMeters().add(meter);
		meter.setType(this);

		return meter;
	}

	public Meter removeMeter(Meter meter) {
		getMeters().remove(meter);
		meter.setType(null);

		return meter;
	}

	public Set<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(Set<Unit> units) {
		this.units = units;
	}

}