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
 * @author Mattia
 *
 */
@JsonIgnoreProperties(value = {
		"id_str", "truncated", "in_reply_to_status_id", 
		"in_reply_to_status_id_str", "in_reply_to_user_id", 
		"in_reply_to_user_id_str", "in_reply_to_screen_name", 
		"quoted_status_id", "quoted_status_id_str", 
		"is_quote_status", "quoted_status", 
		"entities", "extended_entities", 
		"favorited", "retweeted", "possibly_sensitive", 
		"filter_level", "matching_rules", 
		"current_user_retweet", "scopes", 
		"withheld_copyright", "withheld_in_countries", 
		"withheld_scope", "geo", "contributors"
})
public class Tweet {
	
	@JsonAlias({"created_at"})
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar creationDate;
	private long id;
	/*
	@JsonAlias({"id_str"})
	private String idStr;
	private Long inReplyToStatusId;
	private String inReplyToStatusIdStr;
	private Long inReplyToUserId;
	private String inReplyToUserIdStr;
	private String inReplyToScreenName;
	*/
	private String text;
	private String source;
	private User user;
	private Coordinates coordinates;
	private Place place;
	
	@JsonAlias({"retweeted_status"})
	private Tweet retweetedStatus;
	@JsonAlias({"reply_count"})
	private int replyCount;
	@JsonAlias({"retweet_count"})
	private int retweetCount;
	@JsonAlias({"favorite_count"})
	private Integer favoriteCount;
	private String lang;
	
	
	public Tweet() {
		creationDate = null;
		id = -1;
		text = "";
		source = "";
		user = null;
		coordinates = null;
		place = null;
		retweetedStatus = null;
		replyCount = -1;
		retweetCount = -1;
		favoriteCount = null;
		lang = "";
	}
	
	/**
	 * @param creationDate
	 * @param id
	 * @param text
	 * @param source
	 * @param user
	 * @param coordinates
	 * @param place
	 * @param retweetedStatus
	 * @param replyCount
	 * @param retweetCount
	 * @param favoriteCount
	 * @param lang
	 */
	public Tweet(Calendar creationDate, long id, String text, String source, User user, Coordinates coordinates,
			Place place, Tweet retweetedStatus, int replyCount, int retweetCount, Integer favoriteCount, String lang) {
		this.creationDate = creationDate;
		this.id = id;
		this.text = text;
		this.source = source;
		this.user = user;
		this.coordinates = coordinates;
		this.place = place;
		this.retweetedStatus = retweetedStatus;
		this.replyCount = replyCount;
		this.retweetCount = retweetCount;
		this.favoriteCount = favoriteCount;
		this.lang = lang;
	}
	

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Calendar getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public Place getPlace() {
		return place;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public Tweet getRetweetedStatus() {
		return retweetedStatus;
	}
	
	public void setRetweetedStatus(Tweet retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}
	
	public int getReplyCount() {
		return replyCount;
	}
	
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
	public int getRetweetCount() {
		return retweetCount;
	}
	
	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}
	
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
	
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	public String getLang() {
		return lang;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}

}
