package com.kurita.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the meter database table.
 * 
 */
@Entity
@NamedQuery(name="Meter.findAll", query="SELECT m FROM Meter m")
public class Meter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmeter;

	private String name;

	private String network;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="meter", fetch=FetchType.EAGER)
	private Set<Event> events;

	//bi-directional many-to-one association to Measuredvalue
	@OneToMany(mappedBy="meter", fetch=FetchType.EAGER)
	private Set<Measuredvalue> measuredvalues;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="idtype")
	private Type type;

	public Meter() {
	}

	public Meter(String name,String network) {
		this.name=name;
		this.network=network;
	}
	public int getIdmeter() {
		return this.idmeter;
	}

	public void setIdmeter(int idmeter) {
		this.idmeter = idmeter;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNetwork() {
		return this.network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setMeter(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setMeter(null);

		return event;
	}

	public Set<Measuredvalue> getMeasuredvalues() {
		return this.measuredvalues;
	}

	public void setMeasuredvalues(Set<Measuredvalue> measuredvalues) {
		this.measuredvalues = measuredvalues;
	}

	public Measuredvalue addMeasuredvalue(Measuredvalue measuredvalue) {
		getMeasuredvalues().add(measuredvalue);
		measuredvalue.setMeter(this);

		return measuredvalue;
	}

	public Measuredvalue removeMeasuredvalue(Measuredvalue measuredvalue) {
		getMeasuredvalues().remove(measuredvalue);
		measuredvalue.setMeter(null);

		return measuredvalue;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}