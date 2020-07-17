/**
 * 
 */
package it.oop.SpringBootProject.util;

/**
 * Eccezione generata da un'intensita' in formato errrato
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
@SuppressWarnings("serial")
public class InvalidIntensityFormatException extends Exception {
	
	private String formatRegex;
	
	/**
	 * Costruttore di base
	 */
	public InvalidIntensityFormatException() {
		super();
		formatRegex = "";
	}
	
	/**
	 * 
	 * @param err Stringa dell'errore
	 */
	public InvalidIntensityFormatException(String err) {
		super(err);
		formatRegex = "";
	}
	
	/**
	 * 
	 * @param err Stringa dell'errore
	 * @param correctFormatRegex Espressione regolare corretta
	 */
	public InvalidIntensityFormatException(String err, String correctFormatRegex) {
		super(err);
		formatRegex = correctFormatRegex;
	}
	
	/**
	 * 
	 * @return L'espressione regolare corretta
	 */
	public String getFormatRegex() {
		return formatRegex;
	}

}
