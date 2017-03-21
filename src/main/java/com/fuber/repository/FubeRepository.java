package com.fuber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuber.CarType;
import com.fuber.Fube;
import com.fuber.Status;

public interface FubeRepository extends JpaRepository<Fube, Long> {
	
	List<Fube> findByFubeType(String fubeType); //to get all cabs or customer
	
	List<Fube> findByFubeTypeAndStatus(String fubeType, Status status); //to get available cabs
	
	List<Fube> findByFubeTypeAndStatusAndCarType(String fubeType,Status status,CarType carType); //get available cabs by their type

}
