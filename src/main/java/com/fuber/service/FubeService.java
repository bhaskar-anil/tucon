package com.fuber.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.Fube;
import com.fuber.Status;
import com.fuber.repository.FubeRepository;

@Service
@Transactional
public class FubeService implements FubeServiceInterface {

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

	public List<Fube> getAllCabs(String fubeType) {
		return fubeRepository.findByFubeType(fubeType);
	}

	public List<Fube> getAllAvailableCabs(String fubeType, Status status) {
		return fubeRepository.findByFubeTypeAndStatus(fubeType, status);
	}

	public Fube findNearestAvailabeCab(Fube customer) {
		Fube nearestCab = null;

		// get all available cabs for the carType
		if (customer.getCarType() != null) {
			List<Fube> availableCabs = fubeRepository.findByFubeTypeAndStatusAndCarType("CAB", customer.getStatus(),
					customer.getCarType());
			for (Fube cab : availableCabs) {
				if (nearestCab == null) {
					nearestCab = cab;
				} else if (customer.isNearThan(nearestCab, cab)) {
					nearestCab = cab;
				}
			}
			return nearestCab;
		} else {

			// get all available cabs- (if there is no preference by the
			// customer)
			List<Fube> availableCabs = fubeRepository.findByFubeTypeAndStatus("CAB", customer.getStatus());

			for (Fube cab : availableCabs) {
				if (nearestCab == null) {
					nearestCab = cab;
				} else if (customer.isNearThan(nearestCab, cab)) {
					nearestCab = cab;
				}
			}
			return nearestCab;
		}
	}

}
