/**
 * 
 */
package it.oop.SpringBootProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mattia
 *
 */
@RestController
public class DataController {
	
	private static final String fqdn = "";
	
	@RequestMapping("/data")
	public String getData(
			@RequestParam(name = "screen_name", defaultValue = "_SpaceWeather_", required = false) String name, 
			@RequestParam(name = "count", defaultValue = "50", required = false) Integer count) {
		return DataService.getRemoteData(fqdn+"?screen_name="+name+"&count="+count.toString());
	}
	
	@RequestMapping("/metadata")
	public String getMetadata() {
		return JsonParserService.writeClassMetadata(Tweet.class);
	}

}
