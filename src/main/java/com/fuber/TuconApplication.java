package com.fuber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fuber.service.FubeService;

@SpringBootApplication
public class TuconApplication {
	
	@Autowired
	protected FubeService fubeService;
	
	Fube fube =	new Fube("KA03MZ7010", new Location(), CarType.LIMO, Status.SEEKING);

	public static void main(String[] args) {
		SpringApplication.run(TuconApplication.class, args);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		fubeService.saveFube(fube);
		return "index.html";
	}
	
	@RequestMapping(value="/cabs", method=RequestMethod.GET)
	public String availabeCabs(){
		fubeService.getAllFubes();
		return "index.html";
	}
}
