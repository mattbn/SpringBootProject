/**
 * 
 */
package it.oop.SpringBootProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.service.StatService;
import it.oop.SpringBootProject.util.CountStatCalc;
import it.oop.SpringBootProject.util.IntensityStatCalc;

/**
 * @author Mattia
 *
 */
@RestController
public class StatController {
	
	
	
	@PostMapping("/stat/count/{event}")
	public List<CountStatCalc> getCountStats(@RequestBody List<SolarEvent> eventList, 
			@PathVariable(name = "event") String eventName, 
			@RequestParam(name = "interval", defaultValue = "month", required = false) String interval, 
			HttpServletRequest req) {
		
		System.out.println("/stat/count/"+eventName+" request from "+req.getRemoteAddr());
		System.out.println("\targuments: ");
		if(eventName != null)
			System.out.println("\tevent = "+eventName);
		System.out.println("\tinterval = "+interval);
		
		return StatService.getCountStat(eventList, eventName, interval);
	}
	
	@PostMapping("/stat/intensity/{event}")
	public List<IntensityStatCalc> getIntensityStat(@RequestBody List<SolarEvent> eventList, 
			@PathVariable(name = "event") String eventName, 
			@RequestParam(name = "interval", defaultValue = "month", required = false) String interval, 
			HttpServletRequest req) {
		
		System.out.println("/stat/count/"+eventName+" request from "+req.getRemoteAddr());
		System.out.println("\targuments: ");
		if(eventName != null)
			System.out.println("\tevent = "+eventName);
		System.out.println("\tinterval = "+interval);
		
		return StatService.getIntensityStat(eventList, eventName, interval);
	}

}
