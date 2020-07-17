/**
 * 
 */
package it.oop.SpringBootProject.util;

import it.oop.SpringBootProject.model.Stat;

/**
 * Classe base per i calcolatori di statistiche
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public abstract class BaseStatCalc implements StatCalc {
	
	protected String name; // nome della statistica
	protected String type; // tipo di evento
	protected String interval; // intervallo temporale
	
	protected Stat data;
	
	
	/**
	 * Costruttore di base
	 */
	public BaseStatCalc() {
		name = "";
		type = "";
		interval = "";
		data = null;
	}
	
	/**
	 * 
	 * @param name Il nome della statistica
	 * @param type Il tipo di evento
	 * @param interval L'intervallo temporale
	 * @param data I dati
	 * @param cls La classe dei dati
	 */
	public BaseStatCalc(String name, String type, String interval, Object data, Class<?> cls) {
		this.name = name;
		this.type = type;
		this.interval = interval;
		data = null;
	}

	/**
	 * 
	 * @return Il nome attuale
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name Il nuovo nome
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Il tipo attuale
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type Il nuovo tipo
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return L'intervallo attuale
	 */
	public String getInterval() {
		return interval;
	}

	/**
	 * 
	 * @param interval Il nuovo intervallo
	 */
	public void setInterval(String interval) {
		this.interval = interval;
	}

	/**
	 * 
	 * @return I dati attuali
	 */
	public Stat getData() {
		return data;
	}

}
