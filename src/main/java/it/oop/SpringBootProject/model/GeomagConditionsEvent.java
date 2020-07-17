/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public class GeomagConditionsEvent extends SolarEvent {
	
	private final String intensityRegex = "Kp[0-9]";
	

	@Override
	public EventType getType() {
		return type;
	}

	@Override
	public String getIntensityRegex() {
		return intensityRegex;
	}
	
	public GeomagConditionsEvent() {
		super();
		type = EventType.GeomagneticConditions;
	}
	
	public GeomagConditionsEvent(GeomagConditionsEvent event) {
		super(event);
		type = EventType.GeomagneticConditions;
	}
	
	public GeomagConditionsEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
		type = EventType.GeomagneticConditions;
	}

}
