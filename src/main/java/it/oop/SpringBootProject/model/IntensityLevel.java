/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * Rappresenta una generica intensita'
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class IntensityLevel {
	
	protected Number value;
	
	@JsonIgnore
	protected String symbol;
	
	/**
	 * 
	 * @return La stringa contenente l'intensita' con l'unita' di misura
	 */
	public String getIntensityString() {
		return (value == null ? "" : value.toString());
	}
	
	
	/**
	 * Costruttore di base
	 */
	public IntensityLevel() {
		value = null;
	}
	
	/**
	 * 
	 * @param value Il valore dell'intensita'
	 */
	public IntensityLevel(Number value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @param intensityString La stringa contenente l'intensita'
	 * @param regexString L'espressione regolare per identificare l'intensita'
	 * @throws InvalidIntensityFormatException L'intensita' non e' identificabile in intensityString
	 */
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
	
	
	/**
	 * 
	 * @return Il valore attuale
	 */
	public Number getValue() {
		return value;
	}

	/**
	 * 
	 * @param value Il nuovo valore
	 */
	public void setValue(Number value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return getIntensityString();
	}
	
	/**
	 * 
	 * @param il Oggetto IntensityLevel su cui effettuare il confronto
	 * @return -1 se il.getValue() e' maggiore di this.getValue(), 0 se i valori sono uguali, 1 altrimenti
	 */
	public int compareTo(IntensityLevel il) {
		if(il != null)
			return new BigDecimal(value.toString()).compareTo(new BigDecimal(il.getValue().toString()));
		
		return 0;
	}
	
}
