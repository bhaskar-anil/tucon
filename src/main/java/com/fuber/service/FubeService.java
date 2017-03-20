package com.fuber.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.Fube;
import com.fuber.repository.FubeRepository;

@Service
@Transactional
public class FubeService implements FubeServiceInterface{
	
	@Autowired
	protected FubeRepository fubeRepository;

	@Override
	public Fube saveFube(Fube fube) {
		return fubeRepository.save(fube);
	}

	@Override
	public Collection<Fube> getAllFubes() {
		Iterable<Fube> fubes = fubeRepository.findAll();
		return (Collection<Fube>) fubes;
	}

	@Override
	public Fube updateFube(Fube fube) {
		// TODO Auto-generated method stub
		return fubeRepository.save(fube);
	}
	
	

}
