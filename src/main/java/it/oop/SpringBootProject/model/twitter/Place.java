/**
 * 
 */
package it.oop.SpringBootProject.model.twitter;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Rappresenta un oggetto di tipo Places di Twitter
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
@JsonIgnoreProperties(value = {"bounding_box", "attributes"})
public class Place {
	
	private String id;
	private String url;
	@JsonAlias({"place_type"})
	private String placeType;
	private String name;
	@JsonAlias({"full_name"})
	private String fullName;
	@JsonAlias({"country_code"})
	private String countryCode;
	private String country;
	// nessuna bounding box per ora
	
	
	/**
	 * Costruttore di base
	 */
	public Place() {
		id = "";
		url = "";
		placeType = "";
		name = "";
		fullName = "";
		countryCode = "";
		country = "";
	}
	
	/**
	 * @param id Id del luogo
	 * @param url Url del luogo
	 * @param placeType Tipo di luogo
	 * @param name Nome del luogo 
	 * @param fullName Nome completo del luogo
	 * @param countryCode Country code del luogo
	 * @param country Nome del paese
	 */
	public Place(String id, String url, String placeType, String name, String fullName, String countryCode,
			String country) {
		this.id = id;
		this.url = url;
		this.placeType = placeType;
		this.name = name;
		this.fullName = fullName;
		this.countryCode = countryCode;
		this.country = country;
	}
	
	
	/**
	 * 
	 * @return L'id attuale
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id Il nuovo id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return L'Url attuale
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * 
	 * @param url Il nuovo Url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 
	 * @return Il tipo attuale
	 */
	public String getPlaceType() {
		return placeType;
	}
	
	/**
	 * 
	 * @param placeType Il nuovo tipo
	 */
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	
	/**
	 * 
	 * @return Il nome attuale
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name Il nuovo nome
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return Il nome completo attuale
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 
	 * @param fullName Il nuovo nome completo
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * 
	 * @return Il country code attuale
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	/**
	 * 
	 * @param countryCode Il nuovo country code
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * 
	 * @return Il paese attuale
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * 
	 * @param country Il nuovo paese
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
