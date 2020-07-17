/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.util.Calendar;
import java.util.List;

import it.oop.SpringBootProject.model.CountStat;
import it.oop.SpringBootProject.model.SolarEvent;

/**
 * Calcola la statistica sul numero di eventi
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class CountStatCalc extends BaseStatCalc implements StatCalc {

	@SuppressWarnings("unchecked")
	@Override
	public void calc(Object data, Class<?> cls) {
		if(!cls.equals(List.class)) // tipo non valido per questa classe
			throw new IllegalArgumentException(getClass().getName()+":I dati di cui calcolare la statistica devono essere List");
		
		List<SolarEvent> values = (List<SolarEvent>)data;
		/*
		Date date = null;
		if(values == null || values.size() == 0)
			date = new Date();
		else
			date = new Date(values.get(0).getDate());
		*/
		
		Calendar date = Calendar.getInstance();
		if(values != null && values.size() > 0)
			date = values.get(0).getDate();
		
		this.data = new CountStat(date, values.size());
	}
	
	
	/**
	 * Costruttore di base
	 */
	public CountStatCalc() {
		super();
	}
	
	/**
	 * 
	 * @param type Il tipo di evento
	 * @param interval L'intervallo 
	 * @param data I dati
	 * @param cls La classe dei dati
	 */
	public CountStatCalc(String type, String interval, Object data, Class<?> cls) {
		super("count", type, interval, data, cls);
		calc(data, cls);
	}

}
