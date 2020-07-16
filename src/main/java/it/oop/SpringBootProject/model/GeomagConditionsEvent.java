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

	@Override
	public EventType getType() {
		return EventType.GeomagneticConditions;
	}

	@Override
	public String getIntensityRegex() {
		return "Kp[0-9]";
	}
	
	public GeomagConditionsEvent() {
		super();
	}
	
	public GeomagConditionsEvent(GeomagConditionsEvent event) {
		super(event);
	}
	
	public GeomagConditionsEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
	}

}
