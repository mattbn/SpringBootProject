/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Date;

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
	
	public GeomagConditionsEvent(GeomagConditionsEvent event) {
		super(event);
	}
	
	public GeomagConditionsEvent(IntensityLevel intensity, Date date) {
		super(intensity, date);
	}

}
