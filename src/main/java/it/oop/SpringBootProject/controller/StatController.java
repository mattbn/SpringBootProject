/**
 * 
 */
package it.oop.SpringBootProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mattia
 *
 */
@RestController
public class StatController {
	
	
	
	@PostMapping("/stat/general/{event}")
	public String getGeneralStat(@RequestBody List<SolarEvent> eventList, 
			@PathVariable(name = "event") String eventName, 
			@RequestParam(name = "interval", defaultValue = "month", required = false) String interval) {
		
		return StatService.getGeneralStat(eventList, eventName, interval).calc();
		
	}
	
	@PostMapping("/stat/intensity/{event}")
	public String getIntensityStat(@RequestBody List<SolarEvent> eventList, 
			@PathVariable(name = "event") String eventName, 
			@RequestParam(name = "interval", defaultValue = "month", required = false) {
		
		return StatService.getIntensityStat(eventList, eventName, interval).calc();
		
	}

}
