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
 * Contiene informazioni sull'intensita' specifica di un FlareEvent
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class FlareIntensityLevel extends IntensityLevel {
	
	// utile per capire quale unita' di misura usare
	private static final Map<Character, BigDecimal> symbols = Map.of(
			'A', BigDecimal.ONE.divide(BigDecimal.TEN.pow(8)), 
			'B', BigDecimal.ONE.divide(BigDecimal.TEN.pow(7)), 
			'C', BigDecimal.ONE.divide(BigDecimal.TEN.pow(6)), 
			'M', BigDecimal.ONE.divide(BigDecimal.TEN.pow(5)), 
			'X', BigDecimal.ONE.divide(BigDecimal.TEN.pow(4)));
	
	
	/**
	 * Costruttore di base
	 */
	public FlareIntensityLevel() {
		super();
	}
	
	/**
	 * 
	 * @param value Valore dell'intensita'
	 */
	public FlareIntensityLevel(Number value) {
		super(value);
	}
	
	/**
	 * 
	 * @param intensityString Stringa contenente il valore dell'intensita'
	 * @param regexString Espressione regolare per identificare l'intensita'
	 * @throws InvalidIntensityFormatException L'intensita' non e' identificabile in intensityString
	 */
	public FlareIntensityLevel(String intensityString, String regexString) throws InvalidIntensityFormatException {
		Matcher m = Pattern.compile(regexString).matcher(intensityString);
		
		if(m.find()) {
			String content = m.group();
			
			value = BigDecimal.ZERO;
			BigDecimal k = BigDecimal.ZERO;
			// prende l'unita' di misura e fa le relative conversioni
			for(Map.Entry<Character,BigDecimal> e : symbols.entrySet())
				if(content.charAt(0) == e.getKey()) {
					k = e.getValue(); // == 10^(-x)
					symbol = e.getKey().toString();
				}
			
			String strVal = m.group();
			// value = 10^(-x) * moltiplicatore
			value = k.multiply(new BigDecimal(strVal.substring(1,strVal.length())));
		}
		
		else 
			throw new InvalidIntensityFormatException(getClass().getName()+":Formato intensita' non riconosciuto");
	}
	
	
	/**
	 * @return Stringa contenente l'intensita' con unita' di misura
	 */
	@Override
	public String getIntensityString() {
		String res = "";
		if(value == null)
			return res;
		
		BigDecimal v = new BigDecimal(value.toString()), 
					k = BigDecimal.ONE;
		
		// prende l'unita' di misura giusta
		k = BigDecimal.ONE.divide(symbols.get(symbol.charAt(0)));
		res = symbol+v.multiply(k).toString();
		
		return res;
	}

}
