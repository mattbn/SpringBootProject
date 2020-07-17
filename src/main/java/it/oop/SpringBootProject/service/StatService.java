/**
 * 
 */
package it.oop.SpringBootProject.service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import it.oop.SpringBootProject.model.EventType;
import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.util.CountStatCalc;
import it.oop.SpringBootProject.util.IntensityStatCalc;

/**
 * @author Mattia
 *
 */
public class StatService {
	
	private static List<List<SolarEvent>> filterListByMonth(List<SolarEvent> events, String name) {
		
		if(!DataService.VALUE_INSTANCES.containsKey(name))
			throw new IllegalArgumentException("Nome evento solare non valido. Controllare il dato inserito");
		List<List<SolarEvent>> res = new LinkedList<>();
		
		SolarEvent singleEvent = DataService.VALUE_INSTANCES.get(name);
		EventType eventType = null;
		
		if(singleEvent != null)
			eventType = DataService.VALUE_INSTANCES.get(name).getType();
		else
			return null;
		
		List<SolarEvent> nameCompliantEvents = new LinkedList<>();
		
		for(SolarEvent ev : events)
			if(ev != null && (name.equals("any") || ev.getType() == eventType))
				nameCompliantEvents.add(ev);
		
		while(!nameCompliantEvents.isEmpty()) {
			List<SolarEvent> newNameCompliant = new LinkedList<>();
			List<SolarEvent> filteredEvents = new LinkedList<>();
			int monthValue = nameCompliantEvents.get(0).getDate().get(Calendar.MONTH), 
				yearValue = nameCompliantEvents.get(0).getDate().get(Calendar.YEAR);
			
			for(SolarEvent ev : nameCompliantEvents) {
				if(ev.getDate().get(Calendar.MONTH) == monthValue && 
						ev.getDate().get(Calendar.YEAR) == yearValue)
					filteredEvents.add(ev);
				else 
					newNameCompliant.add(ev);
			}
			
			nameCompliantEvents.clear();
			nameCompliantEvents = newNameCompliant;
			
			res.add(filteredEvents);
		}
		
		return res;
	}

	private static List<List<SolarEvent>> filterListByYear(List<SolarEvent> events, String name){
		
		if(!DataService.VALUE_INSTANCES.containsKey(name))
			throw new IllegalArgumentException("Nome evento solare non valido. Controllare il dato inserito");
		List<List<SolarEvent>> res = new LinkedList<>();
		
		SolarEvent singleEvent = DataService.VALUE_INSTANCES.get(name);
		EventType eventType = null;
		
		if(singleEvent != null)
			eventType = DataService.VALUE_INSTANCES.get(name).getType();
		else
			return null;
		
		List<SolarEvent> nameCompliantEvents = new LinkedList<>();
		for(SolarEvent ev : events) 
			if(ev != null && ev.getType() == eventType)
				nameCompliantEvents.add(ev);
		
		while(!nameCompliantEvents.isEmpty()) {
			List<SolarEvent> newNameCompliant = new LinkedList<>();
			List<SolarEvent> filteredEvents = new LinkedList<>();
			int yearValue = nameCompliantEvents.get(0).getDate().get(Calendar.YEAR);
			
			for(SolarEvent ev : nameCompliantEvents) {
				if(ev.getDate().get(Calendar.YEAR) == yearValue)
					filteredEvents.add(ev);
				else 
					newNameCompliant.add(ev);
			}
			
			nameCompliantEvents.clear();
			nameCompliantEvents = newNameCompliant;
			
			res.add(filteredEvents);
		}
		
		return res;
	}
	
	public static List<CountStatCalc> getMonthCountStat(List<SolarEvent> events, String name) {
		List<CountStatCalc> res = new LinkedList<>();
		
		List<List<SolarEvent>> filteredEvents = filterListByMonth(events, name);
		for(List<SolarEvent> subl : filteredEvents)
			res.add(new CountStatCalc(name, "month", subl, List.class));
		
		return res;
	}
	
	public static List<CountStatCalc> getYearCountStat(List<SolarEvent> events, String name) {
		List<CountStatCalc> res = new LinkedList<>();
		
		List<List<SolarEvent>> filteredEvents = filterListByYear(events, name);
		for(List<SolarEvent> subl : filteredEvents)
			res.add(new CountStatCalc(name, "year", subl, List.class));
		
		return res;
	}
	
	// stat sull'intensita' degli eventi!!
	public static List<IntensityStatCalc> getMonthIntensityStat(List<SolarEvent> events, String name) {
		
		List<IntensityStatCalc> res = new LinkedList<>();
		
		List<List<SolarEvent>> filteredEvents = filterListByMonth(events, name);
		for(List<SolarEvent> subl : filteredEvents)
			res.add(new IntensityStatCalc(name, "month", subl, List.class));
		
		return res;
	}
	
	// stat sull'intensita' degli eventi!!
	public static List<IntensityStatCalc> getYearIntensityStat(List<SolarEvent> events, String name) {
		
		List<IntensityStatCalc> res = new LinkedList<>();
		
		List<List<SolarEvent>> filteredEvents = filterListByYear(events, name);
		for(List<SolarEvent> subl : filteredEvents)
			res.add(new IntensityStatCalc(name, "year", subl, List.class));
		
		return res;
	}
	
	/*
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
		SolarEvent singleEvent = DataService.VALUE_INSTANCES.get(name);
		EventType eventType = null;
		
		System.out.println(name);
		
		if(singleEvent != null)
			eventType = DataService.VALUE_INSTANCES.get(name).getType();
		else
			return null;
		
		List<Pair<Date, SolarEvent>> nameCompliantEvents = new LinkedList<>();
		for(SolarEvent ev : events)
			if(ev != null && ev.getType() == eventType) {
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
	*/

}
