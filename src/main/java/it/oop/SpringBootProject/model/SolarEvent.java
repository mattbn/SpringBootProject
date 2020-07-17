/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.oop.SpringBootProject.util.SolarEventDeserializer;

/**
 * @author Mattia
 *
 */
@JsonIgnoreProperties(value = {"intensityRegex"})
@JsonDeserialize(using = SolarEventDeserializer.class)
public abstract class SolarEvent {
	
	protected IntensityLevel intensity;
	protected Calendar date; // data di osservazione
	protected EventType type;
	public Class<? extends IntensityLevel> intensityClass;
	
	
	public abstract EventType getType();
	
	public abstract String getIntensityRegex();
	
	
	public SolarEvent() {
		intensity = null;
		date = Calendar.getInstance();
	}
	
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
	
	public SolarEvent(IntensityLevel intensity, Calendar date) {
		this.intensity = intensity;
		this.date = date;
	}


	public IntensityLevel getIntensity() {
		return intensity;
	}


	public void setIntensity(IntensityLevel intensity) {
		this.intensity = intensity;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		if(intensity == null)
			return getType().toString()+" (unknown) [observed at: "+date.toString()+"]";
		return getType().toString()+" ("+intensity.toString()+") [observed at: "+date.toString()+"]";
	}
	
	public boolean equals(SolarEvent ev) {
		return (ev != null && intensity != null && 
				intensity.equals(ev.getIntensity()) && date.equals(ev.getDate()));
	}

}
