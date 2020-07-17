/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.util.List;

import it.oop.SpringBootProject.model.CountStat;
import it.oop.SpringBootProject.model.Date;
import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.model.Stat;

/**
 * @author Mattia
 *
 */
public class CountStatCalc extends BaseStatCalc implements StatCalc {

	@SuppressWarnings("unchecked")
	@Override
	public Stat calc(Object data, Class<?> cls) {
		if(!cls.equals(List.class)) // tipo non valido per questa classe
			throw new IllegalArgumentException(getClass().getName()+":I dati di cui calcolare la statistica devono essere List");
		
		List<SolarEvent> values = (List<SolarEvent>)data;
		Date date = null;
		if(values == null || values.size() == 0)
			date = new Date();
		else
			date = new Date(values.get(0).getDate());
		
		return new CountStat(date, values.size());
	}
	
	
	public CountStatCalc() {
		super();
	}
	
	public CountStatCalc(String type, String interval, Object data, Class<?> cls) {
		super("count", type, interval, data, cls);
	}

}
