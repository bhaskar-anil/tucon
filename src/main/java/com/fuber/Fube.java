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
@Table(name = "FUBE")
public class Fube {

	@Id
	@Column(name = "fubeid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "identity")
	private String identity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location")
	private Location location;

	@Column(name = "cartype")
	private CarType carType;

	@Column(name = "status")
	private Status status;

	@Column(name = "fubeType")
	private String fubeType;

	public Fube() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fube(String identity, Location location, CarType carType, Status status) {
		super();
		this.identity = identity;
		this.location = location;
		this.carType = carType;
		this.status = status;
		if (Character.isDigit(this.getIdentity().charAt(0))) {
			this.fubeType = "CUSTOMER";
		}else{
			this.fubeType = "CAB";
		}
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFubeType() {
		return fubeType;
	}

	public void setFubeType() {
		if (Character.isDigit(this.getIdentity().charAt(0))) {
			this.fubeType = "CUSTOMER";
		}else{
			this.fubeType = "CAB";
		}		
	}

	public boolean isNearThan(Fube nearestCab) {
		// TODO Auto-generated method stub
		return false;
	}

}
