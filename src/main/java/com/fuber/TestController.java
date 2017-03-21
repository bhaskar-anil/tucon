package com.fuber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fuber.service.FubeService;
import com.fuber.service.LocationService;

@Controller
public class TestController {
	@Autowired
	protected FubeService fubeService;
	
	@Autowired
	protected LocationService locationService;
	
	//Location loc = new Locat
	
	Fube fube =	new Fube("KA03MZ7010", new Location(new Double(2),new Double(3)), CarType.LIMO, Status.SEEKING);

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
		fubeService.saveFube(fube);
		model.addAttribute("fubes", fubeService.getAllFubes());
		return "index";
	}
	
	@RequestMapping(value="/cabs", method=RequestMethod.GET)
	public String availabeCabs(){
		
		System.out.println(fubeService.getAllFubes().size());
		return "index.html";
	}

}
