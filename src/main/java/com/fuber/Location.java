package com.fuber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="GEOLOCATION")
public class Location {
	
	@Id
	@Column(name="geoid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long geoid;
	
	@Column(name="latitute")
	private Double latitute;
	
	@Column(name="longitude")
	private Double longitude;
	
	@OneToOne(mappedBy="location")
	private Fube fube;

	public Long getGeoid() {
		return geoid;
	}

	public void setGeoid(Long geoid) {
		this.geoid = geoid;
	}

	public Double getLatitute() {
		return latitute;
	}

	public void setLatitute(Double latitute) {
		this.latitute = latitute;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}	

}
