/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * @author Mattia
 *
 */
public class Stat {
	
	protected Date date;
	
	
	public Stat() {
		date = new Date(Calendar.getInstance());
	}
	
	public Stat(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

}
