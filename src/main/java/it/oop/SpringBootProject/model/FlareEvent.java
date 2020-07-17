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
	
	private final String intensityRegex = "([A-C]|M|X)([0-9]+[.][0-9]+)";
	

	@Override
	public EventType getType() {
		return EventType.Flare;
	}
	
	@Override
	public String getIntensityRegex() {
		// https://stackoverflow.com/a/12643073
		return intensityRegex;
	}
	
	public FlareEvent() {
		super();
		type = EventType.Flare;
		intensityClass = FlareIntensityLevel.class;
	}
	
	public FlareEvent(FlareEvent event) {
		super(event);
		type = EventType.Flare;
		intensityClass = FlareIntensityLevel.class;
	}
	
	public FlareEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
		type = EventType.Flare;
		intensityClass = FlareIntensityLevel.class;
	}

}
