/**
 * 
 */
package it.oop.SpringBootProject.util;

/**
 * Interfaccia che definisce il metodo per il calcolo di una certa statistica
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public interface StatCalc {
	
	/**
	 * @param data I dati
	 * @param cls La classe dei dati
	 */
	public void calc(Object data, Class<?> cls);

}
