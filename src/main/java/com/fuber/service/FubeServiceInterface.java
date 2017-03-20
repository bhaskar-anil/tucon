package com.fuber.service;

import java.util.Collection;

import com.fuber.Fube;

public interface FubeServiceInterface {
	
	public Fube saveFube(Fube fube);
	
	public Collection<Fube> getAllFubes();
	
	public Fube updateFube(Fube fube);

}
