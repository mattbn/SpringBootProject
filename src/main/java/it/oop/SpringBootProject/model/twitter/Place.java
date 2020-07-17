/**
 * 
 */
package it.oop.SpringBootProject.model.twitter;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Mattia
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
	 * @param id
	 * @param url
	 * @param placeType
	 * @param name
	 * @param fullName
	 * @param countryCode
	 * @param country
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
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPlaceType() {
		return placeType;
	}
	
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

}
