/**
 * 
 */
package it.oop.SpringBootProject.model.twitter;

/**
 * @author Mattia
 *
 */
public class Coordinates {
	
	private float[] coordinates;
	private String type;
	
	
	public Coordinates() {
		coordinates = null;
		type = "";
	}
	
	public Coordinates(float[] coordinates, String type) {
		this.coordinates = coordinates;
		this.type = type;
	}


	public float[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(float[] coordinates) {
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
