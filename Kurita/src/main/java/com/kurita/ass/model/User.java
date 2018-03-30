package com.kurita.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;
	private String nameUser;
	private String pass;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<Event> events;

	public User() {
	}
	public User(String pass,String nameuser) {
		this.pass=pass;
		this.nameUser=nameuser;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameuser) {
		this.nameUser = nameuser;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setUser(null);

		return event;
	}

}