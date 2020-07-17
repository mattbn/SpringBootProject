/**
 * 
 */
package it.oop.SpringBootProject.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.type.TypeReference;

import it.oop.SpringBootProject.model.FlareEvent;
import it.oop.SpringBootProject.model.GeomagConditionsEvent;
import it.oop.SpringBootProject.model.GeomagStormEvent;
import it.oop.SpringBootProject.model.IntensityLevel;
import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.model.twitter.Tweet;
import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * @author Mattia
 *
 */
public class DataService {
	
	public static final Map<String,SolarEvent> VALUE_INSTANCES = Map.of(
			"flare", new FlareEvent(), 
			"Flare", new FlareEvent(), 
			"geomagnetic conditions", new GeomagConditionsEvent(), 
			"Geomagnetic conditions", new GeomagConditionsEvent(), 
			"GeomagneticConditions", new GeomagConditionsEvent(), 
			"geomagnetic storm", new GeomagStormEvent(), 
			"Geomagnetic storm", new GeomagStormEvent(), 
			"GeomagneticStorm", new GeomagStormEvent());
	
	@SuppressWarnings("deprecation")
	public static SolarEvent convert(Tweet tweet) {
		
		if(tweet != null)
			for(Map.Entry<String,SolarEvent> e : VALUE_INSTANCES.entrySet())
				if(tweet.getText().contains(e.getKey())) {
					// ottiene data di osservazione
					// la data corrisponde alla data di pubblicazione
					// l'orario e' nel testo del tweet
					Calendar obs = tweet.getCreationDate();
					Matcher m = Pattern.compile("[0-9][0-9]:[0-9][0-9] UTC").matcher(tweet.getText());
					if(m.find()) {
						System.out.println("observation date match");
						String dateStr = m.group();
						obs.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateStr.substring(0,2)));
						obs.set(Calendar.MINUTE, Integer.parseInt(dateStr.substring(3,5)));
					}
					
					
					// ottiene intensita' dalla stringa
					IntensityLevel il = null;
					try {
						il = new IntensityLevel(tweet.getText(), e.getValue().getIntensityRegex());
					} catch (InvalidIntensityFormatException e2) {
						e2.printStackTrace();
					}
					
					// crea una nuova istanza della classe
					try {
						return e.getValue().getClass().getDeclaredConstructor(IntensityLevel.class, Calendar.class).newInstance(il, obs);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
						e1.printStackTrace();
					}
				}
		
		return null;
	}
	
	public static List<SolarEvent> convert(List<Tweet> tweets) { // LinkedList impl
		List<SolarEvent> ls = new ArrayList<SolarEvent>();
		for(Tweet t : tweets) {
			SolarEvent ev = convert(t);
			if(ev != null)
				ls.add(ev);
		}
		
		return ls;
	}
	
	
	public static String getRemoteData(String address) {
		String res = "";
		InputStream is = null;
		
		try {
			is = new URL(address).openConnection().getInputStream();
		} catch (MalformedURLException e1) {
			res = "\"error\" : \"URL non corretto\"";
			e1.printStackTrace();
			return res;
		} catch (IOException e1) {
			res = "\"error\" : \"Impossibile leggere i dati dall'indirizzo specificato\"";
			e1.printStackTrace();
			return res;
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String ln = null;
			while((ln = br.readLine()) != null)
				res += ln + "\n";
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			res = "\"error\" : \"Impossibile leggere i dati dall'indirizzo specificato\"";
		}

		return res;
	}
	
	public static List<Tweet> getTweets(String address) {
		String jsonStr = getRemoteData(address);
		return JsonParserService.read(jsonStr, new TypeReference<List<Tweet>>() {});
	}

}
