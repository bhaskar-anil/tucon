package com.fuber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuber.Fube;

public interface FubeRepository extends JpaRepository<Fube, Long> {
	
	List<Fube> findByFubeType(String fubeType); //to get all cabs or customer
	
	List<Fube> findByFubeTypeAndStatus(String fubeType, String status); //to get available cabs
	
	List<Fube> findByFubeTypeAndStatusAndCarType(String fubeType,String status,String carType); //get available cabs by their type

}
