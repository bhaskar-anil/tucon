package com.fuber.service;

import java.util.Collection;
import java.util.List;

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
	
	public List<Fube> getAllCabs(String fubeType){
		return fubeRepository.findByFubeType(fubeType);
	}
	
	public List<Fube> getAllAvailableCabs(String fubeType, String status){
		return fubeRepository.findByFubeTypeAndStatus(fubeType, status);
	}
	
	public Fube findNearestAvailabeCab(Fube customer){
		Fube nearestCab = null;
		
		//get all available cabs for the carType
		if(customer.getCarType() != null) {
			List<Fube> availableCabs = fubeRepository.findByFubeTypeAndStatusAndCarType("CAB","SEEKING", customer.getCarType().toString());
			for(Fube cab : availableCabs){
				if(nearestCab != null && cab.isNearThan(nearestCab)){
					nearestCab = cab;
				}
			}
			if(nearestCab != null){
				return nearestCab;
			}
			return null;
		}else{
		
		//get all available cabs- (if there is no preference by the customer)
		List<Fube> availableCabs = fubeRepository.findByFubeTypeAndStatus("CAB","SEEKING");
		
			for(Fube cab : availableCabs){
				if(nearestCab != null && cab.isNearThan(nearestCab)){
					nearestCab = cab;
				}
			}
			if(nearestCab != null){
				return nearestCab;
			}
			return null;			
		}
	}

}
