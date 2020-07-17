/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public class FlareEvent extends SolarEvent {

	@Override
	public EventType getType() {
		return EventType.Flare;
	}
	
	@Override
	public String getIntensityRegex() {
		// https://stackoverflow.com/a/12643073
		return "[A-Z]([0-9]*[.])?[0-9]+";
	}
	
	public FlareEvent() {
		super();
	}
	
	public FlareEvent(FlareEvent event) {
		super(event);
	}
	
	public FlareEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
	}

}
