/**
 * 
 */
package it.oop.SpringBootProject.model.twitter;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.oop.SpringBootProject.util.CalendarDeserializer;

/**
 * Rappresenta un oggetto di tipo User di Twitter
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
@JsonIgnoreProperties(value = {
		"id_str", "profile_banner_url", "profile_image_url_https", 
		"default_profile", "default_profile_image", "withheld_in_countries", 
		"withheld_scope", "entities", "utc_offset", "time_zone", 
		"lang", "geo_enabled", "following", "follow_request_sent", 
		"has_extended_profile", "notifications", "profile_location", 
		"contributors_enabled", "profile_image_url", "profile_background_color", 
		"profile_background_image_url", "profile_background_image_url_https", 
		"profile_background_tile", "profile_link_color", "profile_sidebar_border_color", 
		"profile_sidebar_fill_color", "profile_text_color", "profile_use_background_image", 
		"is_translator", "is_translation_enabled", "translator_type"
})
public class User {
	
	private long id;
	private String name;
	
	@JsonAlias({"screen_name"})
	private String screenName;
	
	private String location;
	private String url;
	private String description;
	
	@JsonAlias({"protected"})
	private boolean protectedFlag;
	
	@JsonAlias({"verified"})
	private boolean verifiedFlag;
	
	@JsonAlias({"followers_count"})
	private int followersCount;
	@JsonAlias({"friends_count"})
	private int friendsCount;
	@JsonAlias({"listed_count"})
	private int listedCount;
	@JsonAlias({"favourites_count"})
	private int favoritesCount;
	@JsonAlias({"statuses_count"})
	private int statusesCount;
	@JsonAlias({"created_at"})
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar creationDate;
	
	
	/**
	 * Costruttore di base
	 */
	public User() {
		id = -1;
		name = "";
		screenName = "";
		location = "";
		url = "";
		description = "";
		protectedFlag = false;
		verifiedFlag = false;
		followersCount = -1;
		friendsCount = -1;
		favoritesCount = -1;
		statusesCount = -1;
		listedCount = -1;
		creationDate = Calendar.getInstance();
	}
	

	/**
	 * 
	 * @return L'id attuale
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id Il nuovo id
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return Il tag utente attuale
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * 
	 * @param screenName Il nuovo tag utente
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * 
	 * @return Il luogo attuale
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location Il nuovo luogo
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return La descrizione attuale
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description La nuova descrizione
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return L'attuale stato della flag protectedFlag
	 */
	public boolean isProtectedFlag() {
		return protectedFlag;
	}
	
	/**
	 * 
	 * @param protectedFlag Il nuovo stato della flag protectedFlag
	 */
	public void setProtectedFlag(boolean protectedFlag) {
		this.protectedFlag = protectedFlag;
	}

	/**
	 * 
	 * @return L'attuale stato della flag verifiedFlag
	 */
	public boolean isVerifiedFlag() {
		return verifiedFlag;
	}

	/**
	 * 
	 * @param verifiedFlag Il nuovo stato della flag verifiedFlag
	 */
	public void setVerifiedFlag(boolean verifiedFlag) {
		this.verifiedFlag = verifiedFlag;
	}

	/**
	 * 
	 * @return Il numero di followers attuale
	 */
	public int getFollowersCount() {
		return followersCount;
	}

	/**
	 * 
	 * @param followersCount Il nuovo numero di followers
	 */
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	/**
	 * 
	 * @return Il numero di seguiti attuale
	 */
	public int getFriendsCount() {
		return friendsCount;
	}

	/**
	 * 
	 * @param friendsCount Il nuovo numero di seguiti
	 */
	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	/**
	 * 
	 * @return Il numero di liste pubbliche attuale
	 */
	public int getListedCount() {
		return listedCount;
	}

	/**
	 * 
	 * @param listedCount Il nuovo numero di liste pubbliche
	 */
	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}

	/**
	 * 
	 * @return Il numero di likes attuale
	 */
	public int getFavoritesCount() {
		return favoritesCount;
	}

	/**
	 * 
	 * @param favoritesCount Il nuovo numero di likes
	 */
	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	/**
	 * 
	 * @return Il numero di status attuali
	 */
	public int getStatusesCount() {
		return statusesCount;
	}

	/**
	 * 
	 * @param statusesCount Il nuovo numero di status
	 */
	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	/**
	 * 
	 * @return La data attuale
	 */
	public Calendar getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 * @param creationDate La nuova data
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	
}
