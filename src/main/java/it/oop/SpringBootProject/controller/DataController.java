/**
 * 
 */
package it.oop.SpringBootProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.model.twitter.Tweet;
import it.oop.SpringBootProject.service.DataService;
import it.oop.SpringBootProject.service.JsonParserService;

/**
 * @author Mattia
 *
 */
@RestController
public class DataController {
	
	private static final String fqdn = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/user_timeline.json";
	
	@RequestMapping("/rawdata")
	public List<Tweet> getRawData(
			@RequestParam(name = "screen_name", defaultValue = "_SpaceWeather_", required = false) String name, 
			@RequestParam(name = "count", defaultValue = "50", required = false) Integer count, 
			HttpServletRequest req) {
		
		System.out.println("/rawdata request from "+req.getRemoteAddr());
		System.out.println("\targuments: ");
		System.out.println("\tscreen_name = "+name);
		System.out.println("\tcount = "+count.toString());
		
		//return DataService.getRemoteData(fqdn+"?screen_name="+name+"&count="+count.toString());
		return DataService.getTweets(fqdn+"?screen_name="+name+"&count="+count.toString());
	}
	
	@RequestMapping("/data")
	public List<SolarEvent> getData(
			@RequestParam(name = "screen_name", defaultValue = "_SpaceWeather_", required = false) String name, 
			@RequestParam(name = "count", defaultValue = "50", required = false) Integer count, 
			HttpServletRequest req) {
		
		System.out.println("/rawdata request from "+req.getRemoteAddr());
		System.out.println("\targuments: ");
		System.out.println("\tscreen_name = "+name);
		System.out.println("\tcount = "+count.toString());
		
		return DataService.convert(
				DataService.getTweets(fqdn+"?screen_name="+name+"&count="+count.toString()));
	}
	
	@RequestMapping("/metadata")
	public String getMetadata(HttpServletRequest req) {
		
		System.out.println("/metadata request from "+req.getRemoteAddr());
		
		return JsonParserService.getClassMetadata(Tweet.class);
	}

}
