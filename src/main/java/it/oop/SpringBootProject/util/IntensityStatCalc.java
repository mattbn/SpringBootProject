/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.util.List;

import it.oop.SpringBootProject.model.Date;
import it.oop.SpringBootProject.model.IntensityStat;
import it.oop.SpringBootProject.model.SolarEvent;
import it.oop.SpringBootProject.model.Stat;

/**
 * @author Mattia
 *
 */
public class IntensityStatCalc extends BaseStatCalc {

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
		
		return new IntensityStat(date, values.size(), min, max, avg);
	}
	
	
	public IntensityStatCalc() {
		super();
	}
	
	public IntensityStatCalc(String type, String interval, Object data, Class<?> cls) {
		super("intensity", type, interval, data, cls);
	}

}
