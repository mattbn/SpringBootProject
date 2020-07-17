/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class DateDeserializer extends StdDeserializer<Date> {
	
	public DateDeserializer() {
		this(null);
	}
	
	public DateDeserializer(Class<?> cls) {
		super(cls);
	}
	
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext dc) {
		
		Date res = null;
		String dateStr = null;
		
		try {
			dateStr = jp.getText();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//System.out.println(dateStr);
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
		try {
			res = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return res;
		
	}

}
