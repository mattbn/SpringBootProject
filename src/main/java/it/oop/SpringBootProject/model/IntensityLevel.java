/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * @author Mattia
 *
 */
public class IntensityLevel {
	
	private Number value;
	private String symbol;
	
	
	public IntensityLevel(IntensityLevel lv) {
		if(lv != null) {
			value = lv.getValue();
			symbol = lv.getSymbol();
		}
		
		else {
			value = null;
			symbol = null;
		}
	}
	
	public IntensityLevel(Number value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	
	public IntensityLevel(String intensityString) throws InvalidIntensityFormatException {
		Matcher m1 = Pattern.compile("[0-9]+?[a-zA-Z]").matcher(intensityString), 
				m2 = Pattern.compile("[a-zA-Z]+?[0-9]+").matcher(intensityString);
		String realString = "";
		
		boolean m1f = m1.find();
		
		if(m1f) 
			realString = m1.group();
		
		else if(m2.find())
			realString = m2.group();
		
		else
			throw new InvalidIntensityFormatException("Formato stringa intensita' non valido \""+intensityString+"\"");
		
		String[] parts = realString.split("[0-9]+");
		try {
			value = NumberFormat.getInstance().parse(parts[(m1f ? 0 : 1)]);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new InvalidIntensityFormatException("Impossibile ricavare il valore dell'intensita' da \""+intensityString+"\"");
		}
		
		symbol = parts[(m1f ? 1 : 0)];
	}

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
