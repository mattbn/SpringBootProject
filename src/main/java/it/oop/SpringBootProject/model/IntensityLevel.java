/**
 * 
 */
package it.oop.SpringBootProject.model;

import java.math.BigDecimal;
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
	
	private static final Pattern 	unitAndValue = Pattern.compile("[a-zA-Z]+?([0-9]+[.])?[0-9]+"), 
									valueAndUnit = Pattern.compile("([0-9]+[.])?[0-9]+?[a-zA-Z]"), 
									onlyValue = Pattern.compile("([0-9]+[.])?[0-9]+"), 
									onlySymbol = Pattern.compile("[a-zA-Z]+");
	
	
	public IntensityLevel(Number value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	
	public IntensityLevel(String intensityString) throws InvalidIntensityFormatException {
		Matcher[] m = { 
				unitAndValue.matcher(intensityString), 
				valueAndUnit.matcher(intensityString)
		};
		
		for(int i = 0; i < m.length; ++i) {
			if(m[i].find()) {
				String str = m[i].group();
				Matcher[] m2 = {
						onlyValue.matcher(str), 
						onlySymbol.matcher(str)
				};
				
				if(m2[0].find())
					try {
						value = NumberFormat.getInstance().parse(m2[0].group());
					} catch (ParseException e) {
						value = null;
						e.printStackTrace();
					}
				
				if(m2[1].find()) 
					symbol = m2[1].group();
				
			}
		}
	}
	
	public IntensityLevel(String intensityString, String regex) throws InvalidIntensityFormatException {
		// reset string pos at every check
		
		Matcher m = Pattern.compile(regex).matcher(intensityString);
		if(m.find()) {
			String str = m.group();
			
			Matcher[] m1 = { unitAndValue.matcher(intensityString), 
							valueAndUnit.matcher(intensityString)
			};
			
			for(int i = 0; i < m1.length; ++i) {
				if(m1[i].find()) {str = m1[i].group();
					Matcher[] m2 = {
							onlyValue.matcher(str), 
							onlySymbol.matcher(str)
					};
					
					if(m2[0].find())
						try {
							value = NumberFormat.getInstance().parse(m2[0].group());
						} catch (ParseException e) {
							value = null;
							e.printStackTrace();
						}
					
					if(m2[1].find()) 
						symbol = m2[1].group();
					
				}
			}
		}
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
	
	public boolean equals(IntensityLevel il) {
		if(il == null)
			return false;
		return (symbol.equals(il.getSymbol()) && value.equals(il.getValue()));
	}
	
	public int compareTo(IntensityLevel il) {
		if(il == null || !symbol.equals(il.getSymbol()))
			return 2;
		return (new BigDecimal(value.toString()).compareTo(new BigDecimal(il.getValue().toString())));
	}

}
