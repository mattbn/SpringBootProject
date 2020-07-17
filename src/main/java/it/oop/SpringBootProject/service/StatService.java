/**
 * 
 */
package it.oop.SpringBootProject.service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.oop.SpringBootProject.model.Date;
import it.oop.SpringBootProject.model.EventType;
import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.util.CountStatCalc;
import it.oop.SpringBootProject.util.IntensityStatCalc;
import it.oop.SpringBootProject.util.Pair;

/**
 * @author Mattia
 *
 */
public class StatService {
	
	private static final Map<String,Integer> INTERVAL_INSTANCES = Map.of(
			"daily", Calendar.DAY_OF_MONTH, 
			"day", Calendar.DAY_OF_MONTH, 
			"monthly", Calendar.MONTH, 
			"month", Calendar.MONTH, 
			"yearly", Calendar.YEAR, 
			"year", Calendar.YEAR);
	
	
	private static List<List<SolarEvent>> getSublist(List<SolarEvent> events, String name, String interval) {
		
		System.out.println("Checking map keys...");
		if(!DataService.VALUE_INSTANCES.containsKey(name))
			throw new IllegalArgumentException("Nome evento solare non valido. Controllare il dato inserito");
		if(!INTERVAL_INSTANCES.containsKey(interval))
			throw new IllegalArgumentException("Intervallo temporale non valido. Controllare il dato inserito");
		
		List<List<SolarEvent>> res = new LinkedList<>();
		
		System.out.println("initializing name filtering...");
		// ottiene gli eventi del tipo specificato
		int dateFieldId = INTERVAL_INSTANCES.get(interval);
		EventType eventType = DataService.VALUE_INSTANCES.get(name).getType();
		List<Pair<Date, SolarEvent>> nameCompliantEvents = new LinkedList<>();
		for(SolarEvent ev : events)
			if(ev.getType() == eventType) {
				System.out.println("filtering names...");
				nameCompliantEvents.add(Pair.make(new Date(ev.getDate(), dateFieldId), ev));
			}
		
		System.out.println("initializing date filtering...");
		while(!nameCompliantEvents.isEmpty()) {
			List<SolarEvent> filteredEvents = new LinkedList<>();
			Date d = nameCompliantEvents.get(0).first;
			
			for(Pair<Date,SolarEvent> p : nameCompliantEvents)
				if(p.first.equals(d)) {
					System.out.println("filtering dates...");
					filteredEvents.add(p.second);
					nameCompliantEvents.remove(p);
				}
			
			System.out.println("done");
			res.add(filteredEvents);
		}
		
		return res;
	}
	
	
	public static List<CountStatCalc> getCountStat(List<SolarEvent> events, String name, String interval) {
		
		List<CountStatCalc> res = new LinkedList<>();
		
		System.out.println("calling getSublist()...");
		List<List<SolarEvent>> filteredEvents = getSublist(events, name, interval);
		for(List<SolarEvent> subl : filteredEvents)
			res.add(new CountStatCalc(name, interval, subl, List.class));
		
		return res;
	}
	
	// stat sull'intensita' degli eventi!!
	public static List<IntensityStatCalc> getIntensityStat(List<SolarEvent> events, String name, 
			String interval) {
		
		List<IntensityStatCalc> res = new LinkedList<>();
		
		List<List<SolarEvent>> filteredEvents = getSublist(events, name, interval);
		for(List<SolarEvent> subl : filteredEvents)
			res.add(new IntensityStatCalc(name, interval, subl, List.class));
		
		return res;
	}

}
