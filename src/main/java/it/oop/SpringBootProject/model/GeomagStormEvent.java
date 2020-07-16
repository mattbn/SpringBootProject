/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Date;

import it.oop.SpringBootProject.model.SolarEvent;

/**
 * @author Mattia
 *
 */
public class GeomagStormEvent extends SolarEvent {

	@Override
	public EventType getType() {
		return EventType.GeomagneticStorm;
	}

	@Override
	public String getIntensityRegex() {
		return "Kp[0-9]";
	}
	
	public GeomagStormEvent() {
		super();
	}
	
	public GeomagStormEvent(GeomagStormEvent event) {
		super(event);
	}
	
	public GeomagStormEvent(IntensityLevel intensity, Date date) {
		super(intensity, date);
	}

}
