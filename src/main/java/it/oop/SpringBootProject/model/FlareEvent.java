/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * Rappresenta un evento solare di tipo Flare
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class FlareEvent extends SolarEvent {
	
	private final String intensityRegex = "([A-C]|M|X)([0-9]+[.][0-9]+)";
	

	/**
	 * @return Il tipo di evento solare (costante)
	 */
	@Override
	public EventType getType() {
		return EventType.Flare;
	}
	
	/**
	 * @return L'espressione regolare dell'evento solare (costante)
	 */
	@Override
	public String getIntensityRegex() {
		// https://stackoverflow.com/a/12643073
		return intensityRegex;
	}
	
	/**
	 * Costruttore di base
	 */
	public FlareEvent() {
		super();
		type = EventType.Flare;
		intensityClass = FlareIntensityLevel.class;
	}
	
	/*
	 * Costruttore di copia
	 * 
	 * @param event L'evento di cui effettuare la copia
	 */
	public FlareEvent(FlareEvent event) {
		super(event);
		type = EventType.Flare;
		intensityClass = FlareIntensityLevel.class;
	}
	
	/**
	 * 
	 * @param intensity L'intensita' dell'evento solare
	 * @param date La data di osservazione
	 */
	public FlareEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
		type = EventType.Flare;
		intensityClass = FlareIntensityLevel.class;
	}

}
