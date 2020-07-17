/**
 * 
 */
package it.oop.SpringBootProject.model.twitter;

/**
 * Rappresenta un oggetto di tipo Coordinates di Twitter
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class Coordinates {
	
	private float[] coordinates;
	private String type;
	
	
	/**
	 * Costruttore di base
	 */
	public Coordinates() {
		coordinates = null;
		type = "";
	}
	
	/**
	 * @param coordinates Array di float [latitudine, longitudine]
	 * @param type Tipo di coordinate
	 */
	public Coordinates(float[] coordinates, String type) {
		this.coordinates = coordinates;
		this.type = type;
	}


	/**
	 * 
	 * @return Le coordinate attuali
	 */
	public float[] getCoordinates() {
		return coordinates;
	}

	/**
	 * 
	 * @param coordinates Le nuove coordinate
	 */
	public void setCoordinates(float[] coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * 
	 * @return Il tipo attuale
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type Il nuovo tipo
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
