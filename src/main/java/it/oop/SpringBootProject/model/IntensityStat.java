/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.Calendar;

/**
 * Contiene i dati relativi alle intensita' di un certo evento solare
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class IntensityStat extends Stat {
	
	private int count;
	private SolarEvent min;
	private SolarEvent max;
	private float average;
	
	
	/**
	 * Costruttore di base
	 */
	public IntensityStat() {
		super();
	}
	
	/**
	 * 
	 * @param date La data di osservazione
	 * @param count Il numero di occorrenze
	 * @param min Il valore minimo
	 * @param max Il valore massimo
	 * @param average Il valor medio
	 */
	public IntensityStat(Calendar date, int count, SolarEvent min, SolarEvent max, float average) {
		super(date);
		
		this.count = count;
		this.min = min;
		this.max = max;
		this.average = average;
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
	
	/**
	 * 
	 * @return Il minimo attuale
	 */
	public SolarEvent getMin() {
		return min;
	}
	
	/**
	 * 
	 * @param min Il nuovo minimo
	 */
	public void setMin(SolarEvent min) {
		this.min = min;
	}
	
	/**
	 * 
	 * @return Il massimo attuale
	 */
	public SolarEvent getMax() {
		return max;
	}
	
	/**
	 * 
	 * @param max Il nuovo massimo
	 */
	public void setMax(SolarEvent max) {
		this.max = max;
	}
	
	/**
	 * 
	 * @return Il valor medio attuale
	 */
	public float getAverage() {
		return average;
	}
	
	/**
	 * 
	 * @param average Il nuovo valor medio
	 */
	public void setAverage(float average) {
		this.average = average;
	}

}
