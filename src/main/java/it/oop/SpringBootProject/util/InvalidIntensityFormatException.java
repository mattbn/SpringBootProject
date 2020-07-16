/**
 * 
 */
package it.oop.SpringBootProject.util;

/**
 * @author Mattia
 *
 */
@SuppressWarnings("serial")
public class InvalidIntensityFormatException extends Exception {
	
	private String formatRegex;
	
	public InvalidIntensityFormatException() {
		super();
		formatRegex = "";
	}
	
	public InvalidIntensityFormatException(String err) {
		super(err);
		formatRegex = "";
	}
	
	public InvalidIntensityFormatException(String err, String correctFormatRegex) {
		super(err);
		formatRegex = correctFormatRegex;
	}
	
	public String getFormatRegex() {
		return formatRegex;
	}

}
