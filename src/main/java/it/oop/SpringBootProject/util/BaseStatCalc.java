/**
 * 
 */
package it.oop.SpringBootProject.util;

import it.oop.SpringBootProject.model.Stat;

/**
 * @author Mattia
 *
 */
public abstract class BaseStatCalc implements StatCalc {
	
	protected String name; // nome della statistica
	protected String type; // tipo di evento
	protected String interval; // intervallo temporale
	
	protected Stat data;
	
	
	public BaseStatCalc() {
		name = "";
		type = "";
		interval = "";
		data = null;
	}
	
	public BaseStatCalc(String name, String type, String interval, Object data, Class<?> cls) {
		this.name = name;
		this.type = type;
		this.interval = interval;
		data = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public Stat getData() {
		return data;
	}

}
