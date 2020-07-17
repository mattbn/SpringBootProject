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
 * Rappresenta un oggetto di tipo Tweet di Twitter
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
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
	
	
	/**
	 * Costruttore di base
	 */
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
	 * @param creationDate La data di creazione del tweet
	 * @param id L'id del tweet
	 * @param text Il testo del tweet
	 * @param source La sorgente del tweet
	 * @param user L'autore del tweet
	 * @param coordinates Le coordinate del tweet
	 * @param place Il luogo del tweet
	 * @param retweetedStatus Il tweet originale di questo retweet
	 * @param replyCount Il numero di risposte
	 * @param retweetCount Il numero di retweet
	 * @param favoriteCount Il numero di likes
	 * @param lang La lingua del tweet
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
	

	/**
	 * 
	 * @return Il testo attuale
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * 
	 * @param text Il nuovo testo
	 */
	public void setText(String text) {
		this.text = text;
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
	 * @return La sorgente attuale
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * 
	 * @param source La nuova sorgente
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * 
	 * @return L'autore attuale
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * 
	 * @param user Il nuovo autore
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return Le coordinate attuali
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	/**
	 * 
	 * @param coordinates Le nuove coordinate
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	/**
	 * 
	 * @return Il luogo attuale
	 */
	public Place getPlace() {
		return place;
	}
	
	/**
	 * 
	 * @param place Il nuovo luogo
	 */
	public void setPlace(Place place) {
		this.place = place;
	}
	
	/**
	 * 
	 * @return Il tweet originale di questo retweet attuale
	 */
	public Tweet getRetweetedStatus() {
		return retweetedStatus;
	}
	
	/**
	 * 
	 * @param retweetedStatus Il nuovo tweet originale di questo retweet
	 */
	public void setRetweetedStatus(Tweet retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}
	
	/**
	 * 
	 * @return Il numero di risposte attuale
	 */
	public int getReplyCount() {
		return replyCount;
	}
	
	/**
	 * 
	 * @param replyCount Il nuovo numero di risposte
	 */
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
	/**
	 * 
	 * @return Il numero di retweet attuale
	 */
	public int getRetweetCount() {
		return retweetCount;
	}
	
	/**
	 * 
	 * @param retweetCount Il nuovo numero di retweet
	 */
	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}
	
	/**
	 * 
	 * @return Il numero di likes attuali
	 */
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
	
	/**
	 * 
	 * @param favoriteCount Il nuovo numero di likes
	 */
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	/**
	 * 
	 * @return La lingua del tweet attuale
	 */
	public String getLang() {
		return lang;
	}
	
	/**
	 * 
	 * @param lang La nuova lingua del tweet
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

}
