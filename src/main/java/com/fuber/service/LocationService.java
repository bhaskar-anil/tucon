package com.fuber.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.Location;
import com.fuber.repository.LocationRepository;

@Service
@Transactional
public class LocationService implements LocationServiceInterface{
	
	@Autowired
	protected LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

	@Override
	public Collection<Location> getAllLocations() {
		Iterable<Location> locations = locationRepository.findAll();
		return (Collection<Location>) locations;
	}

	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

}
