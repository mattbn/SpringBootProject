/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.oop.SpringBootProject.util.SolarEventDeserializer;

/**
 * Rappresenta un generico evento solare
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
@JsonIgnoreProperties(value = {"intensityRegex"})
@JsonDeserialize(using = SolarEventDeserializer.class)
public abstract class SolarEvent {
	
	protected IntensityLevel intensity;
	protected Calendar date; // data di osservazione
	protected EventType type;
	public Class<? extends IntensityLevel> intensityClass;
	
	
	/**
	 * 
	 * @return Il tipo di evento solare (costante)
	 */
	public abstract EventType getType();
	
	/**
	 * 
	 * @return L'espressione regolare dell'evento solare (costante)
	 */
	public abstract String getIntensityRegex();
	
	
	/**
	 * Costruttore di base
	 */
	public SolarEvent() {
		intensity = null;
		date = Calendar.getInstance();
	}
	
	/**
	 * Costruttore di copia
	 * 
	 * @param event L'evento di cui effettuare la copia
	 */
	public SolarEvent(SolarEvent event) {
		if(event != null) {
			intensity = event.getIntensity();
			date = event.getDate();
		}
		
		else {
			intensity = null;
			date = Calendar.getInstance();
		}
	}
	
	/**
	 * 
	 * @param intensity L'intensita' dell'evento solare
	 * @param date La data di osservazione
	 */
	public SolarEvent(IntensityLevel intensity, Calendar date) {
		this.intensity = intensity;
		this.date = date;
	}


	/**
	 * 
	 * @return L'intensita' attuale
	 */
	public IntensityLevel getIntensity() {
		return intensity;
	}


	/**
	 * 
	 * @param intensity La nuova intensita'
	 */
	public void setIntensity(IntensityLevel intensity) {
		this.intensity = intensity;
	}


	/**
	 * 
	 * @return La data attuale
	 */
	public Calendar getDate() {
		return date;
	}


	/**
	 * 
	 * @param date La nuova data
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		if(intensity == null)
			return getType().toString()+" (unknown) [observed at: "+date.toString()+"]";
		return getType().toString()+" ("+intensity.toString()+") [observed at: "+date.toString()+"]";
	}
	
	/**
	 * Effettua un confronto sui due oggetti
	 * 
	 * @param ev L'evento su cui effettuare il confronto
	 * @return true se this == ev, false altrimenti
	 */
	public boolean equals(SolarEvent ev) {
		return (ev != null && intensity != null && 
				intensity.equals(ev.getIntensity()) && date.equals(ev.getDate()));
	}

}
