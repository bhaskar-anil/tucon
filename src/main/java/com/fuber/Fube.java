package com.fuber;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This class represents an entity, which is an integral part of Fuber - lets call it Fube
 * 
 * Users/Customer
 * Cabs
 * 
 * It will an identity - phone number for customer/ plate number for cab
 * A location - Geo location of the entity
 * A type - CarType
 * 
 * */

@Entity
@Table(name="FUBE")
public class Fube {
	
	@Id
	@Column(name="fubeid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="identity")
	private String identity;
	
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="location")
	private Location location;
	
	@Column(name="cartype")
	private CarType carType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}	

}
