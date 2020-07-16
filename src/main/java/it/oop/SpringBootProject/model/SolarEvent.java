/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Date;

/**
 * @author Mattia
 *
 */
public abstract class SolarEvent {
	
	private IntensityLevel intensity;
	private Date date; // data di osservazione
	
	
	public abstract EventType getType();
	
	public abstract String getIntensityRegex();
	
	
	public SolarEvent(SolarEvent event) {
		if(event != null) {
			intensity = event.getIntensity();
			date = event.getDate();
		}
		
		else {
			intensity = null;
			date = null;
		}
	}
	
	public SolarEvent(IntensityLevel intensity, Date date) {
		this.intensity = intensity;
		this.date = date;
	}


	public IntensityLevel getIntensity() {
		return intensity;
	}


	public void setIntensity(IntensityLevel intensity) {
		this.intensity = intensity;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return getType().toString()+" ("+intensity.toString()+") [observed at: "+date.toString()+"]";
	}

}
