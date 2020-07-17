/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.oop.SpringBootProject.util.InvalidIntensityFormatException;

/**
 * @author Mattia
 *
 */
public class FlareIntensityLevel extends IntensityLevel {
	
	private static final Map<Character, BigDecimal> symbols = Map.of(
			'A', BigDecimal.ONE.divide(BigDecimal.TEN.pow(8)), 
			'B', BigDecimal.ONE.divide(BigDecimal.TEN.pow(7)), 
			'C', BigDecimal.ONE.divide(BigDecimal.TEN.pow(6)), 
			'M', BigDecimal.ONE.divide(BigDecimal.TEN.pow(5)), 
			'X', BigDecimal.ONE.divide(BigDecimal.TEN.pow(4)));
	
	
	public FlareIntensityLevel() {
		super();
	}
	
	public FlareIntensityLevel(Number value) {
		super(value);
	}
	
	public FlareIntensityLevel(String intensityString, String regexString) throws InvalidIntensityFormatException {
		Matcher m = Pattern.compile(regexString).matcher(intensityString);
		
		if(m.find()) {
			String content = m.group();
			
			value = BigDecimal.ZERO;
			BigDecimal k = BigDecimal.ZERO;
			for(Map.Entry<Character,BigDecimal> e : symbols.entrySet())
				if(content.charAt(0) == e.getKey())
					k = e.getValue();
			
			String strVal = m.group();
			value = k.multiply(new BigDecimal(strVal.substring(1,strVal.length())));
		}
		
		else 
			throw new InvalidIntensityFormatException(getClass().getName()+":Formato intensita' non riconosciuto");
	}
	
	
	@Override
	public String getIntensityString() {
		String res = "";
		if(value == null)
			return res;
		
		BigDecimal v = new BigDecimal(value.toString()), 
					k = BigDecimal.ONE;
		
		for(Map.Entry<Character,BigDecimal> e : symbols.entrySet())
			if(v.compareTo(e.getValue()) > 0) {
				res = e.getKey().toString();
				k = BigDecimal.ONE.divide(e.getValue());
			}
		
		res += v.multiply(k).toString();
		
		return res;
	}

}
