/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public abstract class SolarEvent {
	
	private IntensityLevel intensity;
	private Calendar date; // data di osservazione
	
	
	public abstract EventType getType();
	
	public abstract String getIntensityRegex();
	
	
	public SolarEvent() {
		intensity = new IntensityLevel(0, "");
		date = Calendar.getInstance();
	}
	
	public SolarEvent(SolarEvent event) {
		if(event != null) {
			intensity = event.getIntensity();
			date = event.getDate();
		}
		
		else {
			intensity = new IntensityLevel(0, "");
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
		return getType().toString()+" ("+intensity.toString()+") [observed at: "+date.toString()+"]";
	}
	
	public boolean equals(SolarEvent ev) {
		return (intensity.equals(ev.getIntensity()) && date.equals(ev.getDate()));
	}

}
