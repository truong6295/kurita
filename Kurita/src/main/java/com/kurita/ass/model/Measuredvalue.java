package com.kurita.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the measuredvalue database table.
 * 
 */
@Entity
@NamedQuery(name="Measuredvalue.findAll", query="SELECT m FROM Measuredvalue m")
public class Measuredvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvalue;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private int value;

	private int valuetype;

	//bi-directional many-to-one association to Meter
	@ManyToOne
	@JoinColumn(name="idmeter")
	private Meter meter;

	public Measuredvalue() {
	}

	public Measuredvalue(Date datetime,int value,int valuetype) {
		this.datetime=datetime;
		this.value=value;
		this.valuetype=valuetype;
	}
	public int getIdvalue() {
		return this.idvalue;
	}

	public void setIdvalue(int idvalue) {
		this.idvalue = idvalue;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValuetype() {
		return this.valuetype;
	}

	public void setValuetype(int valuetype) {
		this.valuetype = valuetype;
	}

	public Meter getMeter() {
		return this.meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

}