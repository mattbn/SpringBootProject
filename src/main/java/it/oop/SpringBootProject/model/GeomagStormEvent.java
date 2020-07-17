/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * Rappresenta un evento solare di tipo Geomagnetic storm
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class GeomagStormEvent extends SolarEvent {
	
	private final String intensityRegex = "Kp[0-9]";
	

	/**
	 * @return Il tipo di evento solare (costante)
	 */
	@Override
	public EventType getType() {
		return EventType.GeomagneticStorm;
	}

	/**
	 * @return L'espressione regolare dell'evento solare (costante)
	 */
	@Override
	public String getIntensityRegex() {
		return intensityRegex;
	}
	
	/**
	 * Costruttore di base
	 */
	public GeomagStormEvent() {
		super();
		type = EventType.GeomagneticStorm;
		intensityClass = GeomagneticIntensityLevel.class;
	}
	
	/**
	 * Costruttore di copia
	 * 
	 * @param event L'evento di cui effettuare la copia
	 */
	public GeomagStormEvent(GeomagStormEvent event) {
		super(event);
		type = EventType.GeomagneticStorm;
		intensityClass = GeomagneticIntensityLevel.class;
	}
	
	/**
	 * 
	 * @param intensity L'intensita' dell'evento
	 * @param date La data di osservazione
	 */
	public GeomagStormEvent(IntensityLevel intensity, Calendar date) {
		super(intensity, date);
		type = EventType.GeomagneticStorm;
		intensityClass = GeomagneticIntensityLevel.class;
	}

}
