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

}
