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
 * Gestisce le richieste sulle rotte relative ai dati<br>
 * <i>/data<br>
 * /metadata<br>
 * /rawdata</i>
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
@RestController
public class DataController {
	
	private static final String fqdn = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/user_timeline.json";
	
	/**
	 * Gestisce la rotta /rawdata per l'ottenimento diretto di tweet
	 * 
	 * @param name Il tag unico dell'utente Twitter
	 * @param count Il numero di tweet da raccogliere
	 * @param req Oggetto contenente i dati della richiesta al fine di identificare il client
	 * @return La lista di tweet ottenuta
	 */
	@RequestMapping("/rawdata")
	public List<Tweet> getRawData(
			@RequestParam(name = "screen_name", defaultValue = "_SpaceWeather_", required = false) String name, 
			@RequestParam(name = "count", defaultValue = "50", required = false) Integer count, 
			HttpServletRequest req) {
		
		if(name == null)
			name = "_SpaceWeather_";
		if(count == null)
			count = 20;
		
		System.out.println("/rawdata request from "+req.getRemoteAddr());
		System.out.println("\targuments: ");
		System.out.println("\tscreen_name = "+name);
		System.out.println("\tcount = "+count.toString());
		
		//return DataService.getRemoteData(fqdn+"?screen_name="+name+"&count="+count.toString());
		return DataService.getTweets(fqdn+"?screen_name="+name+"&count="+count.toString());
	}
	
	/**
	 * Gestisce la rotta /data per l'ottenimento di dati di eventi solari
	 * 
	 * @param name Il tag unico dell'utente twitter
	 * @param count Il numero di tweet da raccogliere
	 * @param req Oggetto contenente i dati della richiesta al fine di identificare il client
	 * @return La lista di eventi solari ottenuta
	 */
	@RequestMapping("/data")
	public List<SolarEvent> getData(
			@RequestParam(name = "screen_name", defaultValue = "_SpaceWeather_", required = false) String name, 
			@RequestParam(name = "count", defaultValue = "50", required = false) Integer count, 
			HttpServletRequest req) {
		
		if(name == null)
			name = "_SpaceWeather_";
		if(count == null)
			count = 20;
		
		System.out.println("/rawdata request from "+req.getRemoteAddr());
		System.out.println("\targuments: ");
		System.out.println("\tscreen_name = "+name);
		System.out.println("\tcount = "+count.toString());
		
		List<Tweet> tweets = DataService.getTweets(fqdn+"?screen_name="+name+"&count="+count.toString());
		return DataService.convert(tweets);
	}
	
	/**
	 * Gestisce la rotta /metadata per l'ottenimento di metadati relativi 
	 * alle classi Tweet e SolarEvent
	 * 
	 * @param req Oggetto contenente i dati della richiesta al fine di identificare il client
	 * @return Stringa contenente i metadati
	 */
	@RequestMapping("/metadata")
	public String getMetadata(HttpServletRequest req) {
		
		System.out.println("/metadata request from "+req.getRemoteAddr());
		
		String res = JsonParserService.getClassMetadata(Tweet.class) + 
				JsonParserService.getClassMetadata(SolarEvent.class);
		
		return res;
	}

}
