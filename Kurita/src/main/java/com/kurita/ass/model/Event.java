package com.kurita.ass.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idevent;

	private String description;

	private String relaterobject;

	//bi-directional many-to-one association to Meter
	@ManyToOne
	@JoinColumn(name="idmeter")
	private Meter meter;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	public Event() {
	}
	public Event(String description,String relaterobject) {
		this.description=description;
		this.relaterobject=relaterobject;
	}
	

	public int getIdevent() {
		return this.idevent;
	}

	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelaterobject() {
		return this.relaterobject;
	}

	public void setRelaterobject(String relaterobject) {
		this.relaterobject = relaterobject;
	}

	public Meter getMeter() {
		return this.meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}