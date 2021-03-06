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

/**
 * Gestisce le operazioni sui dati
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class DataService {
	
	private static final SolarEvent[] EVENT_INSTANCES = {
			new FlareEvent(), 
			new GeomagConditionsEvent(), 
			new GeomagStormEvent()
	};
	
	public static final Map<String,SolarEvent> VALUE_INSTANCES = Map.ofEntries(
			Map.entry("flare", EVENT_INSTANCES[0]), 
			Map.entry("Flare", EVENT_INSTANCES[0]), 
			
			Map.entry("geomagnetic conditions", EVENT_INSTANCES[1]), 
			Map.entry("Geomagnetic conditions", EVENT_INSTANCES[1]), 
			Map.entry("geomagnetic_conditions", EVENT_INSTANCES[1]), 
			Map.entry("GeomagneticConditions", EVENT_INSTANCES[1]), 
			Map.entry("gconditions", EVENT_INSTANCES[1]), 
			
			Map.entry("geomagnetic storm", EVENT_INSTANCES[2]), 
			Map.entry("Geomagnetic storm", EVENT_INSTANCES[2]),  
			Map.entry("GeomagneticStorm", EVENT_INSTANCES[2]), 
			Map.entry("geomagnetic_storm", EVENT_INSTANCES[2]), 
			Map.entry("gstorm", EVENT_INSTANCES[2]));
	
	/**
	 * Converte un Tweet in un SolarEvent
	 * 
	 * @param tweet Il tweet da convertire
	 * @return L'evento solare corrispondente (o null se non disponibile)
	 */
	public static SolarEvent convert(Tweet tweet) {
		
		if(tweet != null)
			for(Map.Entry<String,SolarEvent> e : VALUE_INSTANCES.entrySet())
				if(tweet.getText().contains(e.getKey())) {
					
					// ottiene data di osservazione
					// la data corrisponde alla data di pubblicazione
					// l'orario e' nel testo del tweet
					Calendar obs = tweet.getCreationDate();
					obs.add(Calendar.YEAR, 1900);
					Matcher m = Pattern.compile("[0-9][0-9]:[0-9][0-9] UTC").matcher(tweet.getText());
					if(m.find()) {
						String dateStr = m.group();
						obs.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateStr.substring(0,2)));
						obs.set(Calendar.MINUTE, Integer.parseInt(dateStr.substring(3,5)));
					}
					
					
					// ottiene intensita' dalla stringa
					IntensityLevel il = null;
					try {
						il = e.getValue().intensityClass.getDeclaredConstructor(String.class, String.class)
								.newInstance(tweet.getText(), e.getValue().getIntensityRegex());
					} catch (InstantiationException | 
							IllegalAccessException | IllegalArgumentException | 
							InvocationTargetException | NoSuchMethodException | 
							SecurityException e2) {
						System.err.println(e2.getClass().getCanonicalName()+": invalid event text");
						return null;
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
	
	/**
	 * Converte una lista di tweet in una lista di eventi solari
	 * 
	 * @param tweets La lista di tweet da convertire
	 * @return La lista di eventi solari corrispondente
	 */
	public static List<SolarEvent> convert(List<Tweet> tweets) { // LinkedList impl
		List<SolarEvent> ls = new ArrayList<SolarEvent>();
		for(Tweet t : tweets) {
			SolarEvent ev = convert(t);
			if(ev != null)
				ls.add(ev);
		}
		
		return ls;
	}
	
	/**
	 * Ottiene una stringa di dati da un indirizzo remoto
	 * 
	 * @param address L'indirizzo al quale collegarsi
	 * @return La stringa di dati ottenuta dall'indirizzo
	 */
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
	
	/**
	 * Ottiene una lista di tweet collegandosi a un indirizzo remoto
	 * 
	 * @param address L'indirizzo al quale collegarsi
	 * @return La lista di tweet corrispondente
	 */
	public static List<Tweet> getTweets(String address) {
		String jsonStr = getRemoteData(address);
		return JsonParserService.read(jsonStr, new TypeReference<List<Tweet>>() {});
	}

}
