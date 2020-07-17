/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.util.Calendar;
import java.util.List;

import it.oop.SpringBootProject.model.IntensityStat;
import it.oop.SpringBootProject.model.SolarEvent;

/**
 * Calcola la statistica relativa alle intensita' di un evento
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class IntensityStatCalc extends BaseStatCalc {

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
		
		SolarEvent min = null, max = null;
		float avg = 0;
		
		for(SolarEvent ev : values) {
			if(min == null || ev.getIntensity().compareTo(min.getIntensity()) == -1)
				min = ev;
			
			if(max == null || ev.getIntensity().compareTo(max.getIntensity()) == 1)
				max = ev;
			
			avg += ev.getIntensity().getValue().floatValue();
		}
		
		avg /= (values.size() + (values.size() == 0 ? 1 : 0));
		/*
		System.out.println("IntensityStatCalc:\ndate : "+date.toString()+"\nvalues.size() : "+Integer.toString(values.size()));
		System.out.println("min : "+ min+"\nmax : "+max);
		System.out.println("avg : "+ Float.toString(avg));
		*/
		this.data = new IntensityStat(date, values.size(), min, max, avg);
	}
	
	/**
	 * Costruttore di base
	 */
	public IntensityStatCalc() {
		super();
	}
	
	/**
	 * 
	 * @param type Il tipo di evento
	 * @param interval L'intervallo
	 * @param data I dati
	 * @param cls La classe dei dati
	 */
	public IntensityStatCalc(String type, String interval, Object data, Class<?> cls) {
		super("intensity", type, interval, data, cls);
		calc(data, cls);
	}

}
