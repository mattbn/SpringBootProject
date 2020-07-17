/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * Contiene i dati di una generica statistica
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class Stat {
	
	//protected Date date;
	protected Calendar date;
	
	/**
	 * Costruttore di base
	 */
	public Stat() {
		//date = new Date(Calendar.getInstance());
		date = Calendar.getInstance();
	}
	
	/**
	 * 
	 * @param date La data di osservazione
	 */
	public Stat(Calendar date) {
		this.date = date;
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

}
