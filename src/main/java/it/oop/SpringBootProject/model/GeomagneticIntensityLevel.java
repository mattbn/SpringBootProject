/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * @author Mattia
 *
 */
public class GeomagneticIntensityLevel extends IntensityLevel {

	@Override
	public String getIntensityString() {
		String res = "";
		
		if(value == null)
			return res;
		
		res = "Kp"+Integer.toString(value.intValue());
		
		return res;
	}
	
	
	public GeomagneticIntensityLevel() {
		super();
	}
	
	public GeomagneticIntensityLevel(Number value) {
		super(value);
	}
	
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
