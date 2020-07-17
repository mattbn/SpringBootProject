/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import it.oop.SpringBootProject.model.FlareEvent;
import it.oop.SpringBootProject.model.GeomagConditionsEvent;
import it.oop.SpringBootProject.model.GeomagStormEvent;
import it.oop.SpringBootProject.model.SolarEvent;

/**
 * @author Mattia
 *
 */
@SuppressWarnings("serial")
public class SolarEventDeserializer extends StdDeserializer<SolarEvent> {
	
	private static final Pattern 	type = Pattern.compile("\"type\": \"[A-Za-z]+"), 
									intRegex = Pattern.compile("\"intensityRegex\": \"[A-Za-z]+?([0-9]+[.])?[0-9]+"), 
									intensity = Pattern.compile("\"intensity\": {"), 
									date = Pattern.compile("\"date\": \"");
	
	private static final Map<String,SolarEvent> events = 
			Map.of("Flare", new FlareEvent(), 
					"GeomagneticConditions", new GeomagConditionsEvent(), 
					"GeomagneticStorm", new GeomagStormEvent());
	
	public SolarEventDeserializer() {
		this(null);
	}
	
	public SolarEventDeserializer(Class<?> cls) {
		super(cls);
	}
	
	@Override
	public SolarEvent deserialize(JsonParser jp, DeserializationContext dc) {
		SolarEvent res = null;
		
		String str = null;
		
		try {
			str = jp.getText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
