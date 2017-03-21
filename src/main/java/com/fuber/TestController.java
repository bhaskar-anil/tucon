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
	
	//lets add some available cabs to start with
	Fube[] availabeCabsToStartWith =	{
			new Fube("KA03MZ7010", new Location(new Double(1),new Double(1)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7011", new Location(new Double(1),new Double(5)), CarType.LIMO, Status.SEEKING)/*,
			new Fube("KA03MZ7012", new Location(new Double(4),new Double(9)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7013", new Location(new Double(5),new Double(7)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7014", new Location(new Double(3),new Double(6)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7015", new Location(new Double(2),new Double(3)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7016", new Location(new Double(2),new Double(3)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7017", new Location(new Double(2),new Double(3)), CarType.LIMO, Status.SEEKING),
			new Fube("KA03MZ7018", new Location(new Double(2),new Double(3)), CarType.LIMO, Status.SEEKING)*/
	};
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
		for(Fube availabeCab : availabeCabsToStartWith){
			fubeService.saveFube(availabeCab);
		}		
		model.addAttribute("cabs", fubeService.getAllCabs("CAB"));
		return "index";
	}
	
	//a new customer comes to book a cab
	Fube aNewCustomerComes = new Fube("9620856017", new Location(new Double(2),new Double(2)), null, Status.SEEKING);
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public String bookCab(Model model){
		Fube nearestCab = fubeService.findNearestAvailabeCab(aNewCustomerComes);
		
		System.out.println(nearestCab.toString());
		model.addAttribute("cab", nearestCab);
		return "cab";
	}

}
