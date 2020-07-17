/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * Contiene informazioni sull'intensita' specifica di un GeomagConditionsEvent
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class GeomagneticIntensityLevel extends IntensityLevel {

	/**
	 * @return La stringa contenente l'intensita' con l'unita' di misura
	 */
	@Override
	public String getIntensityString() {
		String res = "";
		
		if(value == null)
			return res;
		
		res = "Kp"+Integer.toString(value.intValue());
		
		return res;
	}
	
	
	/**
	 * Costruttore di base
	 */
	public GeomagneticIntensityLevel() {
		super();
	}
	
	/**
	 * 
	 * @param value Il valore dell'intensita'
	 */
	public GeomagneticIntensityLevel(Number value) {
		super(value);
	}
	
	/**
	 * 
	 * @param intensityString La stringa contenente l'intensita'
	 * @param regexString L'espressione regolare per identificare l'intensita'
	 * @throws InvalidIntensityFormatException L'intensita' non e' identificabile in intensityString
	 */
	public GeomagneticIntensityLevel(String intensityString, String regexString) throws InvalidIntensityFormatException {
		Matcher m = Pattern.compile(regexString).matcher(intensityString);
		
		if(m.find()) {
			String content = m.group();
			
			m = Pattern.compile("[0-9]").matcher(content);
			if(m.find())
				value = Integer.parseInt(m.group());
		}
		
		else 
			throw new InvalidIntensityFormatException(getClass().getName()+":Formato intensita' non riconosciuto");
	}

}
