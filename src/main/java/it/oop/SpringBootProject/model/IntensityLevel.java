/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * @author Mattia
 *
 */
public class IntensityLevel {
	
	protected Number value;
	
	
	public String getIntensityString() {
		return (value == null ? "" : value.toString());
	}
	
	
	public IntensityLevel() {
		value = null;
	}
	
	public IntensityLevel(Number value) {
		this.value = value;
	}
	
	public IntensityLevel(String intensityString, String regexString) throws InvalidIntensityFormatException {
		Matcher m = Pattern.compile(regexString).matcher(intensityString);
		
		if(m.find()) {
			String content = m.group();
			System.out.println(getClass().getName()+":"+content);
			
			m = Pattern.compile("([0-9]+[.])?[0-9]+").matcher(content);
			if(m.find())
				value = Integer.parseInt(m.group());
		}
		
		else 
			throw new InvalidIntensityFormatException(getClass().getName()+":Formato intensita' non riconosciuto");
	}
	

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return getIntensityString();
	}
	
	public int compareTo(IntensityLevel il) {
		if(il != null)
			return new BigDecimal(value.toString()).compareTo(new BigDecimal(il.getValue().toString()));
		
		return 0;
	}
	
}
