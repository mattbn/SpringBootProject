/**
 * 
 */
package it.oop.SpringBootProject.model.twitter;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.oop.SpringBootProject.util.CalendarDeserializer;
import it.oop.SpringBootProject.util.DateDeserializer;

/**
 * @author Mattia
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
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isProtectedFlag() {
		return protectedFlag;
	}

	public void setProtectedFlag(boolean protectedFlag) {
		this.protectedFlag = protectedFlag;
	}

	public boolean isVerifiedFlag() {
		return verifiedFlag;
	}

	public void setVerifiedFlag(boolean verifiedFlag) {
		this.verifiedFlag = verifiedFlag;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public int getListedCount() {
		return listedCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}

	public int getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	
}
