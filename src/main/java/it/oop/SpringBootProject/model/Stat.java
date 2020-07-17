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
	
	//protected Date date;
	protected Calendar date;
	
	public Stat() {
		//date = new Date(Calendar.getInstance());
		date = Calendar.getInstance();
	}
	
	public Stat(Calendar date) {
		this.date = date;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}

}
