/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * Contiene i dati relativi al numero di occorrenze di un certo evento solare
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class CountStat extends Stat {
	
	private int count;
	
	
	/**
	 * Costruttore di base
	 */
	public CountStat() {
		super();
		count = 0;
	}
	
	/**
	 * 
	 * @param date Data di osservazione
	 * @param count Numero di occorrenze
	 */
	public CountStat(Calendar date, int count) {
		super(date);
		this.count = count;
	}
	
	/**
	 * 
	 * @return Il numero di occorrenze attuale
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * 
	 * @param count Il nuovo numero di occorrenze
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
