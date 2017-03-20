package com.fuber.service;

import java.util.Collection;

import com.fuber.Location;

public interface LocationServiceInterface {
	
	public Location saveLocation(Location location);
	
	public Collection<Location> getAllLocations();
	
	public Location updateLocation(Location location);

}
