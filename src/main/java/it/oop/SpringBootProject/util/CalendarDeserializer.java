/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author Mattia
 *
 */
@SuppressWarnings("serial")
public class CalendarDeserializer extends StdDeserializer<Calendar> {
	
	public CalendarDeserializer() {
		this(null);
	}
	
	public CalendarDeserializer(Class<?> cls) {
		super(cls);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Calendar deserialize(JsonParser jp, DeserializationContext dc) {
		
		Calendar res = Calendar.getInstance();
		String dateStr = null;
		
		try {
			dateStr = jp.getText();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//System.out.println(dateStr);
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
		try {
			Date d = sdf.parse(dateStr);
			
			res.set(Calendar.YEAR, d.getYear());
			res.set(Calendar.MONTH, d.getMonth());
			res.set(Calendar.DAY_OF_MONTH, d.getDate());
			res.set(Calendar.HOUR, d.getHours());
			res.set(Calendar.MINUTE, d.getMinutes());
			res.set(Calendar.SECOND, d.getSeconds());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return res;
		
	}

}
