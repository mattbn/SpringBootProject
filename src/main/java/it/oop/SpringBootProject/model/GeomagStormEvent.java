/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

import it.oop.SpringBootProject.model.SolarEvent;

/**
 * @author Mattia
 *
 */
public class GeomagStormEvent extends SolarEvent {
	
	private final String intensityRegex = "Kp[0-9]";
	

	@Override
	public EventType getType() {
		return EventType.GeomagneticStorm;
	}

	@Override
	public String getIntensityRegex() {
		return intensityRegex;
	}
	
	public GeomagStormEvent() {
		super();
		type = EventType.GeomagneticStorm;
		intensityClass = GeomagneticIntensityLevel.class;
	}
	
	public GeomagStormEvent(GeomagStormEvent event) {
		super(event);
		type = EventType.GeomagneticStorm;
		intensityClass = GeomagneticIntensityLevel.class;
	}
	
	public GeomagStormEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
		type = EventType.GeomagneticStorm;
		intensityClass = GeomagneticIntensityLevel.class;
	}

}
